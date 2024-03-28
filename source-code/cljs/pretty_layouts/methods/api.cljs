
(ns pretty-layouts.methods.api
    (:require [pretty-layouts.methods.dynamic.import  :as dynamic.import]
              [pretty-layouts.methods.presets.apply   :as presets.apply]
              [pretty-layouts.methods.shorthand.apply :as shorthand.apply]
              [pretty-layouts.methods.states.import   :as states.import]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (pretty-layouts.methods.dynamic.import/*)
(def import-layout-dynamic-props dynamic.import/import-layout-dynamic-props)

; @redirect (pretty-layouts.methods.presets.apply/*)
(def apply-layout-presets presets.apply/apply-layout-presets)

; @redirect (pretty-layouts.methods.shorthand.apply/*)
(def apply-layout-shorthand-key shorthand.apply/apply-layout-shorthand-key)
(def apply-layout-shorthand-map shorthand.apply/apply-layout-shorthand-map)

; @redirect (pretty-layouts.methods.states.import/*)
(def import-layout-state-events states.import/import-layout-state-events)
(def import-layout-states       states.import/import-layout-states)
 
