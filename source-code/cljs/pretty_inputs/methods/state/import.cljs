
(ns pretty-inputs.methods.state.import
    (:require [pretty-elements.methods.api :as pretty-elements.methods]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-input-state-events
  ; @description
  ; Associates the state related events of the input to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-input-state-events :my-input {...})
  ;
  ; @return (map)
  [id props]
  (pretty-elements.methods/import-element-state-events id props))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-input-state
  ; @description
  ; Associates the state related properties of the input to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-input-state :my-input {...})
  ;
  ; @return (map)
  [id props]
  (pretty-elements.methods/import-element-state id props))
