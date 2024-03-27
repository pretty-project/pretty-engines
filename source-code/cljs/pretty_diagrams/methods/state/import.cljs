
(ns pretty-diagrams.methods.state.import
    (:require [pretty-elements.methods.api :as pretty-elements.methods]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-diagram-state-events
  ; @description
  ; Associates the state related events of the diagram to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-diagram-state-events :my-diagram {...})
  ;
  ; @return (map)
  [id props]
  (pretty-elements.methods/import-element-state-events id props))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-diagram-state
  ; @description
  ; Associates the state related properties of the diagram to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-diagram-state :my-diagram {...})
  ;
  ; @return (map)
  [id props]
  (pretty-elements.methods/import-element-state id props))
