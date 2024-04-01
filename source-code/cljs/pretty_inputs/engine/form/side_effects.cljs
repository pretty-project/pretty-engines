
(ns pretty-inputs.engine.form.side-effects
    (:require [form-validator.api             :as form-validator]
              [pretty-inputs.engine.value.env :as value.env]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn reg-form-input!
  ; @links
  ; [cljc-form-validator](https://mt-app-kit.github.io/cljc-form-validator)
  ;
  ; @description
  ; Registers the input in the form validator.
  ;
  ; @param (keyword) id
  ; @param (keyword) props
  ;
  ; @usage
  ; (reg-form-input! :my-input {...})
  [id props]
  (let [get-value-f #(value.env/get-input-displayed-value id props)]
       (form-validator/reg-input! id (-> props (select-keys [:form-id :validators])
                                               (assoc :get-value-f get-value-f)))))

(defn dereg-form-input!
  ; @links
  ; [cljc-form-validator](https://mt-app-kit.github.io/cljc-form-validator)
  ;
  ; @description
  ; Deregisters the input from the form validator.
  ;
  ; @param (keyword) id
  ; @param (keyword) props
  ;
  ; @usage
  ; (dereg-form-input! :my-input {...})
  [id props]
  (form-validator/dereg-input! id))
