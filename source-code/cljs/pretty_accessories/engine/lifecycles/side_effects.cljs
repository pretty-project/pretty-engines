
(ns pretty-accessories.engine.lifecycles.side-effects
    (:require [pretty-elements.engine.api :as pretty-elements.engine]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn accessory-did-mount
  ; @description
  ; Implements the 'component-did-mount' lifecycle of the accessory.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (accessory-did-mount :my-accessory {...})
  [id props]
  (pretty-elements.engine/element-did-mount id props))

(defn accessory-will-unmount
  ; @description
  ; Implements the 'component-will-unmount' lifecycle of the accessory.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (accessory-will-unmount :my-accessory {...})
  [id props]
  (pretty-elements.engine/element-will-unmount id props))
