(ns cs95.routes
  (:require-macros [secretary.core :refer [defroute]])
  (:import goog.History)
  (:require [secretary.core :as secretary]
            [goog.events :as events]
            [goog.history.EventType :as EventType]
            [re-frame.core :as re-frame]))

(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
      EventType/NAVIGATE
      (fn [event]
        (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

(defn app-routes []
  (secretary/set-config! :prefix "#")
  ;; --------------------
  ;; define routes here
  (defroute "/" []
    (re-frame/dispatch [:set-active-panel :home]))

  (defroute "/syllabus" []
    (re-frame/dispatch [:set-active-panel :syllabus]))

  (defroute "/assignments" []
    (re-frame/dispatch [:set-active-panel :assignments]))

  (defroute "/resources" []
    (re-frame/dispatch [:set-active-panel :resources]))

  (defroute "/why-lisp" []
    (re-frame/dispatch [:set-active-panel :why-lisp]))

  (defroute "/candy" []
    (re-frame/dispatch [:set-active-panel :candy]))


  ;; --------------------
  (hook-browser-navigation!))
