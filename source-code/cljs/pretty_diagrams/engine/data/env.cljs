
(ns pretty-diagrams.engine.data.env
    (:require [fruits.mixed.api :as mixed]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-diagram-data
  ; @description
  ; Returns the provided data of the diagram.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:get-data-f (function)(opt)
  ;  ...}
  ;
  ; @usage
  ; (get-diagram-data :my-diagram {...})
  ;
  ; @return (vector)
  [_ {:keys [get-data-f]}]
  (if get-data-f (let [data (get-data-f)]
                      (-> data mixed/to-vector))))
