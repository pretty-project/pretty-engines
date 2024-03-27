
(ns pretty-inputs.methods.focus.import
    (:require [pretty-elements.methods.api :as pretty-elements.methods]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-input-focus-reference
  ; @description
  ; Associates the react reference function of the input to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-input-focus-reference :my-input {...})
  ;
  ; @return (map)
  [id props]
  (pretty-elements.methods/import-element-focus-reference id props))
