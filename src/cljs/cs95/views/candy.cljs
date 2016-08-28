(ns cs95.views.candy
  (:require [re-frame.core :as re-frame]
            [reagent.core :as r]
            [cs95.candy.life.view :as life-view]
            [cs95.candy.life.core :as life]
            [cs95.components.bootstrap :as bs]
            [cljs.core.async :as async :refer [timeout <!]])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]
                   [cs95.utils.helper :refer [slurp-dep]]))

(defonce state (r/atom #{[-1 0] [0 0] [1 0]}))

(defn evolve [state]
  (swap! state life/step))

(defn play []
  (go-loop []
    (<! (timeout 100))
    (swap! state life/step)
    (recur)))

(defn interesting-seed []
  (reset! state #{[-1 0] [-1 1] [0 -1] [0 0] [1 0]}))

(defn explanation []
  [:div
   [:p "This core of this game of life implementation occurs in just 7 lines of code."]
   [:h3 "cs95.candy.life.core"]
   [:pre (slurp-dep "src/cljs/cs95/candy/life/core.cljs")]
   [:h3 "cs95.candy.life.view"]
   [:pre (slurp-dep "src/cljs/cs95/candy/life/view.cljs")]
   [:h3 "cs95.views.candy"]
   [:pre (slurp-dep "src/cljs/cs95/views/candy.cljs")]])

(defn view []
  [:div
   [life-view/grid state]
   [:br]
   [bs/Button {:on-click play} "Start Simulation"]
   [bs/Button {:on-click interesting-seed} "Interesting..."]
   [:hr]
   [explanation]])

