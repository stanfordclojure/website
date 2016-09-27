(ns cs95.candy.life.view
  (:require [reagent.core :as reagent])
  (:require-macros [cs95.utils.re-frame :refer [with-subs]]))

;; https://www.youtube.com/watch?v=dxLRQ0aKTOQ

(defn gen-key []
  (gensym "key-"))

(defn grid [state]
  [:svg {:width 500
         :height 500
         :viewBox "-450 -450 700 700"}
   (for [[x y] @state]
     ^{:key (gen-key)}
     [:rect {:width 10
             :height 10
             :x (* x 10)
             :y (* y 10)}])])
