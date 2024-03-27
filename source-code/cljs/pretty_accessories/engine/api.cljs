
(ns pretty-accessories.engine.api
    (:require [pretty-accessories.engine.lifecycles.side-effects :as lifecycles.side-effects]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (pretty-accessories.engine.lifecycles.side-effects/*)
(def accessory-did-mount    lifecycles.side-effects/accessory-did-mount)
(def accessory-will-unmount lifecycles.side-effects/accessory-will-unmount)
