
(ns pretty-elements.engine.lifecycles.side-effects
    (:require [common-state.api                             :as common-state]
              [dynamic-props.api                            :as dynamic-props]
              [component-props.api :as component-props]
              [pretty-elements.engine.keypress.side-effects :as keypress.side-effects]
              [pretty-elements.engine.state.side-effects    :as state.side-effects]
              [reagent.tools.api                            :as reagent.tools]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn element-did-mount
  ; @description
  ; Implements the 'component-did-mount' lifecycle of the element.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:on-mount-f (function)(opt)
  ;  ...}
  ;
  ; @usage
  ; (element-did-mount :my-element {...})
  [id {:keys [on-mount-f] :as props}]
  (keypress.side-effects/reg-element-keypress-event!     id props)
  (state.side-effects/add-element-active-state-listener! id props)
  (if on-mount-f (on-mount-f id)))

(defn element-did-update
  ; @description
  ; Implements the 'component-did-update' lifecycle of the element.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; @param (Reagent component object) %
  ;
  ; @usage
  ; (element-did-update :my-element {...} ...)
  [id _ %]
  (let [[_ props] (reagent.tools/arguments %)]
       (keypress.side-effects/dereg-element-keypress-event! id props)
       (keypress.side-effects/reg-element-keypress-event!   id props)))

(defn element-will-unmount
  ; @description
  ; Implements the 'component-will-unmount' lifecycle of the element.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:on-unmount-f (function)(opt)
  ;  ...}
  ;
  ; @usage
  ; (element-will-unmount :my-element {...})
  [id {:keys [on-unmount-f] :as props}]
  (keypress.side-effects/dereg-element-keypress-event!      id props)
  (state.side-effects/remove-element-active-state-listener! id props)
  (common-state/dissoc-state! :pretty-ui id)
  (dynamic-props/clear-props! id)
  (if on-unmount-f (on-unmount-f id)))
