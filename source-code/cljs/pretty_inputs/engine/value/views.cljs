
(ns pretty-inputs.engine.value.views
    (:require [pretty-inputs.engine.value.env          :as value.env]
              [pretty-inputs.engine.value.side-effects :as value.side-effects]
              [state-synchronizer.api                  :as state-synchronizer]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn input-synchronizer
  ; @description
  ; - Input external and internal value synchronizer that uses Reagent lifecycles to keep the input synchronized.
  ; - When the external value of the input (output of the 'get-value-f' function) changes independently from the internal value,
  ;   the synchronizer updates the internal value by importing the updated external value.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; [:div [input-synchronizer :my-input {...}]
  ;       "My input"]
  [id props]

  ; TESTING (REMOVE THIS COMMENT IF THE SOLUTION WORKS PROPERLY)
  ; The 'autoclear?' property was set to TRUE, but the sensor unmounts after its wrapper, and it wrote a NIL into the input state as internal value
  ; AFTER the 'input-will-unmount' function ereased the input from the input state. That caused leftover NIL internal values.

  [state-synchronizer/sensor id {:autoclear? false
                                 :get-monitor-value-f #(value.env/get-input-internal-value           id props)
                                 :get-trigger-value-f #(value.env/get-input-external-value           id props)
                                 :set-primary-state-f #(value.side-effects/set-input-internal-value! id props %)
                                 :debug? false}])
