(ns cs95.views.syllabus
  (:require [re-frame.core :as re-frame]
            [cs95.components.alert :as alert]
            [cs95.components.bootstrap :as bs]
            [cs95.components.markdown :as md]
            [cljs-time.core :as ti]
            [cljs-time.format :as tf]))

(defn recurring-event [{:keys [interval dates]}]
  (let [add-time #(ti/plus % interval)]
    (lazy-seq (concat dates (recurring-event {:interval interval
                                              :dates (map add-time dates)})))))

(def formatter (tf/formatter "EEE, MMM d"))
(def day->str (partial tf/unparse formatter))

(def class-days
  (let [dates (recurring-event {:interval (ti/weeks 1)
                                :dates [(ti/date-time 2016 9 27) (ti/date-time 2016 9 29)]})]
    (map day->str dates)))

(def topics (mapv #(identity [md/md-div %])
                  [
"Motivation
- [Slides](/lectures?n=1)"
"Getting Started
- [Slides](/lectures?n=2)"

"Intro to `clojure.core` + Quick Lab
- [Slides](/lectures?n=3)"
"Functional Programming + Lab
- [Slides](/lectures?n=4)
- [Assignment 1](#/assignments/pset1) Released!"

"Bottom-Up Programming
- [Slides](/lectures?n=5)"
"Lab"

"Polymorphism
- <mark>Assignment 1 due!</mark>"
"Clojure's Builtin Protocols"

"Reading, Evaluation, and Macros"
"More on macros + Lab"

"Concurrency/Parallelism: Tasks"
"Concurrency/Parallelism: Identity/State/Value"

"Communicating Sequential Processes: `core.async`"
"LAB"

"Interop: Java"
"Interop: Javascript"

"Bonus: ClojureScript + React.js"
"Bonus: re-frame, react native"

"NO CLASS: Thanksgiving Break"
"NO CLASS: Thanksgiving Break"

"Bonus: Simple Made Easy"
"Bonus: You choose!"
                   ]))

(defn syllabus []
  [bs/table (zipmap [:striped :bordered] (repeat true))
   ["Week" "Date" "Topic"]
   (mapv vector (interleave (map inc (range)) (repeat "")) class-days topics)])

(defn view []
  [:div
   [:h1.page-header "Syllabus"]
   [syllabus]])
