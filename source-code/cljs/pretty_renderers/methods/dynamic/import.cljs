
(ns pretty-renderers.methods.dynamic.import
    (:require [pretty-elements.methods.api :as pretty-elements.methods]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-renderer-dynamic-props
  ; @links
  ; [cljc-dynamic-props](https://mt-app-kit.github.io/cljc-dynamic-props)
  ;
  ; @description
  ; Associates the dynamic properties of the renderer to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-renderer-dynamic-props :my-renderer {...})
  ;
  ; @return (map)
  [id props]
  (pretty-elements.methods/import-element-dynamic-props id props))
