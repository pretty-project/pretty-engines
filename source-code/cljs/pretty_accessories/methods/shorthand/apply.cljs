
(ns pretty-accessories.methods.shorthand.apply
    (:require [pretty-elements.methods.api :as pretty-elements.methods]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn apply-accessory-shorthand-key
  ; @description
  ; Converts the given property map to longhand form in case it is provided in shorthand form.
  ;
  ; @param (keyword) id
  ; @param (* or map) props
  ; @param (keyword) shorthand-key
  ;
  ; @usage
  ; (apply-accessory-shorthand-key :my-accessory "My content" :content)
  ;
  ; @return (map)
  [id props shorthand-key]
  (pretty-elements.methods/apply-element-shorthand-key id props shorthand-key))

(defn apply-accessory-shorthand-map
  ; @description
  ; Converts subitems within the given property map to longhand form in case they are provided in shorthand form.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; @param (map) shorthand-map
  ;
  ; @usage
  ; (apply-accessory-shorthand-map :my-accessory {:my-subitem "My content" ...} {:my-subitem :content})
  ;
  ; @usage
  ; (apply-accessory-shorthand-map :my-accessory {:my-subitem-group ["My content"] ...} {:my-subitem-group :content})
  ;
  ; @return (map)
  [id props shorthand-map]
  (pretty-elements.methods/apply-element-shorthand-map id props shorthand-map))
