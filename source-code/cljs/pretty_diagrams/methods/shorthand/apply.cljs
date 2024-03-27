
(ns pretty-diagrams.methods.shorthand.apply
    (:require [pretty-elements.methods.api :as pretty-elements.methods]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn apply-diagram-shorthand-key
  ; @description
  ; Converts the given property map to longhand form in case it is provided in shorthand form.
  ;
  ; @param (keyword) id
  ; @param (* or map) props
  ; @param (keyword) shorthand-key
  ;
  ; @usage
  ; (apply-diagram-shorthand-key :my-diagram "My content" :content)
  ;
  ; @return (map)
  [id props shorthand-key]
  (pretty-elements.methods/apply-element-shorthand-key id props shorthand-key))

(defn apply-diagram-shorthand-map
  ; @description
  ; Converts subitems within the given property map to longhand form in case they are provided in shorthand form.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; @param (map) shorthand-map
  ;
  ; @usage
  ; (apply-diagram-shorthand-map :my-diagram {:my-subitem "My content" ...} {:my-subitem :content})
  ;
  ; @usage
  ; (apply-diagram-shorthand-map :my-diagram {:my-subitem-group ["My content"] ...} {:my-subitem-group :content})
  ;
  ; @return (map)
  [id props shorthand-map]
  (pretty-elements.methods/apply-element-shorthand-map id props shorthand-map))
