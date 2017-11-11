(ns cs95.views.assignments
  (:require [reagent.core :as r]
            [cs95.candy.life.view :as life]
            [cs95.candy.mandelbrot.view :as mandelbrot]
            [cs95.components.bootstrap :as bs]
            [cs95.views.not-found :as not-found]
            [cljs.core.async :as async :refer [timeout <!]]
            [cs95.views.markdown :as markdown])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]
                   [cs95.utils.helper :refer [slurp-dep]]
                   [cs95.utils.re-frame :refer [with-subs]]))

(defmulti candy identity)
(defmethod candy :pset1 [] [markdown/view (slurp-dep "./doc/assignments/pset1.md")])
(defmethod candy :pset2 [] [markdown/view (slurp-dep "./doc/assignments/pset2.md")])
(defmethod candy :default [] [not-found/view])

(def candies [] #_[{:event-key :pset1 :title "1. Intro to Clojure!"}
                   {:event-key :pset2 :title "2. Do something: Implement Poker!"}])

(defn ->breadcrumb [-name]
  {:name -name})

(defn ->bc [bc -name]
  (let [prefix (:href (last bc) "#")
        href (str prefix "/" (name -name))]
    (conj bc {:name -name :href href})))

(defn show-candy [path]
  [:div
   [bs/breadcrumb (reduce ->bc [] path)]
   [candy (last path)]])

(defn list-candy [{:keys [event-key title]}]
  [bs/ListGroupItem {:href (str "#/assignments/" (name event-key))} title])

(defn list-candies []
  [:div
   [:h1.page-header "Assignments"]
   (if (not (empty? candies))
     (into [bs/ListGroup] (map list-candy candies))
     [:p "First assignment coming soon!"])])

(defn view []
  (with-subs [active-panel [:active-panel]]
    [:div
     (if (coll? active-panel)
       [show-candy active-panel]
       [list-candies])]))

