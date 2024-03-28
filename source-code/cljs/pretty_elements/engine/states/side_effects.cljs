
(ns pretty-elements.engine.states.side-effects
    (:require [window.api :as window]
              [component-states.api :as component-states]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn add-element-pressed-state-listener!
  ; @description
  ; Adds a mouse-up listener (to the Window object) that removes the element pressed state.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:pressed (map)(opt)
  ;  ...}
  ;
  ; @usage
  ; (add-element-pressed-state-listener! :my-element {...})
  [id {:keys [pressed] :as props}]
  (if pressed (window/add-event-listener! "mouseup" (fn [] (component-states/unmark-component-as-pressed! id props)))))

(defn remove-element-pressed-state-listener!
  ; @description
  ; Removes the mouse-up listener (from the Window object) that removes the element pressed state.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:pressed (map)(opt)
  ;  ...}
  ;
  ; @usage
  ; (remove-element-pressed-state-listener! :my-element {...} ...)
  [id {:keys [pressed] :as props}]
  (if pressed (window/remove-event-listener! "mouseup" (fn [] (component-states/unmark-component-as-pressed! id props)))))
