
(ns pretty-inputs.methods.field.import
    (:require [dynamic-props.api        :as dynamic-props]
              [fruits.loop.api          :refer [<-walk]]
              [pretty-inputs.engine.api :as pretty-inputs.engine]
              [pretty-properties.api    :as pretty-properties]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-input-field-events
  ; @description
  ; Associates the input field related events to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-input-field-events :my-input {...})
  ;
  ; @return (map)
  ; {:on-blur-f (function)
  ;  :on-escape-f (function)
  ;  :on-focus-f (function)
  ;  :on-input-f (function)
  ;  ...}
  [id props]
  ; - Using the '<-walk' function provides the updated property map for each iteration with the previously associated functions available.
  ;   E.g., The 'on-focus-f' function takes the property map with the 'on-escape-f' function already associated.
  ; - Using the 'merge-event-fn' function keeps the provided functions (if any) as well in the property map and merges the following functions under them.
  ;   E.g., If the given property map already contains an 'on-escape-f' function, it will not be overwitten.
  ; - Using the ':on-input-f' event to handle input changes provides more stable behavior compared to the ':on-change-f' event would.
  ;   E.g., A text field input appeared on the UI with content that existed in the application state before the field mounted.
  ;         The first interaction with the field involved a full selection (cmd + A) followed by a clear action (backspace).
  ;         In this particular scenario the ':on-input-f' event failed to fire (Google Chrome version xxx.xxx).
  ; - The 'input-field-value-changed' function triggers the provided ':on-change-f' and ':on-input-f' functions (if any).
  ;   To prevent duplicate firing by the browser, their original instances are dissociated from the given property map.
  ; - The 'input-left' and 'input-focused' functions trigger the provided ':on-blur-f' and ':on-focus-f' functions (if any).
  ;   To prevent duplicate firing by the browser, their original instances are dissociated from the given property map.
  (<-walk props (fn [%] (dissoc % :on-blur-f :on-change-f :on-focus-f :on-input-f))
                (fn [%] (pretty-properties/merge-event-fn % :on-input-f  (fn [v] (pretty-inputs.engine/input-field-value-changed id props v))))
                (fn [%] (pretty-properties/merge-event-fn % :on-input-f  (fn [_] (dynamic-props/merge-props!                     id {:expandable {:mounted? true}}))))
                (fn [%] (pretty-properties/merge-event-fn % :on-escape-f (fn [_] (dynamic-props/merge-props!                     id {:expandable {:mounted? false}}))))
                (fn [%] (pretty-properties/merge-event-fn % :on-blur-f   (fn [_] (pretty-inputs.engine/input-field-left          id props))))
                (fn [%] (pretty-properties/merge-event-fn % :on-focus-f  (fn [_] (pretty-inputs.engine/input-field-focused       id props))))))

(defn import-input-field-value
  ; @description
  ; Associates the displayed content of the input field to the given property map (as field value).
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-input-field-value :my-input {...})
  ;
  ; @return (map)
  ; {:field-value (string)
  ;  ...}
  [id props]
  (let [field-displayed-content (pretty-inputs.engine/get-input-field-displayed-content id props)]
       (-> props (assoc :field-value field-displayed-content))))
