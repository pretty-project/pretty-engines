
(ns pretty-elements.methods.presets.apply
    (:require [preset-props.api :as preset-props]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn apply-element-presets
  ; @description
  ; Applies its presets (if any) on the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (apply-element-presets :my-element {...})
  ;
  ; @return (map)
  [_ props]
  (preset-props/apply-presets props))
