
(ns pretty-elements.methods.api
    (:require [pretty-elements.methods.dynamic.import  :as dynamic.import]
              [pretty-elements.methods.focus.import    :as focus.import]
              [pretty-elements.methods.presets.apply   :as presets.apply]
              [pretty-elements.methods.shorthand.apply :as shorthand.apply]
              [pretty-elements.methods.state.import    :as state.import]
              [pretty-elements.methods.timeout.import  :as timeout.import]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (pretty-elements.methods.dynamic.import/*)
(def import-element-dynamic-props dynamic.import/import-element-dynamic-props)

; @redirect (pretty-elements.methods.focus.import/*)
(def import-element-focus-reference focus.import/import-element-focus-reference)

; @redirect (pretty-elements.methods.presets.apply/*)
(def apply-element-presets presets.apply/apply-element-presets)

; @redirect (pretty-elements.methods.shorthand.apply/*)
(def apply-element-shorthand-key shorthand.apply/apply-element-shorthand-key)
(def apply-element-shorthand-map shorthand.apply/apply-element-shorthand-map)

; @redirect (pretty-elements.methods.state.import/*)
(def import-element-state-events state.import/import-element-state-events)
(def import-element-state        state.import/import-element-state)

; @redirect (pretty-elements.methods.timeout.import/*)
(def import-element-timeout-events timeout.import/import-element-timeout-events)
(def import-element-timeout        timeout.import/import-element-timeout)
