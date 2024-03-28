
(ns pretty-elements.engine.api
    (:require [pretty-elements.engine.focus.side-effects      :as focus.side-effects]
              [pretty-elements.engine.keypress.side-effects   :as keypress.side-effects]
              [pretty-elements.engine.lifecycles.side-effects :as lifecycles.side-effects]
              [pretty-elements.engine.states.side-effects      :as states.side-effects]
              [pretty-elements.engine.timeout.env             :as timeout.env]
              [pretty-elements.engine.timeout.side-effects    :as timeout.side-effects]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (pretty-elements.engine.focus.side-effects/*)
(def focus-element! focus.side-effects/focus-element!)
(def blur-element!  focus.side-effects/blur-element!)

; @redirect (pretty-elements.engine.keypress.side-effects/*)
(def element-key-pressed           keypress.side-effects/element-key-pressed)
(def element-key-released          keypress.side-effects/element-key-released)
(def reg-element-keypress-event!   keypress.side-effects/reg-element-keypress-event!)
(def dereg-element-keypress-evens! keypress.side-effects/dereg-element-keypress-event!)

; @redirect (pretty-elements.engine.lifecycles.side-effects/*)
(def element-did-mount    lifecycles.side-effects/element-did-mount)
(def element-did-update   lifecycles.side-effects/element-did-update)
(def element-will-unmount lifecycles.side-effects/element-will-unmount)

; @redirect (pretty-elements.engine.states.side-effects/*)
(def add-element-pressed-state-listener!    states.side-effects/add-element-pressed-state-listener!)
(def remove-element-pressed-state-listener! states.side-effects/remove-element-pressed-state-listener!)

; @redirect (pretty-elements.engine.timeout.env/*)
(def get-element-timeout-left  timeout.env/get-element-timeout-left)
(def get-element-timeout-label timeout.env/get-element-timeout-label)

; @redirect (pretty-elements.engine.timeout.side-effects/*)
(def start-element-timeout! timeout.side-effects/start-element-timeout!)
