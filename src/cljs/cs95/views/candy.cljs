(ns cs95.views.candy
  (:require [re-frame.core :as re-frame]
            [reagent.core :as r]
            [cs95.candy.life.view :as life-view]
            [cs95.candy.life.core :as life]
            [cs95.components.bootstrap :as bs]
            [cljs.core.async :as async :refer [timeout <!]])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(defonce state (r/atom #{[-1 0] [0 0] [1 0]}))

(defn evolve [state]
  (swap! state life/step))

(defn view []
  [life-view/grid state])

(defn play []
  (go-loop []
    (<! (timeout 100))
    (swap! state life/step)
    (recur)))

(defn interesting-seed []
  (reset! state #{[-1 0] [-1 1] [0 -1] [0 0] [1 0]}))
