
(ns pretty-elements.engine.keypress.side-effects
    (:require [component-props.api :as component-props]
              [keypress-handler.api                      :as keypress-handler]
              [pretty-elements.engine.focus.side-effects :as focus.side-effects]
              [pretty-subitems.api                       :as pretty-subitems]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn element-key-pressed
  ; @description
  ; Implements the 'key-pressed' event of the element.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; @param (integer) key-code
  ;
  ; @usage
  ; (element-key-pressed :my-element {...} 27)
  [id props _]
  (component-props/merge-props!      id {:pressed? true})
  (focus.side-effects/focus-element! id props))

(defn element-key-released
  ; @description
  ; Implements the 'key-released' event of the element.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:on-click-f (function)(opt)
  ;  ...}
  ; @param (integer) key-code
  ;
  ; @usage
  ; (element-key-released :my-element {...} 27)
  [id {:keys [on-click-f] :as props} key-code]
  (component-props/merge-props!     id {:pressed? nil})
  (focus.side-effects/blur-element! id props)
  (if on-click-f (on-click-f key-code)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn reg-element-keypress-event!
  ; @description
  ; Registers the keypress control event (if any) of the element.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:keypress (map)(opt)
  ;  ...}
  ;
  ; @usage
  ; (reg-element-keypress-event! :my-element {...})
  [id {:keys [keypress] :as props}]
  (if keypress (keypress-handler/reg-keypress-event! (pretty-subitems/subitem-id id :keypress)
                                                     (assoc keypress :on-keydown-f (fn [key-code] (element-key-pressed  id props key-code))
                                                                     :on-keyup-f   (fn [key-code] (element-key-released id props key-code))
                                                                     :prevent-default? true))))

(defn dereg-element-keypress-event!
  ; @description
  ; Registers the keypress control event (if any) of the element.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:keypress (map)(opt)
  ;  ...}
  ;
  ; @usage
  ; (dereg-element-keypress-event! :my-element {...})
  [id {:keys [keypress]}]
  (if keypress (keypress-handler/dereg-keypress-event! (pretty-subitems/subitem-id id :keypress))))
