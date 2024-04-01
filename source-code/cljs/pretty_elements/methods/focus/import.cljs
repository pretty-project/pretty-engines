
(ns pretty-elements.methods.focus.import
    (:require [react-references.api :as react-references]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-element-focus-reference
  ; @description
  ; Associates the react reference function of the element to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-element-focus-reference :my-element {...})
  ;
  ; @return (map)
  [id props]
  (let [store-reference-f (fn [%] (react-references/store-reference! id %))]
       (assoc props :store-reference-f store-reference-f)))
