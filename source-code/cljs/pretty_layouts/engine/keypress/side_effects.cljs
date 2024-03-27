
(ns pretty-layouts.engine.keypress.side-effects
    (:require [keypress-handler.api :as keypress-handler]
              [pretty-subitems.api  :as pretty-subitems]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn layout-key-pressed
  ; @description
  ; Applies a specific keypress handler function (if any) of the layout.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; @param (integer) key-code
  ; @param (keyword) handler-name
  ;
  ; @usage
  ; (layout-key-pressed :my-layout {...} 13 :on-enter-f)
  [_ props _ handler-name]
  (if-let [on-key-f (-> props handler-name)]
          (on-key-f)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn reg-layout-keypress-event!
  ; @description
  ; Registers a specific keypress event (if any) of the layout.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; @param (integer) key-code
  ; @param (keyword) handler-name
  ;
  ; @usage
  ; (reg-layout-keypress-event! :my-layout {...} 13 :on-enter-f)
  [id props key-code handler-name]
  ; @note (#4401)
  ; Keypress events are registered with '{:exclusive? true}' setting. Therefore, ...
  ; ... the rendered layouts do not have any keypress concurrency problems.
  (if (handler-name props)
      (keypress-handler/reg-keypress-event! (pretty-subitems/subitem-id id handler-name)
                                            {:key-code key-code :in-type-mode? false :exclusive? true
                                             :on-keydown-f (fn [_] (layout-key-pressed id props key-code handler-name))})))

(defn dereg-layout-keypress-event!
  ; @description
  ; Deregisters a specific keypress event (if any) of the layout.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; @param (integer) key-code
  ; @param (keyword) handler-name
  ;
  ; @usage
  ; (dereg-layout-keypress-event! :my-layout {...} 13 :on-enter-f)
  [id props _ handler-name]
  ; @note (#4401)
  (if (handler-name props)
      (keypress-handler/dereg-keypress-event! (pretty-subitems/subitem-id id handler-name))))
