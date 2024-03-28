
(ns pretty-elements.methods.presets.apply
    (:require [component-props.api :as component-props]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn apply-element-presets
  ; @links
  ; [cljs-component-props](https://mt-app-kit.github.io/cljs-component-props)
  ;
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
  (component-props/apply-presets props))
