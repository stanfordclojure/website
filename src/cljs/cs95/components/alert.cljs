(ns cs95.components.alert
  (:require [re-frame.core :as re-frame]
            [cs95.components.bootstrap :as bs]))

;; TODO make an API to dispatch an alert and make it show

(defn show [opts message]
  [bs/Alert opts message])

