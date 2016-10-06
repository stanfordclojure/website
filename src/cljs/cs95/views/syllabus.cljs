(ns cs95.views.syllabus
  (:require [re-frame.core :as re-frame]
            [cs95.components.alert :as alert]
            [cs95.components.bootstrap :as bs]))

(defn syllabus []
  [bs/table
   ["Date" "Topic"]
   [[1 "Motivation"]]])

(defn view []
  [:div
   [:h1.page-header "Syllabus"]
   [syllabus]])
