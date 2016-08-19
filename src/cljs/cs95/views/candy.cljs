(ns cs95.views.candy
  (:require [re-frame.core :as re-frame]
            [cs95.candy.life.view :as life]
            [cs95.components.bootstrap :as bs]))

(defn view []
  [:div
   "CANDY"
   [life/board]])

