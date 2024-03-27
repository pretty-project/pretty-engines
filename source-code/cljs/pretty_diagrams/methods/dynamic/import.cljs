
(ns pretty-diagrams.methods.dynamic.import
    (:require [pretty-elements.methods.api :as pretty-elements.methods]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-diagram-dynamic-props
  ; @links
  ; [cljc-dynamic-props](https://mt-app-kit.github.io/cljc-dynamic-props)
  ;
  ; @description
  ; Associates the dynamic properties of the diagram to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-diagram-dynamic-props :my-diagram {...})
  ;
  ; @return (map)
  [id props]
  (pretty-elements.methods/import-element-dynamic-props id props))
