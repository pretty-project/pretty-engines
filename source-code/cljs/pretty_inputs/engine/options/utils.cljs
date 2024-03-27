
(ns pretty-inputs.engine.options.utils)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn input-option-value
  ; @description
  ; Returns the value of the given input option.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:option-value-f (function)(opt)
  ;  ...}
  ; @param (integer) dex
  ; @param (*) option
  ;
  ; @usage
  ; (input-option-value :my-input {...} 0 {...})
  ;
  ; @return (*)
  [_ {:keys [option-value-f]} dex option]
  (if option-value-f (-> option option-value-f)
                     (-> dex)))
