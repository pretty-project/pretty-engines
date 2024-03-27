
(ns pretty-elements.engine.focus.side-effects
    (:require [dom.api              :as dom]
              [react-references.api :as react-references]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn focus-element!
  ; @description
  ; Sets the DOM focus on the element.
  ;
  ; @param (keyword) id
  ; @param (keyword) props
  ;
  ; @usage
  ; (focus-element! :my-element {...})
  [id _]
  (if-let [element-reference (react-references/get-reference id)]
          (dom/focus-element! element-reference)))

(defn blur-element!
  ; @description
  ; Removes the DOM focus from the element.
  ;
  ; @param (keyword) id
  ; @param (keyword) props
  ;
  ; @usage
  ; (blur-element! :my-element {...})
  [id _]
  (if-let [element-reference (react-references/get-reference id)]
          (dom/blur-element! element-reference)))
