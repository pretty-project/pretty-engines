
(ns pretty-accessories.methods.states.import
    (:require [pretty-elements.methods.api :as pretty-elements.methods]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-accessory-state-events
  ; @links
  ; [cljs-component-states](https://mt-app-kit.github.io/cljs-component-states)
  ;
  ; @description
  ; Associates the state related events of the component to the given property map
  ; in case of any event controlled state (':focused', ':hovered' or ':pressed') is provided.
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

(defn import-accessory-states
  ; @links
  ; [cljs-component-states](https://mt-app-kit.github.io/cljs-component-states)
  ;
  ; @description
  ; Imports all dynamically set component state toggles (e.g., ':active?' ':disabled?', etc.) into the given property map.
  ; Applies the current states of the component on the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (import-accessory-states :my-accessory {...})
  ;
  ; @return (map)
  [id props]
  (pretty-elements.methods/import-element-states id props))
