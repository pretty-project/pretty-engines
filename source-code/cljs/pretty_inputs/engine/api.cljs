
(ns pretty-inputs.engine.api
    (:require [pretty-inputs.engine.field.env               :as field.env]
              [pretty-inputs.engine.field.side-effects      :as field.side-effects]
              [pretty-inputs.engine.field.utils             :as field.utils]
              [pretty-inputs.engine.focus.env               :as focus.env]
              [pretty-inputs.engine.focus.side-effects      :as focus.side-effects]
              [pretty-inputs.engine.form.side-effects       :as form.side-effects]
              [pretty-inputs.engine.keypress.side-effects   :as keypress.side-effects]
              [pretty-inputs.engine.lifecycles.side-effects :as lifecycles.side-effects]
              [pretty-inputs.engine.options.env             :as options.env]
              [pretty-inputs.engine.options.side-effects    :as options.side-effects]
              [pretty-inputs.engine.options.utils           :as options.utils]
              [pretty-inputs.engine.value.env               :as value.env]
              [pretty-inputs.engine.value.side-effects      :as value.side-effects]
              [pretty-inputs.engine.value.views             :as value.views]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (pretty-inputs.engine.field.env/*)
(def get-input-field-displayed-content field.env/get-input-field-displayed-content)
(def input-field-empty?                field.env/input-field-empty?)

; @redirect (pretty-inputs.engine.field.side-effects/*)
(def input-field-focused       field.side-effects/input-field-focused)
(def input-field-left          field.side-effects/input-field-left)
(def input-field-type-ended    field.side-effects/input-field-type-ended)
(def input-field-value-changed field.side-effects/input-field-value-changed)

; @redirect (pretty-inputs.engine.field.utils/*)
(def on-input-event->field-value field.utils/on-input-event->field-value)

; @redirect (pretty-inputs.engine.focus.env/*)
(def input-focused? focus.env/input-focused?)

; @redirect (pretty-inputs.engine.focus.side-effects/*)
(def focus-input!             focus.side-effects/focus-input!)
(def blur-input!              focus.side-effects/blur-input!)
(def mark-input-as-focused!   focus.side-effects/mark-input-as-focused!)
(def unmark-input-as-focused! focus.side-effects/unmark-input-as-focused!)
(def input-focused            focus.side-effects/input-focused)
(def input-left               focus.side-effects/input-left)

; @redirect (pretty-inputs.engine.form.side-effects/*)
(def reg-form-input!   form.side-effects/reg-form-input!)
(def dereg-form-input! form.side-effects/dereg-form-input!)

; @redirect (pretty-inputs.engine.keypress.side-effects/*)
(def input-key-pressed           keypress.side-effects/input-key-pressed)
(def reg-input-keypress-event!   keypress.side-effects/reg-input-keypress-event!)
(def dereg-input-keypress-event! keypress.side-effects/dereg-input-keypress-event!)

; @redirect (pretty-inputs.engine.lifecycles.side-effects/*)
(def pseudo-input-did-mount    lifecycles.side-effects/pseudo-input-did-mount)
(def pseudo-input-will-unmount lifecycles.side-effects/pseudo-input-will-unmount)
(def input-did-mount           lifecycles.side-effects/input-did-mount)
(def input-will-unmount        lifecycles.side-effects/input-will-unmount)

; @redirect (pretty-inputs.engine.options.env/*)
(def input-option-filtered?             options.env/input-option-filtered?)
(def get-input-filtered-options         options.env/get-input-filtered-options)
(def any-input-option-filtered?         options.env/any-input-option-filtered?)
(def multiple-input-options-selectable? options.env/multiple-input-options-selectable?)
(def max-input-selection-not-reached?   options.env/max-input-selection-not-reached?)
(def get-input-option-selection         options.env/get-input-option-selection)
(def input-option-selected?             options.env/input-option-selected?)
(def get-input-option-highlighting      options.env/get-input-option-highlighting)
(def get-input-highlighted-option       options.env/get-input-highlighted-option)
(def input-option-highlighted?          options.env/input-option-highlighted?)

; @redirect (pretty-inputs.engine.options.side-effects/*)
(def toggle-input-option-selection!     options.side-effects/toggle-input-option-selection!)
(def discard-input-option-highlighting! options.side-effects/discard-input-option-highlighting!)
(def highlight-input-prev-option!       options.side-effects/highlight-input-prev-option!)
(def highlight-input-next-option!       options.side-effects/highlight-input-next-option!)
(def mark-input-option-as-highlighted!  options.side-effects/mark-input-option-as-highlighted!)

; @redirect (pretty-inputs.engine.options.utils/*)
(def input-option-value options.utils/input-option-value)

; @redirect (pretty-inputs.engine.value.env/*)
(def input-changed?            value.env/input-changed?)
(def input-empty?              value.env/input-empty?)
(def input-not-empty?          value.env/input-not-empty?)
(def get-input-internal-value  value.env/get-input-internal-value)
(def get-input-external-value  value.env/get-input-external-value)
(def get-input-displayed-value value.env/get-input-displayed-value)

; @redirect (pretty-inputs.engine.value.side-effects/*)
(def mark-input-as-changed!     value.side-effects/mark-input-as-changed!)
(def set-input-internal-value!  value.side-effects/set-input-internal-value!)
(def set-input-external-value!  value.side-effects/set-input-external-value!)
(def init-input-internal-value! value.side-effects/init-input-internal-value!)
(def use-input-initial-value!   value.side-effects/use-input-initial-value!)
(def set-input-value!           value.side-effects/set-input-value!)
(def update-input-value!        value.side-effects/update-input-value!)
(def clear-input-value!         value.side-effects/clear-input-value!)

; @redirect (pretty-inputs.engine.value.views/*)
(def input-synchronizer value.views/input-synchronizer)
