
(ns pretty-elements.engine.timeout.env
    (:require [countdown-timer.api :as countdown-timer]
              [fruits.css.api      :as css]
              [time.api            :as time]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-element-timeout-left
  ; @description
  ; Returns how many milliseconds left (if any) from the on-click timeout of the element.
  ;
  ; @param (keyword) id
  ; @param (keyword) props
  ;
  ; @usage
  ; (get-element-timeout-left :my-element {...})
  ;
  ; @return (ms)
  [id _]
  (countdown-timer/time-left id))

(defn get-element-timeout-label
  ; @description
  ; Returns a label displaying how many milliseconds left (if any) from the on-click timeout of the element.
  ;
  ; @param (keyword) id
  ; @param (keyword) props
  ;
  ; @usage
  ; (get-element-timeout-label :my-element {...})
  ;
  ; @return (string)
  [id props]
  (if-let [timeout-left (get-element-timeout-left id props)]
          (-> timeout-left time/ms->s css/s)))
