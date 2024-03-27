
(ns pretty-diagrams.methods.api
    (:require [pretty-diagrams.methods.data.import     :as data.import]
              [pretty-diagrams.methods.dynamic.import  :as dynamic.import]
              [pretty-diagrams.methods.presets.apply   :as presets.apply]
              [pretty-diagrams.methods.shorthand.apply :as shorthand.apply]
              [pretty-diagrams.methods.state.import    :as state.import]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (pretty-diagrams.methods.data.import/*)
(def import-diagram-data-sum data.import/import-diagram-data-sum)

; @redirect (pretty-diagrams.methods.dynamic.import/*)
(def import-diagram-dynamic-props dynamic.import/import-diagram-dynamic-props)

; @redirect (pretty-diagrams.methods.presets.apply/*)
(def apply-diagram-presets presets.apply/apply-diagram-presets)

; @redirect (pretty-diagrams.methods.shorthand.apply/*)
(def apply-diagram-shorthand-key shorthand.apply/apply-diagram-shorthand-key)
(def apply-diagram-shorthand-map shorthand.apply/apply-diagram-shorthand-map)

; @redirect (pretty-diagrams.methods.state.import/*)
(def import-diagram-state-events state.import/import-diagram-state-events)
(def import-diagram-state        state.import/import-diagram-state)
