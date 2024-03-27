
(ns pretty-elements.methods.state.import
    (:require [dynamic-props.api     :as dynamic-props]
              [fruits.map.api        :as map]
              [pretty-properties.api :as pretty-properties]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------
 
(defn import-element-state-events
  ; @description
  ; Associates the state related events of the element to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:active (map)(opt)
  ;  :hovered (map)(opt)
  ;  ...}
  ;
  ; @usage
  ; (import-element-state-events :my-element {...})
  ;
  ; @return (map)
  [id {:keys [active hovered] :as props}]
  (letfn [(f0 [%] (dynamic-props/update-props! id assoc  :active? true))
          (f1 [%] (dynamic-props/update-props! id dissoc :active?))
          (f2 [%] (dynamic-props/update-props! id assoc  :hovered? true))
          (f3 [%] (dynamic-props/update-props! id dissoc :hovered?))]
         (cond-> props active  (pretty-properties/merge-event-fn :on-mouse-down-f  f0)
                       active  (pretty-properties/merge-event-fn :on-mouse-up-f    f1)
                       hovered (pretty-properties/merge-event-fn :on-mouse-over-f  f2)
                       hovered (pretty-properties/merge-event-fn :on-mouse-leave-f f3))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn import-element-state
  ; @description
  ; Associates the state related properties of the element to the given property map.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ; {:active (map)(opt)
  ;  :active? (boolean)(opt)
  ;  :disabled (map)(opt)
  ;  :disabled? (boolean)(opt)
  ;  :highlighted (map)(opt)
  ;  :highlighted? (boolean)(opt)
  ;  :hovered (map)(opt)
  ;  :hovered? (boolean)(opt)
  ;  ...}
  ;
  ; @usage
  ; (import-element-state :my-element {...})
  ;
  ; @return (map)
  [id {:keys [active active? disabled disabled? highlighted highlighted? hovered hovered?] :as props}]
  (cond-> props disabled?    (map/deep-merge disabled)    ; 0.
                highlighted? (map/deep-merge highlighted) ; 1. An element can get highlighted while it is disabled.
                hovered?     (map/deep-merge hovered)     ; 2. An element can get hovered while it is highlighted.
                active?      (map/deep-merge active)))    ; 3. An element can get active while it is hovered.
