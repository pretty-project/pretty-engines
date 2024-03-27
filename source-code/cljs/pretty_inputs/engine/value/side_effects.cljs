
(ns pretty-inputs.engine.value.side-effects
    (:require [common-state.api               :as common-state]
              [form-validator.api             :as form-validator]
              [pretty-inputs.engine.value.env :as value.env]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn mark-input-as-changed!
  ; @description
  ; Marks the input as changed (in the input state).
  ;
  ; @param (keyword) id
  ; @param (keyword) props
  ;
  ; @usage
  ; (mark-input-as-changed! :my-input {...})
  [id _]
  (common-state/assoc-state! :pretty-ui id :changed? true))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-input-internal-value!
  ; @description
  ; Sets the given value as internal value of the input (in the input state).
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; @param (*) value
  ;
  ; @usage
  ; (set-input-internal-value! :my-input {...} "...")
  [id _ value]
  (common-state/assoc-state! :pretty-ui id :internal-value value))

(defn set-input-external-value!
  ; @description
  ; Sets the given value as external value of the input (with the given 'set-value-f' function, if any).
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:set-value-f (function)(opt)
  ;  ...}
  ; @param (*) value
  ;
  ; @usage
  ; (set-input-external-value! :my-input {...} "...")
  [_ {:keys [set-value-f]} value]
  (if set-value-f (set-value-f value)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn init-input-internal-value!
  ; @description
  ; Initializes the input internal value by importing the input external value (output of the 'get-value-f' function).
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (init-input-internal-value! :my-input {...})
  [id props]
  (if-let [input-external-value (value.env/get-input-external-value id props)]
          (set-input-internal-value! id props input-external-value)))

(defn use-input-initial-value!
  ; @description
  ; Sets the given initial value of the input (if any) as both internal and external values.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:initial-value (*)(opt)
  ;  ...}
  ;
  ; @usage
  ; (use-input-initial-value! :my-input {...})
  [id {:keys [initial-value] :as props}]
  (when (-> (value.env/get-input-external-value id props) nil? (and initial-value))
        (-> (set-input-internal-value!          id props initial-value))
        (-> (set-input-external-value!          id props initial-value))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn set-input-value!
  ; @description
  ; Sets the given value as both internal and external values of the input.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:on-changed-f (function)(opt)
  ;  :on-empty-f (function)(opt)
  ;  ...}
  ; @param (*) value
  ;
  ; @usage
  ; (set-input-value! :my-input {...} "...")
  [id {:keys [on-changed-f on-empty-f] :as props} value]
  (set-input-internal-value!    id props value)
  (set-input-external-value!    id props value)
  (mark-input-as-changed!       id props)
  (form-validator/input-changed id props)
  (if on-changed-f (on-changed-f value))
  (if on-empty-f   (if (value.env/input-empty? id props)
                       (on-empty-f nil))))

(defn update-input-value!
  ; @description
  ; Updates both the internal and external values of the input with the given function.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; @param (function) f
  ; @param (list of *)(opt) params
  ;
  ; @usage
  ; (update-input-value! :my-input {...} inc)
  [id props f & params]
  (let [internal-value (value.env/get-input-internal-value id props)
        updated-value  (apply f internal-value params)]
       (set-input-value! id props updated-value)))

(defn clear-input-value!
  ; @description
  ; Sets NIL as both internal and external values of the input.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (clear-input-value! :my-input {...})
  [id props]
  (when-not (value.env/input-empty? id props)
            (set-input-value!       id props nil)))
