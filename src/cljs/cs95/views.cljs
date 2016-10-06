(ns cs95.views
  (:require [re-frame.core :as re-frame]
            [cs95.components.bootstrap :as bs]
            [cs95.components.alert :as alert]
            [cs95.components.frame :as frame]
            [cs95.views.todo :as todo]
            [cs95.views.not-found :as not-found]
            [cs95.views.candy :as candy]
            [cs95.views.landing :as landing]
            [cs95.views.lectures :as lectures]
            [cs95.views.syllabus :as syllabus]
            [cs95.views.markdown :as markdown])
  (:require-macros [cs95.utils.re-frame :refer [with-subs]]
                   [cs95.utils.helper :refer [slurp-dep]]))

(defmulti panels #(if (coll? %) (first %) %)) ;; identity
(defmethod panels :candy [] [candy/view])
(defmethod panels :home [] [landing/view])
(defmethod panels :syllabus [] #_[syllabus/view] [markdown/view (slurp-dep "./doc/syllabus.md")])
(defmethod panels :lectures [] [lectures/view])
(defmethod panels :assignments [] [markdown/view (slurp-dep "./doc/assignments/pset1.md")])
(defmethod panels :resources [] [markdown/view (slurp-dep "./doc/resources.md")])
(defmethod panels :why-lisp [] [markdown/view (slurp-dep "./doc/why_lisp.md")])
(defmethod panels :default [] [not-found/view])

(def nav-data
  [{:event-key :home :href "#/" :title "Overview"}
   {:event-key :syllabus :href "#/syllabus" :title "Syllabus"}
   #_{:event-key :lectures :href "#/lectures" :title "Lectures"}
   {:event-key :assignments :href "#/assignments" :title "Assignments"}
   {:event-key :resources :href "#/resources" :title "Resources"}
   {:event-key :candy :href "#/candy" :title "Candy"}])

(defn main-panel []
  (with-subs [active-panel [:active-panel]]
    [:div
     [frame/navbar nav-data active-panel]
     [bs/Grid
      [panels active-panel]]]))
