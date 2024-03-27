
(ns pretty-inputs.engine.lifecycles.side-effects
    (:require [pretty-elements.engine.api              :as pretty-elements.engine]
              [pretty-inputs.engine.focus.side-effects :as focus.side-effects]
              [pretty-inputs.engine.form.side-effects  :as form.side-effects]
              [pretty-inputs.engine.value.side-effects :as value.side-effects]
              [time.api                                :as time]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn pseudo-input-did-mount
  ; @note
  ; Pseudo inputs are non-input elements within the input set.
  ;
  ; @description
  ; Implements the 'component-did-mount' lifecycle of the pseudo input.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (pseudo-input-did-mount :my-input {...})
  [id props]
  (pretty-elements.engine/element-did-mount id props))

(defn pseudo-input-will-unmount
  ; @note
  ; Pseudo inputs are non-input elements within the input set.
  ;
  ; @description
  ; Implements the 'component-will-unmount' lifecycle of the pseudo input.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (pseudo-input-will-unmount :my-input {...})
  [id props]
  (pretty-elements.engine/element-will-unmount id props))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn input-did-mount
  ; @description
  ; Implements the 'component-did-mount' lifecycle of the input.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:autofocus? (boolean)(opt)
  ;  ...}
  ;
  ; @usage
  ; (input-did-mount :my-input {...})
  [id {:keys [autofocus?] :as props}]
  ; The autofocus has to be delayed; otherwise, if the input is a field, then the caret
  ; might shown up at the beginning of the content (instead of at its end).
  (letfn [(f0 [] (focus.side-effects/focus-input! id props))]
         (if autofocus? (time/set-timeout! f0 50)))
  (form.side-effects/reg-form-input!             id props)
  (pretty-elements.engine/element-did-mount      id props)
  (value.side-effects/init-input-internal-value! id props)
  (value.side-effects/use-input-initial-value!   id props))

(defn input-will-unmount
  ; @description
  ; Implements the 'component-will-unmount' lifecycle of the input.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (input-will-unmount :my-input {...})
  [id props]
  (form.side-effects/dereg-form-input!         id props)
  (pretty-elements.engine/element-will-unmount id props))
