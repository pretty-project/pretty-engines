
(ns pretty-diagrams.engine.api
    (:require [pretty-diagrams.engine.data.env                :as data.env]
              [pretty-diagrams.engine.data.utils              :as data.utils]
              [pretty-diagrams.engine.lifecycles.side-effects :as lifecycles.side-effects]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (pretty-diagrams.engine.data.env/*)
(def get-diagram-data data.env/get-diagram-data)

; @redirect (pretty-diagrams.engine.data.utils/*)
(def diagram-datum-color  data.utils/diagram-datum-color)
(def diagram-datum-value  data.utils/diagram-datum-value)
(def diagram-datum-offset data.utils/diagram-datum-offset)

; @redirect (pretty-diagrams.engine.lifecycles.side-effects/*)
(def diagram-did-mount    lifecycles.side-effects/diagram-did-mount)
(def diagram-will-unmount lifecycles.side-effects/diagram-will-unmount)
