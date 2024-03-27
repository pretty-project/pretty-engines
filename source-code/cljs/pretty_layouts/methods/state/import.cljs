
(ns pretty-layouts.methods.state.import
    (:require [pretty-elements.methods.api :as pretty-elements.methods]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-layout-state-events
  ; @description
  ; Associates the state related events of the layout to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-layout-state-events :my-layout {...})
  ;
  ; @return (map)
  [id props]
  (pretty-elements.methods/import-element-state-events id props))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-layout-state
  ; @description
  ; Associates the state related properties of the layout to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-layout-state :my-layout {...})
  ;
  ; @return (map)
  [id props]
  (pretty-elements.methods/import-element-state id props))
