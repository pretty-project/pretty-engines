
(ns pretty-layouts.methods.dynamic.import
    (:require [pretty-elements.methods.api :as pretty-elements.methods]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-layout-dynamic-props
  ; @links
  ; [cljs-component-props](https://mt-app-kit.github.io/cljs-component-props)
  ;
  ; @description
  ; Associates the dynamic properties of the layout to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-layout-dynamic-props :my-layout {...})
  ;
  ; @return (map)
  [id props]
  (pretty-elements.methods/import-element-dynamic-props id props))
