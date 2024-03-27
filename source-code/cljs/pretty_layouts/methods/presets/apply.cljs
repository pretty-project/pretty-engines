
(ns pretty-layouts.methods.presets.apply
    (:require [pretty-elements.methods.api :as pretty-elements.methods]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn apply-layout-presets
  ; @description
  ; Applies its presets (if any) on the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (apply-layout-presets :my-layout {...})
  ;
  ; @return (map)
  [id props]
  (pretty-elements.methods/apply-element-presets id props))
