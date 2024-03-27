
(ns pretty-elements.methods.dynamic.import
    (:require [dynamic-props.api :as dynamic-props]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-element-dynamic-props
  ; @links
  ; [cljc-dynamic-props](https://mt-app-kit.github.io/cljc-dynamic-props)
  ;
  ; @description
  ; Associates the dynamic properties of the element to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-element-dynamic-props :my-element {...})
  ;
  ; @return (map)
  [id props]
  (dynamic-props/import-props id props))
