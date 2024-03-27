
(ns pretty-elements.methods.timeout.import
    (:require [pretty-elements.engine.api :as pretty-elements.engine]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-element-timeout-events
  ; @description
  ; Associates the timeout related events of the element to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:on-click-f (function)(opt)
  ;  :on-click-timeout (ms)(opt)
  ;  ...}
  ;
  ; @usage
  ; (import-element-timeout-events :my-element {...})
  ;
  ; @return (map)
  [id {:keys [on-click-f on-click-timeout] :as props}]
  (letfn [(f0 [] (pretty-elements.engine/start-element-timeout! id props))]
         (if (pretty-elements.engine/get-element-timeout-left id props)
             (-> props (assoc-in [:on-click-f] (if on-click-timeout f0 on-click-f)))
             (-> props (assoc-in [:on-click-f] (if on-click-timeout f0 on-click-f))))))

(defn import-element-timeout
  ; @description
  ; Associates the timeout related properties of the element to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-element-timeout :my-element {...})
  ;
  ; @return (map)
  [id props]
  (if-let [timeout-label (pretty-elements.engine/get-element-timeout-label id props)]
          (-> props (assoc-in [:cover :label :content] (-> timeout-label))
                    (assoc-in [:disabled?]             (-> true)))
          (-> props)))
