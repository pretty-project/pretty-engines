
(ns pretty-inputs.engine.options.env
    (:require [common-state.api                   :as common-state]
              [fruits.string.api                  :as string]
              [fruits.vector.api                  :as vector]
              [multitype-content.api              :as multitype-content]
              [pretty-inputs.engine.options.utils :as options.utils]
              [pretty-inputs.engine.value.env     :as value.env]
              [pretty-subitems.api                :as pretty-subitems]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn input-option-filtered?
  ; @description
  ; Returns TRUE if the given option is filtered (displayed).
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:option-filter-f (function)(opt)
  ;  ...}
  ; @param (integer) dex
  ; @param (*) option
  ;
  ; @usage
  ; (input-option-filtered? :my-input {...} 0 {...})
  ;
  ; @return (boolean)
  [_ {:keys [option-filter-f]} _ option]
  (or (-> option-filter-f ifn? not)
      (-> option option-filter-f)))

(defn get-input-filtered-options
  ; @description
  ; Returns the filtered (displayed) options of the input.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:options (vector)(opt)
  ;  ...}
  ;
  ; @usage
  ; (get-input-filtered-options :my-input {...})
  ;
  ; @return (vector)
  [id {:keys [options] :as props}]
  (letfn [(f0 [dex option] (input-option-filtered? id props dex option))]
         (vector/keep-items-by options f0 {:provide-dex? true})))

(defn any-input-option-filtered?
  ; @description
  ; Returns TRUE if option of the input is filtered (displayed).
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (any-input-option-filtered? :my-input {...})
  ;
  ; @return (boolean)
  [id props]
  (let [filtered-options (get-input-filtered-options id props)]
       (vector/not-empty? filtered-options)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn multiple-input-options-selectable?
  ; @description
  ; Returns TRUE if multiple options of the input are selectable at a time.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:max-selection (integer)(opt)
  ;  :options (maps in vector)(opt)
  ;  ...}
  ;
  ; @usage
  ; (multiple-input-options-selectable? :my-input {...})
  ;
  ; @return (boolean)
  [id {:keys [max-selection options] :as props}]
  (and (vector/item-count-min? options 2)
       (or (-> max-selection integer? not)
           (-> max-selection (> 1))
           (-> max-selection (< 0)))))

(defn max-input-selection-not-reached?
  ; @description
  ; Returns TRUE if the selected option count is not reached the maximum selection count.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:max-selection (integer)(opt)
  ;  ...}
  ;
  ; @usage
  ; (max-input-selection-not-reached? :my-input {...})
  ;
  ; @return (boolean)
  [id {:keys [max-selection] :as props}]
  (let [input-displayed-value (value.env/get-input-displayed-value id props)]
       (or (-> input-displayed-value vector? not)
           (-> input-displayed-value count (not= max-selection)))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-input-option-selection
  ; @description
  ; Returns the selected option or options of the input; depending on whether a single option or multiple options can be selected at a time.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (get-input-option-selection :my-input {...})
  ;
  ; @return (* or vector)
  [id props]
  (if (multiple-input-options-selectable?  id props)
      (value.env/get-input-displayed-value id props)
      (value.env/get-input-displayed-value id props)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn input-option-selected?
  ; @description
  ; Returns TRUE if the given option is marked as selected.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; @param (integer) dex
  ; @param (*) option
  ;
  ; @usage
  ; (input-option-selected? :my-input {...} 0 {...})
  ;
  ; @return (boolean)
  [id props dex option]
  (let [input-displayed-value (value.env/get-input-displayed-value id props)
        option-value          (options.utils/input-option-value    id props dex option)]
       (if (multiple-input-options-selectable? id props)
           (-> input-displayed-value (vector/contains-item? option-value))
           (-> input-displayed-value (=                     option-value)))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-input-option-highlighting
  ; @description
  ; Returns the index of the highlighted option (if any) of the input.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; @param (integer) dex
  ; @param (*) option
  ;
  ; @usage
  ; (get-input-option-highlighting :my-input {...})
  ;
  ; @return (integer)
  [id props]
  (common-state/get-state :pretty-ui id :highlighted-option))

(defn get-input-highlighted-option
  ; @description
  ; Returns the the highlighted option (if any) of the input.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; @param (integer) dex
  ; @param (*) option
  ;
  ; @usage
  ; (get-input-highlighted-option :my-input {...})
  ;
  ; @return (*)
  [id props]
  (let [filtered-options (get-input-filtered-options id props)]
       (if-let [option-highlighting (get-input-option-highlighting id props)]
               (vector/nth-item filtered-options option-highlighting))))

(defn input-option-highlighted?
  ; @description
  ; Returns TRUE if the given option is marked as highlighted (in the input state).
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; @param (integer) dex
  ; @param (*) option
  ;
  ; @usage
  ; (input-option-highlighted? :my-input {...} 0 {...})
  ;
  ; @return (boolean)
  [id props dex _]
  (if-let [highlighted-option (get-input-option-highlighting id props)]
          (= dex highlighted-option)))
