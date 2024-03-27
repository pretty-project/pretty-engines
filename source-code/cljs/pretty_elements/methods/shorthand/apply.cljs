
(ns pretty-elements.methods.shorthand.apply
    (:require [fruits.map.api       :as map]
              [fruits.shorthand.api :as shorthand]
              [fruits.vector.api    :as vector]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn apply-element-shorthand-key
  ; @description
  ; Converts the given property map to longhand form in case it is provided in shorthand form.
  ;
  ; @param (keyword) id
  ; @param (* or map) props
  ; @param (keyword) shorthand-key
  ;
  ; @usage
  ; (apply-element-shorthand-key :my-element "My content" :content)
  ;
  ; @return (map)
  [_ props shorthand-key]
  (shorthand/apply-shorthand-key props shorthand-key))

(defn apply-element-shorthand-map
  ; @description
  ; Converts subitems within the given property map to longhand form in case they are provided in shorthand form.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; @param (map) shorthand-map
  ;
  ; @usage
  ; (apply-element-shorthand-map :my-element {:my-subitem "My content" ...} {:my-subitem :content})
  ;
  ; @usage
  ; (apply-element-shorthand-map :my-element {:my-subitem-group ["My content"] ...} {:my-subitem-group :content})
  ;
  ; @return (map)
  [_ props shorthand-map]
  ; Always convert shorthanded subitems in case of any update is applied on them (e.g., prototype function)!
  (shorthand/apply-shorthand-map props shorthand-map))
