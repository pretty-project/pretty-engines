
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
  (let [set-reference-f (fn [%] (react-references/set-reference! id %))]
       (assoc props :set-reference-f set-reference-f)))
