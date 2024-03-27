
(ns pretty-elements.engine.timeout.side-effects
    (:require [countdown-timer.api :as countdown-timer]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn start-element-timeout!
  ; @description
  ; Fires the 'on-click-f' function and initiates the on-click countdown of the element.
  ;
  ; @param (keyword) id
  ; @param (keyword) props
  ; {:on-click-f (function)(opt)
  ;  :on-click-timeout (ms)(opt)
  ;  ...}
  ;
  ; @usage
  ; (start-element-timeout! :my-element {...})
  [id {:keys [on-click-f on-click-timeout]}]
  (let [props {:step 1000 :timeout on-click-timeout :on-start-f on-click-f}]
       (if on-click-timeout (countdown-timer/start-countdown! id props))))
