(ns cs95.views.landing
  (:require [re-frame.core :as re-frame]
            [cs95.components.alert :as alert]
            [cs95.components.bootstrap :as bs]))

(defn- clj-logo [style]
  [:img {:src "/img/clojure-logo.png"
         :style style}])

(defn- page-header []
  [bs/Row
   [bs/Col {:md 12}
    [bs/PageHeader
     [clj-logo {:height 50
                :margin-right 10}]
     "CS43: Functional Programming in Clojure"]]])

(defn- flashy-picture []
  [:center [:img.img-responsive {:src "/img/structural_sharing.png"
                                 :style {:width "45%"}}]])

(defn- course-description []
  [bs/Row
   [bs/Col {:md 12}
    [:h2 "Course Description"]
    [:p "Clojure is a dialect of Lisp that runs on the JVM, CLR, or Javascript engine. This course explores the fundamentals and philosophy of Clojure, with emphasis on the benefits of immutability and functional programming that make it such a powerful and fun language. Topics include: immutability, functional programming (function composition, higher order functions), concurrency (atoms, promises, futures, actors, Software Transactional Memory, etc), LISP (REPL-driven development, homoiconicity, macros), and interop (between Clojure code and code native to the host VM). The course also explores design paradigms and looks at the differences between functional and object-oriented programming, as well as bottom-up versus top-down design."]]])

(defn- your-sexy-instructors []
  [:div
   [bs/Row
    [bs/Col {:md 12}
     [:h3 "Course Instructors"]]]
   [bs/Row
    [bs/Col {:md 2}
     [:img.img-circle.img-responsive {:src "https://avatars0.githubusercontent.com/u/4052045"}]
     [:h4.text-center "Allan Jiang"]]
    [bs/Col {:md 2}
     [:img.img-circle.img-responsive {:src "https://avatars2.githubusercontent.com/u/2874516"}]
     [:h4.text-center "Adithya Ganesh"]]
    #_[bs/Col {:md 8} ;; LOL
     [:blockquote "clojure has helped me lose so much weight and feel better every day!"]]]])

(defn- administrivia []
  [bs/Row
   [bs/Col {:md 6}
    [:h3 "Class Time and Location"]
    [:p "Winter quarter (January - March, 2018)"]
    [:p "Lecture: Tuesday, Thursday 4:30-5:50"]
    [:p "Location: Bldg. 200 Rm. 030"]]
   [bs/Col {:md 6}
    [:h3 "Office Hours"]
    [:p "Allan: 11am-1pm, on Wednesdays at Florence Moore Dining (Paloma)"]
    [:p "Adi: 11am-1pm, on Mondays at Arrillaga Dining (downstairs tables)"]
    [:p "Or by appointment"]]])

(defn view []
  [:div
   #_[alert/show
    {:bs-style 'danger}
    [:div
     [:p {:style {:font-size 30}}
      "Apply " [:a {:href "https://goo.gl/forms/lrjddAU1xGFTOFeC3"
                    :target "_blank"} "here"] "!"]
     [:p {:style {:font-size 20}} "Application due September 30."]]]
   [page-header]
   [flashy-picture]
   [course-description]
   [:hr]
   [your-sexy-instructors]
   [:hr]
   [administrivia]
   [bs/vspace 100]
   #_[:h3 "Grading Policy"]])

