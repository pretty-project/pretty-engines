
(ns pretty-renderers.engine.lifecycles.side-effects
    (:require [pretty-elements.engine.api :as pretty-elements.engine]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn renderer-did-mount
  ; @description
  ; Implements the 'component-did-mount' lifecycle of the renderer.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (renderer-did-mount :my-renderer {...})
  [id props]
  (pretty-elements.engine/element-did-mount id props))

(defn renderer-will-unmount
  ; @description
  ; Implements the 'component-will-unmount' lifecycle of the renderer.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (renderer-will-unmount :my-renderer {...})
  [id props]
  (pretty-elements.engine/element-will-unmount id props))
