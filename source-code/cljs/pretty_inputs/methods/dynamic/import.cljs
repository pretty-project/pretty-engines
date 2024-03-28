
(ns pretty-inputs.methods.dynamic.import
    (:require [pretty-elements.methods.api :as pretty-elements.methods]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-input-dynamic-props
  ; @links
  ; [cljs-component-props](https://mt-app-kit.github.io/cljs-component-props)
  ;
  ; @description
  ; Associates the dynamic properties of the input to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-input-dynamic-props :my-element {...})
  ;
  ; @return (map)
  [id props]
  (pretty-elements.methods/import-element-dynamic-props id props))
