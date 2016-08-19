(ns cs95.candy.life.view
  (:require [reagent.core :as reagent])
  (:require-macros [cs95.utils.re-frame :refer [with-subs]]))

(defn cell [size coords]
  (let [size (or size 50)]
    [:td {:style {:border "1px solid black"
                  :width size
                  :height size}}])
  #_(with-subs [state [:life/cell-state coords]]
      ))

(defn board [x y width height]
  [:table
   [:tbody
    [:tr [cell] [cell] [cell]]
    [:tr [cell] [cell] [cell]]
    [:tr [cell] [cell] [cell]]]])
