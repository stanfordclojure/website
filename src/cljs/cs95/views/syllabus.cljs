(ns cs95.views.syllabus
  (:require [re-frame.core :as re-frame]
            [cs95.components.alert :as alert]
            [cs95.components.bootstrap :as bs]
            [cs95.components.markdown :as md]
            [cljs-time.core :as ti]
            [cljs-time.format :as tf])
  (:require-macros [cs95.utils.helper :refer [slurp-dep]]))

(defn recurring-event [{:keys [interval dates]}]
  (let [add-time #(ti/plus % interval)]
    (lazy-seq (concat dates (recurring-event {:interval interval
                                              :dates (map add-time dates)})))))

(def formatter (tf/formatter "EEE, MMM d"))
(def day->str (partial tf/unparse formatter))

(def class-days
  (let [dates (recurring-event {:interval (ti/weeks 1)
                                :dates [(ti/date-time 2018 1 9) (ti/date-time 2018 1 11)]})]
    (map day->str dates)))

(def topics (mapv (fn [t] [md/md-div t])
                  (-> (slurp-dep "doc/syllabus.md")
                    (.split "---")
                    (.map #(.trim %)))))

(defn syllabus []
  [bs/table (zipmap [:striped :bordered] (repeat true))
   ["Week" "Date" "Topic"]
   (mapv vector (interleave (map inc (range)) (repeat "")) class-days topics)])

(defn view []
  [:div
   [:h1.page-header "Syllabus"]
   [syllabus]])
