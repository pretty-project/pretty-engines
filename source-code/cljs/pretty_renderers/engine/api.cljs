
(ns pretty-renderers.engine.api
    (:require [pretty-renderers.engine.lifecycles.side-effects :as lifecycles.side-effects]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (pretty-renderers.engine.lifecycles.side-effects/*)
(def renderer-did-mount    lifecycles.side-effects/renderer-did-mount)
(def renderer-will-unmount lifecycles.side-effects/renderer-will-unmount)
 
