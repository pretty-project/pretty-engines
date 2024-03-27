
(ns pretty-diagrams.engine.data.utils
    (:require [fruits.mixed.api :as mixed]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn diagram-datum-color
  ; @description
  ; Returns the color of the given diagram datum.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:datum-color-f (function)(opt)
  ;  ...}
  ; @param (integer) dex
  ; @param (*) datum
  ;
  ; @usage
  ; (diagram-datum-color :my-diagram {...} 0 {...})
  ;
  ; @return (keyword or string)
  [_ {:keys [datum-color-f]} _ datum]
  (if datum-color-f (-> datum datum-color-f)
                    (-> :default)))

(defn diagram-datum-value
  ; @description
  ; Returns the value of the given diagram datum.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:datum-value-f (function)(opt)
  ;  ...}
  ; @param (integer) dex
  ; @param (*) datum
  ;
  ; @usage
  ; (diagram-datum-value :my-diagram {...} 0 {...})
  ;
  ; @return (number)
  [_ {:keys [datum-value-f]} _ datum]
  (if datum-value-f (-> datum datum-value-f mixed/to-number)
                    (-> datum               mixed/to-number)))

(defn diagram-datum-offset
  ; @description
  ; Returns the summary value of previous data of the given datum.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:data-offset (numbers in vector)(opt)
  ;  ...}
  ; @param (integer) dex
  ; @param (*) datum
  ;
  ; @usage
  ; (diagram-datum-offset :my-diagram {...} 0 {...})
  ;
  ; @return (number)
  [_ {:keys [data-offset]} dex _]
  (if data-offset (nth data-offset dex)))
