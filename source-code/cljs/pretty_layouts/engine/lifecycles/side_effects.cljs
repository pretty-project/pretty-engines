
(ns pretty-layouts.engine.lifecycles.side-effects
    (:require [pretty-elements.engine.api                  :as pretty-elements.engine]
              [pretty-layouts.engine.keypress.side-effects :as keypress.side-effects]
              [scroll-lock.api                             :as scroll-lock]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn pseudo-layout-did-mount
  ; @note
  ; Pseudo layouts are non-layout elements within the layout set.
  ;
  ; @description
  ; Implements the 'component-did-mount' lifecycle of the pseudo layout.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (pseudo-layout-did-mount :my-layout {...})
  [id props]
  (pretty-elements.engine/element-did-mount id props))

(defn pseudo-layout-will-unmount
  ; @note
  ; Pseudo layouts are non-layout elements within the layout set.
  ;
  ; @description
  ; Implements the 'component-will-unmount' lifecycle of the pseudo layout.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (pseudo-layout-will-unmount :my-layout {...})
  [id props]
  (pretty-elements.engine/element-will-unmount id props))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn layout-did-mount
  ; @description
  ; Implements the 'component-did-mount' lifecycle of the layout.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:lock-scroll? (boolean)(opt)
  ;  ...}
  ;
  ; @usage
  ; (layout-did-mount :my-layout {...})
  [id {:keys [lock-scroll?] :as props}]
  (pretty-elements.engine/element-did-mount         id props)
  (keypress.side-effects/reg-layout-keypress-event! id props 13 :on-enter-f)
  (keypress.side-effects/reg-layout-keypress-event! id props 27 :on-escape-f)
  (keypress.side-effects/reg-layout-keypress-event! id props 40 :on-arrow-down-f)
  (keypress.side-effects/reg-layout-keypress-event! id props 37 :on-arrow-left-f)
  (keypress.side-effects/reg-layout-keypress-event! id props 39 :on-arrow-right-f)
  (keypress.side-effects/reg-layout-keypress-event! id props 38 :on-arrow-up-f)
  (if lock-scroll? (scroll-lock/add-scroll-prohibition! id)))

(defn layout-will-unmount
  ; @description
  ; Implements the 'component-will-unmount' lifecycle of the layout.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:lock-scroll? (boolean)(opt)
  ;  ...}
  ;
  ; @usage
  ; (layout-will-unmount :my-layout {...})
  [id {:keys [lock-scroll?] :as props}]
  (pretty-elements.engine/element-will-unmount        id props)
  (keypress.side-effects/dereg-layout-keypress-event! id props 13 :on-enter-f)
  (keypress.side-effects/dereg-layout-keypress-event! id props 27 :on-escape-f)
  (keypress.side-effects/dereg-layout-keypress-event! id props 40 :on-arrow-down-f)
  (keypress.side-effects/dereg-layout-keypress-event! id props 37 :on-arrow-left-f)
  (keypress.side-effects/dereg-layout-keypress-event! id props 39 :on-arrow-right-f)
  (keypress.side-effects/dereg-layout-keypress-event! id props 38 :on-arrow-up-f)
  (if lock-scroll? (scroll-lock/remove-scroll-prohibition! id)))
