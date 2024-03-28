
(ns pretty-elements.engine.state.utils
    (:require [component-props.api :as component-props]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn remove-element-active-state-f
  ; @description
  ; Returns a function that removes the element active state.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (remove-element-active-state-f :my-element {...})
  ;
  ; @return (function)
  [id _]
  (fn [_] (component-props/update-props! id dissoc :active?)))
