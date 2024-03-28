
(ns pretty-accessories.methods.api
    (:require [pretty-accessories.methods.dynamic.import  :as dynamic.import]
              [pretty-accessories.methods.presets.apply   :as presets.apply]
              [pretty-accessories.methods.shorthand.apply :as shorthand.apply]
              [pretty-accessories.methods.states.import :as states.import]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (pretty-accessories.methods.dynamic.import/*)
(def import-accessory-dynamic-props dynamic.import/import-accessory-dynamic-props)

; @redirect (pretty-accessories.methods.presets.apply/*)
(def apply-accessory-presets presets.apply/apply-accessory-presets)

; @redirect (pretty-accessories.methods.shorthand.apply/*)
(def apply-accessory-shorthand-key shorthand.apply/apply-accessory-shorthand-key)
(def apply-accessory-shorthand-map shorthand.apply/apply-accessory-shorthand-map)

; @redirect (pretty-accessories.methods.states.import/*)
(def import-accessory-state-events states.import/import-accessory-state-events)
(def import-accessory-states       states.import/import-accessory-states)
