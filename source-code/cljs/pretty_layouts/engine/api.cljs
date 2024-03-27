
(ns pretty-layouts.engine.api
    (:require [pretty-layouts.engine.keypress.side-effects   :as keypress.side-effects]
              [pretty-layouts.engine.lifecycles.side-effects :as lifecycles.side-effects]
              [pretty-layouts.engine.scroll.views            :as scroll.views]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (pretty-layouts.engine.keypress.side-effects/*)
(def layout-key-pressed           keypress.side-effects/layout-key-pressed)
(def reg-layout-keypress-event!   keypress.side-effects/reg-layout-keypress-event!)
(def dereg-layout-keypress-event! keypress.side-effects/dereg-layout-keypress-event!)

; @redirect (pretty-layouts.engine.lifecycles.side-effects/*)
(def pseudo-layout-did-mount    lifecycles.side-effects/pseudo-layout-did-mount)
(def pseudo-layout-will-unmount lifecycles.side-effects/pseudo-layout-will-unmount)
(def layout-did-mount           lifecycles.side-effects/layout-did-mount)
(def layout-will-unmount        lifecycles.side-effects/layout-will-unmount)

; @redirect (pretty-layouts.engine.scroll.views/*)
(def layout-header-sensor scroll.views/layout-header-sensor)
(def layout-footer-sensor scroll.views/layout-footer-sensor)
