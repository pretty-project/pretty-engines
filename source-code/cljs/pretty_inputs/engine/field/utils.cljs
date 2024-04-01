
(ns pretty-inputs.engine.field.utils
    (:require [dom.api           :as dom]
              [fruits.string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn on-input-event->field-value
  ; @description
  ; Derives the actual field content from the given DOM input event.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:field-type (keyword)(opt)
  ;  :max-length (integer)(opt)
  ;  :field-modifier-f (function)(opt)
  ;  ...}
  ; @param (DOM-event) input-event
  ;
  ; @return (string)
  [_ {:keys [field-type field-modifier-f max-length]} input-event]
  (let [field-value (if field-modifier-f (-> input-event dom/get-event-value field-modifier-f)
                                         (-> input-event dom/get-event-value))]
       ; https://stackoverflow.com/questions/9555143/html-maxlength-attribute-not-working-on-chrome-and-safari
       (if (and max-length (= field-type :number))
           (-> field-value (string/max-length max-length))
           (-> field-value))))
