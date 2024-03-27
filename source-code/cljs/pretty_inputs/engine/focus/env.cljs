
(ns pretty-inputs.engine.focus.env
    (:require [common-state.api :as common-state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn input-focused?
  ; @description
  ; Returns TRUE if the input is marked as focused.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (input-focused? :my-input {...})
  ;
  ; @return (boolean)
  [id _]
  (common-state/get-state :pretty-ui id :focused?))
