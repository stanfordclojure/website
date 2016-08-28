(ns cs95.candy.life.view
  (:require [reagent.core :as reagent])
  (:require-macros [cs95.utils.re-frame :refer [with-subs]]))

;; https://www.youtube.com/watch?v=dxLRQ0aKTOQ

(defn grid [state]
  [:svg {:width 500
         :height 500
         :viewBox "-250 -250 500 500"}
   (for [[x y] @state]
     [:rect {:width 20
             :height 20
             :x (* x 20)
             :y (* y 20)}])])
