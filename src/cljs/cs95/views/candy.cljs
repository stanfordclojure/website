(ns cs95.views.candy
  (:require [reagent.core :as r]
            [cs95.candy.life.view :as life-view]
            [cs95.candy.life.core :as life]
            [cs95.components.bootstrap :as bs]
            [cljs.core.async :as async :refer [timeout <!]])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]
                   [cs95.utils.helper :refer [slurp-dep]]))

;; jank for now...
(defonce cells (r/atom #{[-1 0] [0 0] [1 0]}))
(defonce play? (r/atom false))

(defn evolve []
  (swap! cells life/step))

(defn toggle-play []
  (swap! play? not))

(defn interesting-seed []
  (reset! cells #{[-1 0] [-1 1] [0 -1] [0 0] [1 0]}))

;; this code creates the page you see now. woooo magic.
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
   [life-view/grid cells]
   [:br]
   [bs/Button {:bs-style "primary" :on-click toggle-play} (if @play? "Stop" "Start") "Simulation"]
   [bs/Button {:bs-style "info" :on-click interesting-seed} "Interesting..."]
   [:hr]
   [explanation]])

(go-loop []
  (<! (timeout 100))
  (when @play? (evolve))
  (recur))
