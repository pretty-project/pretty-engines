
(ns pretty-inputs.methods.shorthand.apply
    (:require [pretty-elements.methods.api :as pretty-elements.methods]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn apply-input-shorthand-key
  ; @description
  ; Converts the given property map to longhand form in case it is provided in shorthand form.
  ;
  ; @param (keyword) id
  ; @param (* or map) props
  ; @param (keyword) shorthand-key
  ;
  ; @usage
  ; (apply-input-shorthand-key :my-input "My content" :content)
  ;
  ; @return (map)
  [id props shorthand-key]
  (pretty-elements.methods/apply-element-shorthand-key id props shorthand-key))

(defn apply-input-shorthand-map
  ; @description
  ; Converts subitems within the given property map to longhand form in case they are provided in shorthand form.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; @param (map) shorthand-map
  ;
  ; @usage
  ; (apply-input-shorthand-map :my-input {:my-subitem "My content" ...} {:my-subitem :content})
  ;
  ; @usage
  ; (apply-input-shorthand-map :my-input {:my-subitem-group ["My content"] ...} {:my-subitem-group :content})
  ;
  ; @return (map)
  [id props shorthand-map]
  (pretty-elements.methods/apply-element-shorthand-map id props shorthand-map))
