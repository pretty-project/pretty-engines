
(ns pretty-diagrams.methods.data.import
    (:require [fruits.mixed.api           :as mixed]
              [fruits.vector.api          :as vector]
              [pretty-diagrams.engine.api :as pretty-diagrams.engine]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-diagram-data-sum
  ; @note
  ; Diagrams that display data need or might need ...
  ; ... the calculated total value of data (to calculate data / datum ratio).
  ; ... the summary value of previous data (offset) for each datum (to calculate datum positions).
  ; ... the datum count.
  ; ... the datum maximum.
  ;
  ; @description
  ; - Calculates the total value of diagram data and associates the result to the given diagram property map.
  ; - Calculates the summary value of previous data (offset) and associates the result to the given diagram property map.
  ; - Associates the datum count to the given property map.
  ; - Associates the datum maximum (greatest datum value) to the given property map.
  ; - Ensures that the ':max-value' property is a number.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-diagram-data-sum :my-diagram {:get-data-f #(-> [1 2 3 4]) ...})
  ; =>
  ; {:data-offset [0 1 3 6]
  ;  :datum-count 4
  ;  :datum-max   4
  ;  :get-data-f  #(-> [1 2 3 4])
  ;  :max-value   0
  ;  :total-value 10
  ;  ...}
  ;
  ; @return (map)
  ; {:data-offset (numbers in vector)
  ;  :datum-count (integer)
  ;  :datum-max (number)
  ;  :max-value (number)
  ;  :total-value (number)
  ;  ...}
  [id props]
  (let [data (pretty-diagrams.engine/get-diagram-data id props)]
       (letfn [(f0 [props] (update props :max-value mixed/to-number))
               (f1 [props] (reduce-kv f2 props data))
               (f2 [{:keys [datum-max total-value] :as props} datum-dex datum]
                   (let [datum-value (pretty-diagrams.engine/diagram-datum-value id props datum-dex datum)]
                        (-> props (assoc  :datum-max   (max datum-value (or datum-max   0)))
                                  (update :total-value +                (or datum-value 0))
                                  (update :data-offset vector/conj-item (or total-value 0))
                                  (update :datum-count inc))))]
              (-> props f0 f1))))
