
(ns pretty-inputs.methods.options.import
    (:require [fruits.map.api           :as map]
              [fruits.vector.api        :as vector]
              [pretty-inputs.engine.api :as pretty-inputs.engine]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-input-option-controls
  ; @description
  ; ...
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-input-option-controls :my-input {...})
  ;
  ; @return (map)
  [id props]
  (-> props))

(defn import-input-option-events
  ; @description
  ; Associates the input option related events to each option within the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-input-option-events :my-input {...})
  ;
  ; @return (map)
  [id props]
  (letfn [(f0 [dex option] (assoc option :on-click-f #(f1 dex option)))
          (f1 [dex option] (pretty-inputs.engine/toggle-input-option-selection! id props dex option))]
         (-> props (update :options vector/->items f0 {:provide-dex? true}))))

(defn import-input-option-filtering
  ; @description
  ; Filters options in the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-input-option-filtering :my-input {...})
  ;
  ; @return (map)
  [id props]
  (letfn [(f0 [dex option] (pretty-inputs.engine/input-option-filtered? id props dex option))]
         (-> props (update :options vector/keep-items-by f0 {:provide-dex? true}))))

(defn import-input-option-highlighting
  ; @description
  ; Associates the '{:highlighted? true}' setting to the highlighted option in the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-input-option-highlighting :my-input {...})
  ;
  ; @return (map)
  [id props]
  (letfn [(f0 [dex option] (map/assoc-some option :highlighted? (f1 dex option)))
          (f1 [dex option] (pretty-inputs.engine/input-option-highlighted? id props dex option))]
         (-> props (update :options vector/->items f0 {:provide-dex? true}))))

(defn import-input-option-selection
  ; @description
  ; Merges the 'option-selected' properties onto the selected option(s) within the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:option-selected (map)
  ;  ...}
  ;
  ; @usage
  ; (import-input-option-selection :my-input {...})
  ;
  ; @return (map)
  [id {:keys [option-selected] :as props}]
  (letfn [(f0 [dex option] (if (pretty-inputs.engine/input-option-selected? id props dex option)
                               (-> option (map/deep-merge option-selected))
                               (-> option)))]
         (-> props (update :options vector/->items f0 {:provide-dex? true}))))
