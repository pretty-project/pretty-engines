
(ns pretty-inputs.methods.api
    (:require [pretty-inputs.methods.dynamic.import  :as dynamic.import]
              [pretty-inputs.methods.field.import    :as field.import]
              [pretty-inputs.methods.focus.import    :as focus.import]
              [pretty-inputs.methods.options.import  :as options.import]
              [pretty-inputs.methods.presets.apply   :as presets.apply]
              [pretty-inputs.methods.shorthand.apply :as shorthand.apply]
              [pretty-inputs.methods.states.import    :as states.import]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (pretty-inputs.methods.dynamic.import/*)
(def import-input-dynamic-props dynamic.import/import-input-dynamic-props)

; @redirect (pretty-inputs.methods.field.import/*)
(def import-input-field-events field.import/import-input-field-events)
(def import-input-field-value  field.import/import-input-field-value)

; @redirect (pretty-inputs.methods.focus.import/*)
(def import-input-focus-reference focus.import/import-input-focus-reference)

; @redirect (pretty-inputs.methods.options.import/*)
(def import-input-option-controls     options.import/import-input-option-controls)
(def import-input-option-events       options.import/import-input-option-events)
(def import-input-option-filtering    options.import/import-input-option-filtering)
(def import-input-option-highlighting options.import/import-input-option-highlighting)
(def import-input-option-selection    options.import/import-input-option-selection)

; @redirect (pretty-inputs.methods.presets.apply/*)
(def apply-input-presets presets.apply/apply-input-presets)

; @redirect (pretty-inputs.methods.shorthand.apply/*)
(def apply-input-shorthand-key shorthand.apply/apply-input-shorthand-key)
(def apply-input-shorthand-map shorthand.apply/apply-input-shorthand-map)

; @redirect (pretty-inputs.methods.states.import/*)
(def import-input-state-events states.import/import-input-state-events)
(def import-input-states       states.import/import-input-states)
