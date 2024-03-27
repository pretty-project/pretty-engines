
(ns pretty-inputs.engine.field.side-effects
    (:require [activity-listener.api                   :as activity-listener]
              [dom.api                                 :as dom]
              [keypress-handler.api                    :as keypress-handler]
              [pretty-inputs.engine.field.utils        :as field.utils]
              [pretty-inputs.engine.focus.side-effects :as focus.side-effects]
              [pretty-inputs.engine.value.env          :as value.env]
              [pretty-inputs.engine.value.side-effects :as value.side-effects]
              [react-references.api                    :as react-references]
              [time.api                                :as time]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn input-field-focused
  ; @description
  ; Implements the 'focused' event of the input field.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:field-type (keyword)(opt)
  ;  ...}
  ;
  ; @usage
  ; (input-field-focused :my-input {...})
  [id {:keys [field-type] :as props}]
  (keypress-handler/enable-type-mode!)
  (focus.side-effects/input-focused id props)
  (if-let [element-reference (react-references/get-reference id)]
          (cond (-> field-type (= :password)) (dom/select-content! element-reference)
                (-> field-type (= :text))     (dom/select-content! element-reference))))

(defn input-field-left
  ; @description
  ; Implements the 'blurred' event of the input field.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (input-field-left :my-input {...})
  [id props]
  (keypress-handler/disable-type-mode!)
  (focus.side-effects/input-left id props))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn input-field-type-ended
  ; @description
  ; Implements the 'type-ended' event of the input field.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:on-type-ended-f (function)(opt)
  ;  :type-ended-after (ms)(opt)
  ;   Default: 450
  ;  ...}
  ;
  ; @usage
  ; (input-field-type-ended :my-input {...})
  [id {:keys [on-type-ended-f type-ended-after] :as props :or {type-ended-after 450}}]
  ; - This function ('input-field-type-ended') is called by the 'input-field-value-changed' function
  ;   with a delay after the field's content has been changed.
  ; - If the field's content has not changed during that delay, ...
  ;   ... the typing is considered as ended.
  ;   ... the 'on-type-ended-f' function is getting applied.
  ; - This function does not take the field's content as its argument, because the it might changed during the delay.
  (when (activity-listener/idle-time-elapsed? id type-ended-after)
        (let [field-value (value.env/get-input-internal-value id props)]
             (if on-type-ended-f (on-type-ended-f field-value)))))

(defn input-field-value-changed
  ; @description
  ; Implements the 'value-changed' event of the input field.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:on-change-f (function)(opt)
  ;  :on-input-f (function)(opt)
  ;  :on-type-ended-f (function)(opt)
  ;  :type-ended-after (ms)(opt)
  ;   Default: 450
  ;  ...}
  ; @param (DOM-event) input-event
  ;
  ; @usage
  ; (input-field-value-changed :my-input {...})
  [id {:keys [on-change-f on-input-f on-type-ended-f type-ended-after] :as props :or {type-ended-after 450}} input-event]
  ; React, attaches listeners for Component.onChange to the DOM element.oninput event, making the onChange event behave like the onInput event.
  ; Therefore, the ':on-change-f' and ':on-input-f' events are both fired when the input value changes in order to mimic React behavior.
  (let [field-value (field.utils/on-input-event->field-value id props input-event)]
       (activity-listener/reg-activity!     id)
       (value.side-effects/set-input-value! id props field-value)
       (if on-change-f     (on-change-f field-value))
       (if on-input-f      (on-input-f  field-value))
       (if on-type-ended-f (letfn [(f0 [] (input-field-type-ended id props))]
                                  (time/set-timeout! f0 type-ended-after)))))
