
(ns pretty-elements.engine.state.side-effects
    (:require [pretty-elements.engine.state.utils :as state.utils]
              [window.api                         :as window]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn add-element-active-state-listener!
  ; @description
  ; Adds a mouse-up listener (to the Window object) that removes the element active state.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:active (map)(opt)
  ;  ...}
  ;
  ; @usage
  ; (add-element-active-state-listener! :my-element {...})
  [id {:keys [active] :as props}]
  (if active (window/add-event-listener! "mouseup" (state.utils/remove-element-active-state-f id props))))

(defn remove-element-active-state-listener!
  ; @description
  ; Removes the mouse-up listener (from the Window object) that removes the element active state.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:active (map)(opt)
  ;  ...}
  ;
  ; @usage
  ; (remove-element-active-state-listener! :my-element {...} ...)
  [id {:keys [active] :as props}]
  (if active (window/remove-event-listener! "mouseup" (state.utils/remove-element-active-state-f id props))))
