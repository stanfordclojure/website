(ns cs95.views
  (:require [re-frame.core :as re-frame]
            [cs95.components.bootstrap :as bs]
            [cs95.components.alert :as alert]
            [cs95.components.frame :as frame]
            [cs95.views.todo :as todo]
            [cs95.views.landing :as landing]
            [cs95.views.markdown :as markdown])
  (:require-macros [cs95.utils.re-frame :refer [with-subs]]
                   [cs95.utils.helper :refer [slurp-dep]]))

(defmulti panels identity)
(defmethod panels :home [] [landing/view])
(defmethod panels :syllabus [] [todo/view])
(defmethod panels :assignments [] [todo/view])
(defmethod panels :resources [] [markdown/view (slurp-dep "./doc/resources.md")])
(defmethod panels :default [] [:div])

(def panel-data
  [{:event-key :home :href "#/" :title "Overview"}
   {:event-key :syllabus :href "#/syllabus" :title "Syllabus"}
   {:event-key :assignments :href "#/assignments" :title "Assignments"}
   {:event-key :resources :href "#/resources" :title "Resources"}])


(defn main-panel []
  (with-subs [active-panel [:active-panel]]
    [:div
     [frame/navbar panel-data active-panel]
     [bs/Grid
      [panels active-panel]]]))
