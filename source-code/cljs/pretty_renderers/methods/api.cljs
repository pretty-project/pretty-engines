
(ns pretty-renderers.methods.api
    (:require [pretty-renderers.methods.dynamic.import  :as dynamic.import]
              [pretty-renderers.methods.presets.apply   :as presets.apply]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (pretty-renderers.methods.dynamic.import/*)
(def import-renderer-dynamic-props dynamic.import/import-renderer-dynamic-props)

; @redirect (pretty-renderers.methods.presets.apply/*)
(def apply-renderer-presets presets.apply/apply-renderer-presets)
