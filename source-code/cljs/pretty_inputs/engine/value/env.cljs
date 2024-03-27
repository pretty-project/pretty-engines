
(ns pretty-inputs.engine.value.env
    (:require [common-state.api :as common-state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn input-changed?
  ; @description
  ; Returns TRUE if a the input is marked as changed (in the input state).
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (input-changed? :my-input {...})
  ;
  ; @return (boolean)
  [id _]
  (common-state/get-state :pretty-ui id :changed?))

(defn input-empty?
  ; @description
  ; Returns TRUE if a the internal value of the input is empty (stored in the input state).
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (input-empty? :my-input {...})
  ;
  ; @return (boolean)
  [id _]
  (let [internal-value (common-state/get-state :pretty-ui id :internal-value)]
       (and (seqable? internal-value)
            (empty?   internal-value))))

(defn input-not-empty?
  ; @description
  ; Returns TRUE if a the internal value of the input is NOT empty (stored in the input state).
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (input-not-empty? :my-input {...})
  ;
  ; @return (boolean)
  [id props]
  (-> (input-empty? id props) not))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-input-internal-value
  ; @description
  ; Returns the internal value of the input (stored in the input state).
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (get-input-internal-value :my-input {...})
  ;
  ; @return (*)
  [id _]
  (common-state/get-state :pretty-ui id :internal-value))

(defn get-input-external-value
  ; @description
  ; Returns the external value of the input (output of the 'get-value-f' function).
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:get-value-f (function)(opt)
  ;  ...}
  ;
  ; @usage
  ; (get-input-external-value :my-input {...})
  ;
  ; @return (*)
  [_ {:keys [get-value-f]}]
  (if get-value-f (get-value-f)))

(defn get-input-displayed-value
  ; @description
  ; Returns the internal value of the input (stored in the input state)
  ; optionally replaced with the given 'projected-value' (if the input is empty and still unchanged).
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:projected-value (*)(opt)
  ;  ...}
  ;
  ; @usage
  ; (get-input-displayed-value :my-input {...})
  ;
  ; @return (*)
  [id {:keys [projected-value] :as props}]
  (if-some [input-internal-value (get-input-internal-value id props)]
           (-> input-internal-value)
           (if-not (input-changed? id props)
                   (-> projected-value))))
