
(ns pretty-accessories.methods.state.import
    (:require [pretty-elements.methods.api :as pretty-elements.methods]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-accessory-state-events
  ; @description
  ; Associates the state related events of the accessory to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-accessory-state-events :my-accessory {...})
  ;
  ; @return (map)
  [id props]
  (pretty-elements.methods/import-element-state-events id props))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-accessory-state
  ; @description
  ; Associates the state related properties of the accessory to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-accessory-state :my-accessory {...})
  ;
  ; @return (map)
  [id props]
  (pretty-elements.methods/import-element-state id props))
