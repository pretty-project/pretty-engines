
(ns pretty-inputs.engine.keypress.side-effects
    (:require [keypress-handler.api           :as keypress-handler]
              [pretty-inputs.engine.value.env :as value.env]
              [pretty-subitems.api            :as pretty-subitems]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn input-key-pressed
  ; @description
  ; Applies a specific keypress handler function (if any) of the input.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; @param (integer) key-code
  ; @param (keyword) handler-name
  ;
  ; @usage
  ; (input-key-pressed :my-input {...} 13 :on-enter-f)
  [id props _ handler-name]
  (let [input-displayed-value (value.env/get-input-displayed-value id props)]
       (if-let [on-key-f (-> props handler-name)]
               (on-key-f input-displayed-value))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn reg-input-keypress-event!
  ; @description
  ; Registers a specific keypress event (if any) of the input.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; @param (integer) key-code
  ; @param (keyword) handler-name
  ;
  ; @usage
  ; (reg-input-keypress-event! :my-input {...} 13 :on-enter-f)
  [id props key-code handler-name]
  ; @note (pretty-engine.layout.keypress.side-effects#4401)
  (if (handler-name props)
      (keypress-handler/reg-keypress-event! (pretty-subitems/subitem-id id handler-name)
                                            {:key-code key-code :in-type-mode? true :exclusive? true
                                             :on-keydown-f (fn [_] (input-key-pressed id props key-code handler-name))})))

(defn dereg-input-keypress-event!
  ; @description
  ; Deregisters a specific keypress event (if any) of the input.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; @param (integer) key-code
  ; @param (keyword) handler-name
  ;
  ; @usage
  ; (dereg-input-keypress-event! :my-input {...} 13 :on-enter-f)
  [id props _ handler-name]
  ; @note (pretty-engine.layout.keypress.side-effects#4401)
  (if (handler-name props)
      (keypress-handler/dereg-keypress-event! (pretty-subitems/subitem-id id handler-name))))
