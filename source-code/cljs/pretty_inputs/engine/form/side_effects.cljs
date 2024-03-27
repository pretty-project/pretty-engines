
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
       (form-validator/reg-input! id (-> props (select-keys [:form-id :validate-when-change? :validate-when-leave? :validators])
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

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn validate-input!
  ; @links
  ; [cljc-form-validator](https://mt-app-kit.github.io/cljc-form-validator)
  ;
  ; @description
  ; Validates the input.
  ;
  ; @param (keyword) id
  ; @param (keyword) props
  ; {:on-invalid-f (function)(opt)
  ;  :on-valid-f (function)(opt)
  ;  ...}
  ;
  ; @usage
  ; (validate-input! :my-input {...})
  ;
  ; @return (map)
  ; {:error (multitype-content)
  ;  :input-id (keyword)
  ;  :input-valid? (boolean)
  ;  :input-value (*)}
  [id props]
  (form-validator/validate-input! id props))

(defn validate-form!
  ; @links
  ; [cljc-form-validator](https://mt-app-kit.github.io/cljc-form-validator)
  ;
  ; @description
  ; Validates the inputs associated with the given form ID.
  ;
  ; @param (keyword) id
  ; @param (keyword) props
  ; {:on-invalid-f (function)(opt)
  ;  :on-valid-f (function)(opt)
  ;  ...}
  ;
  ; @usage
  ; (validate-form! :my-form {...})
  ;
  ; @return (maps in vector)
  ; [(map) validation-result
  ;   {:error (multitype-content)
  ;    :input-id (keyword)
  ;    :input-valid? (boolean)
  ;    :input-value (*)}]
  [id props]
  (form-validator/validate-form! id props))
