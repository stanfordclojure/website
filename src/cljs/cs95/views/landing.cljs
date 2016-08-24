(ns cs95.views.landing
  (:require [re-frame.core :as re-frame]
            [cs95.components.alert :as alert]
            [cs95.components.bootstrap :as bs]))

(defn clj-logo [style]
  [:img {:src "/img/clojure-logo.png"
         :style style}])

(defn page-header []
  [bs/Row
   [bs/Col {:md 12}
    [bs/PageHeader
     [clj-logo {:height 50
                :margin-right 10}]
     "CS95: Functional Programming in Clojure"]]])

(defn course-description []
  [bs/Row
   [bs/Col {:md 12}
    [:h2 "Course Description"]
    [:p "Clojure is a dialect of Lisp that runs on the JVM, CLR, or Javascript engine. This course explores the fundamentals and philosophy of Clojure, with emphasis on the benefits of immutability and functional programming that make it such a powerful and fun language. Topics include: immutability, functional programming (function composition, higher order functions), concurrency (atoms, promises, futures, actors, Software Transactional Memory, etc), LISP (REPL-driven development, homoiconicity, macros), and interop (between Clojure code and code native to the host VM). The course also explores design paradigms and looks at the differences between functional and object-oriented programming, as well as bottom-up versus top-down design."]]])

(defn administrivia []
  [bs/Row
   [bs/Col {:md 6}
    [:h3 "Class Time and Location"]
    [:p "Fall quarter (September - December, 2016)"]
    [:p "Lecture: Tuesday, Thursday 4:30-5:50"]
    [:p "Location: Bldg. 160 Rm. 319"]]
   [bs/Col {:md 6}
    [:h3 "Office Hours"]
    [:p "TBD"]]])

(defn view []
  [:div
   [alert/show
    {:bs-style 'danger}
    [:div
     [:p {:style {:font-size 30}}
      "Apply " [:a {:href "https://goo.gl/forms/lrjddAU1xGFTOFeC3"
                    :target "_blank"} "here"] "!"]
     [:p {:style {:font-size 20}} "Application due September 30."]]]
   [page-header]
   [course-description]
   [:hr]
   [administrivia]
   #_[:h3 "Grading Policy"]])

