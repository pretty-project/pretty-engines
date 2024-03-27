
(ns pretty-inputs.engine.options.side-effects
    (:require [common-state.api                        :as common-state]
              [fruits.mixed.api                        :as mixed]
              [fruits.seqable.api                      :as seqable]
              [fruits.vector.api                       :as vector]
              [pretty-inputs.engine.options.env        :as options.env]
              [pretty-inputs.engine.options.utils      :as options.utils]
              [pretty-inputs.engine.value.env          :as value.env]
              [pretty-inputs.engine.value.side-effects :as value.side-effects]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn toggle-input-option-selection!
  ; @description
  ; Marks / unmarks the given input option as selected (in the input state).
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; @param (integer) dex
  ; @param (*) option
  ;
  ; @usage
  ; (toggle-input-option-selection! :my-input {...} 0 {...})
  [id {:keys [on-selected-f on-unselected-f] :as props} dex option]
  (let [input-displayed-value (value.env/get-input-displayed-value id props)
        option-value          (options.utils/input-option-value    id props dex option)]
       (cond (options.env/input-option-selected? id props dex option)
             (let [input-updated-value (if (options.env/multiple-input-options-selectable? id props)
                                           (-> input-displayed-value mixed/to-vector (vector/remove-item option-value))
                                           (-> nil))]
                  (value.side-effects/set-input-value! id props input-updated-value)
                  (if on-unselected-f (on-unselected-f input-updated-value)))
             (options.env/max-input-selection-not-reached? id props)
             (let [input-updated-value (if (options.env/multiple-input-options-selectable? id props)
                                           (-> input-displayed-value mixed/to-vector (vector/conj-item option-value))
                                           (-> option-value))]
                  (value.side-effects/set-input-value! id props input-updated-value)
                  (if on-selected-f (on-selected-f input-updated-value))))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn discard-input-option-highlighting!
  ; @description
  ; Discards the option highlighting of the input (in the input state).
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (discard-input-option-highlighting! :my-input {...})
  [id _]
  (common-state/dissoc-state! :pretty-ui id :highlighted-option))

(defn highlight-input-prev-option!
  ; @description
  ; Marks the previous option of the input as highlighted (in the input state).
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (highlight-input-prev-option! :my-input {...})
  [id {:keys [options] :as props}]
  (let [filtered-options    (options.env/get-input-filtered-options    id props)
        option-highlighting (options.env/get-input-option-highlighting id props)
        last-dex            (seqable/last-dex filtered-options)]
       (cond (-> filtered-options empty?)   (common-state/dissoc-state! :pretty-ui id :highlighted-option)
             (-> option-highlighting nil?)  (common-state/assoc-state!  :pretty-ui id :highlighted-option last-dex)
             (-> option-highlighting zero?) (common-state/assoc-state!  :pretty-ui id :highlighted-option last-dex)
             :highlight-prev (common-state/update-state! :pretty-ui id update :highlighted-option dec))))

(defn highlight-input-next-option!
  ; @description
  ; Marks the next option of the input as highlighted (in the input state).
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (highlight-input-next-option! :my-input {...})
  [id {:keys [options] :as props}]
  (let [filtered-options    (options.env/get-input-filtered-options    id props)
        option-highlighting (options.env/get-input-option-highlighting id props)
        first-dex           (seqable/first-dex filtered-options)]
       (cond (-> filtered-options empty?)                             (common-state/dissoc-state! :pretty-ui id :highlighted-option)
             (-> option-highlighting nil?)                            (common-state/assoc-state!  :pretty-ui id :highlighted-option first-dex)
             (-> filtered-options count dec (<= option-highlighting)) (common-state/assoc-state!  :pretty-ui id :highlighted-option first-dex)
             :highlight-next (common-state/update-state! :pretty-ui id update :highlighted-option inc))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn mark-input-option-as-highlighted!
  ; @description
  ; Marks the given input option as highlighted (in the input state).
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; @param (integer) dex
  ; @param (*) option
  ;
  ; @usage
  ; (mark-input-option-as-highlighted! :my-input {...} 0 {...})
  [id _ dex _]
  (common-state/assoc-state! :pretty-ui id :highlighted-option dex))
