
(ns pretty-accessories.methods.presets.apply
    (:require [pretty-elements.methods.api :as pretty-elements.methods]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn apply-accessory-presets
  ; @description
  ; Applies its presets (if any) on the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (apply-accessory-presets :my-accessory {...})
  ;
  ; @return (map)
  [id props]
  (pretty-elements.methods/apply-element-presets id props))
