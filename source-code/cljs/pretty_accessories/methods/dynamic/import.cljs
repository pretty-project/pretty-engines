
(ns pretty-accessories.methods.dynamic.import
    (:require [pretty-elements.methods.api :as pretty-elements.methods]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-accessory-dynamic-props
  ; @links
  ; [cljs-component-props](https://mt-app-kit.github.io/cljs-component-props)
  ;
  ; @description
  ; Associates the dynamic properties of the accessory to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-accessory-dynamic-props :my-accessory {...})
  ;
  ; @return (map)
  [id props]
  (pretty-elements.methods/import-element-dynamic-props id props))
