
(ns pretty-inputs.engine.field.env
    (:require [pretty-inputs.engine.value.env :as value.env]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-input-field-displayed-content
  ; @description
  ; Returns the displayed content of the input field.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (get-input-field-displayed-content :my-input {...})
  ;
  ; @return (string)
  [id props]
  (let [input-displayed-value (value.env/get-input-displayed-value id props)]
       (str input-displayed-value)))

(defn input-field-empty?
  ; @description
  ; Returns TRUE if the input field is empty.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (get-input-field-displayed-content :my-input {...})
  ;
  ; @return (boolean)
  [id props]
  (let [input-field-displayed-content (get-input-field-displayed-content id props)]
       (empty? input-field-displayed-content)))
