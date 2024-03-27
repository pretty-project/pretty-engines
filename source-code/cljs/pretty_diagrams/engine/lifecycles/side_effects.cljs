
(ns pretty-diagrams.engine.lifecycles.side-effects
    (:require [pretty-elements.engine.api :as pretty-elements.engine]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn diagram-did-mount
  ; @description
  ; Implements the 'component-did-mount' lifecycle of the diagram.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (diagram-did-mount :my-diagram {...})
  [id props]
  (pretty-elements.engine/element-did-mount id props))

(defn diagram-will-unmount
  ; @description
  ; Implements the 'component-will-unmount' lifecycle of the diagram.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (diagram-will-unmount :my-diagram {...})
  [id props]
  (pretty-elements.engine/element-will-unmount id props))
