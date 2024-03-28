
(ns pretty-elements.methods.dynamic.import
    (:require [component-props.api :as component-props]
              [dynamic-props.api :as dynamic-props]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-element-dynamic-props
  ; @links
  ; [cljs-component-props](https://mt-app-kit.github.io/cljs-component-props)
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
  (component-props/import-props id props))
