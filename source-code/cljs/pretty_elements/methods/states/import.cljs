
(ns pretty-elements.methods.states.import
    (:require [component-states.api :as component-states]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-element-state-events
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
  ; (import-element-state-events :my-element {...})
  ;
  ; @return (map)
  [id props]
  (component-states/add-component-state-events id props))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-element-states
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
  ; (import-element-states :my-element {...})
  ;
  ; @return (map)
  [id props]
  (->> props (component-states/import-component-states id)
             (component-states/apply-component-states  id)))
