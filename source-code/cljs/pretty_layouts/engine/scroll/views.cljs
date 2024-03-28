
(ns pretty-layouts.engine.scroll.views
    (:require [component-props.api :as component-props]
              [dynamic-props.api         :as dynamic-props]
              [intersection-observer.api :as intersection-observer]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn layout-header-sensor
  ; @description
  ; Returns a scroll sensor element that tracks overlapping of the layout header.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (layout-header-sensor :my-layout {...})
  ;
  ; @usage
  ; [:<> [:div "My layout header"]
  ;      [:div {:style {:overflow-y :scroll}}
  ;            [layout-header-sensor :my-layout {...}]
  ;            [:div "My layout body"]]
  [id _]
  (letfn [(f0 [%] (dynamic-props/merge-props! id {:header-overlapping? (not %)}))]
         [intersection-observer/sensor {:callback-f f0}]))

(defn layout-footer-sensor
  ; @description
  ; Returns a scroll sensor element that tracks overlapping of the layout footer.
  ;
  ; @param (keyword) id
  ; @param (map) props
  ;
  ; @usage
  ; (layout-footer-sensor :my-layout {...})
  ;
  ; @usage
  ; [:<> [:div {:style {:overflow-y :scroll}}
  ;            [:div "My layout body"]]
  ;            [layout-footer-sensor :my-layout {...}]
  ;      [:div "My layout footer"]
  [id _]
  (letfn [(f0 [%] (dynamic-props/merge-props! id {:footer-overlapping? (not %)}))]
         [intersection-observer/sensor {:callback-f f0}]))
