
(ns pretty-inputs.engine.focus.side-effects
    (:require [common-state.api                           :as common-state]
              [form-validator.api                         :as form-validator]
              [pretty-elements.engine.api                 :as pretty-elements.engine]
              [pretty-inputs.engine.keypress.side-effects :as keypress.side-effects]
              [pretty-inputs.engine.value.env             :as value.env]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn focus-input!
  ; @description
  ; Sets the DOM focus on the input.
  ;
  ; @param (keyword) id
  ; @param (keyword) props
  ;
  ; @usage
  ; (focus-input! :my-input {...})
  [id props]
  (pretty-elements.engine/focus-element! id props))

(defn blur-input!
  ; @description
  ; Removes the DOM focus from the input.
  ;
  ; @param (keyword) id
  ; @param (keyword) props
  ;
  ; @usage
  ; (blur-input! :my-input {...})
  [id props]
  (pretty-elements.engine/blur-element! id props))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn mark-input-as-focused!
  ; @description
  ; Marks the input as focused (in the input state).
  ;
  ; @param (keyword) id
  ; @param (keyword) props
  ;
  ; @usage
  ; (mark-input-as-focused! :my-input {...})
  [id _]
  (common-state/assoc-state! :pretty-ui id :focused? true))

(defn unmark-input-as-focused!
  ; @description
  ; Unmarks the input as focused (in the input state).
  ;
  ; @param (keyword) id
  ; @param (keyword) props
  ;
  ; @usage
  ; (unmark-input-as-focused! :my-input {...})
  [id _]
  (common-state/dissoc-state! :pretty-ui id :focused?))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn input-focused
  ; @description
  ; Implements the 'focused' event of the input.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:on-focus-f (function)(opt)
  ;  ...}
  ;
  ; @usage
  ; (input-focused :my-input {...})
  [id {:keys [on-focus-f] :as props}]
  (mark-input-as-focused!                          id props)
  (keypress.side-effects/reg-input-keypress-event! id props 13 :on-enter-f)
  (keypress.side-effects/reg-input-keypress-event! id props 27 :on-escape-f)
  (keypress.side-effects/reg-input-keypress-event! id props 40 :on-arrow-down-f)
  (keypress.side-effects/reg-input-keypress-event! id props 37 :on-arrow-left-f)
  (keypress.side-effects/reg-input-keypress-event! id props 39 :on-arrow-right-f)
  (keypress.side-effects/reg-input-keypress-event! id props 38 :on-arrow-up-f)
  (let [input-displayed-value (value.env/get-input-displayed-value id props)]
       (if on-focus-f (on-focus-f input-displayed-value))))

(defn input-left
  ; @description
  ; Implements the 'blurred' event of the input.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:on-blur-f (function)(opt)
  ;  ...}
  ;
  ; @usage
  ; (input-left :my-input {...})
  [id {:keys [on-blur-f] :as props}]
  (form-validator/input-left                         id props)
  (unmark-input-as-focused!                          id props)
  (keypress.side-effects/dereg-input-keypress-event! id props 13 :on-enter-f)
  (keypress.side-effects/dereg-input-keypress-event! id props 27 :on-escape-f)
  (keypress.side-effects/dereg-input-keypress-event! id props 40 :on-arrow-down-f)
  (keypress.side-effects/dereg-input-keypress-event! id props 37 :on-arrow-left-f)
  (keypress.side-effects/dereg-input-keypress-event! id props 39 :on-arrow-right-f)
  (keypress.side-effects/dereg-input-keypress-event! id props 38 :on-arrow-up-f)
  (let [input-displayed-value (value.env/get-input-displayed-value id props)]
       (if on-blur-f (on-blur-f input-displayed-value))))
