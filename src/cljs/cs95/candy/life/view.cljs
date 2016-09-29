(ns cs95.candy.life.view
  (:require [reagent.core :as r]
            [cs95.candy.life.core :as life]
            [cs95.components.bootstrap :as bs]
            [cs95.components.code :as code]
            [cljs.core.async :as async :refer [timeout <!]]
            [cljsjs.highlight])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]
                   [cs95.utils.helper :refer [slurp-dep]]
                   [cs95.utils.re-frame :refer [with-subs]]))

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
   [:p "The core of this game of life implementation occurs in just 7 lines of code."]
   [:h3 "cs95.candy.life.core"]
   [code/show (slurp-dep "src/cljs/cs95/candy/life/core.cljs")]
   [:h3 "cs95.candy.life.view"]
   [code/show (slurp-dep "src/cljs/cs95/candy/life/view.cljs")]])

(defn view []
  [:div
   [grid cells]
   [:br]
   [bs/Button {:bs-style "primary" :on-click toggle-play} (if @play? "Stop" "Start") " Simulation"]
   [bs/Button {:bs-style "info" :on-click interesting-seed} "Interesting..."]
   [:hr]
   [explanation]
   [:hr]])

(go-loop []
         (<! (timeout 40))
         (when @play? (evolve))
         (recur))

