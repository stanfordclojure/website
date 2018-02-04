(ns cs95.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame]
            [reagent.ratom :as ratom]))

(re-frame/reg-sub
  :name
  (fn [db]
    (:name db)))

(re-frame/reg-sub
  :active-panel
  (fn [db _]
    (:active-panel db)))


(re-frame/reg-sub
  :cleanup
  (fn [db [_ path]]
    (update-in db (butlast path) dissoc (last path))))


(re-frame/reg-sub
  :write
  (fn [db [_ path value]]
    (assoc-in db path value)))


(defn reg-sub-raw
  [kw {:keys [query path default dispose]}]
  {:pre [(keyword? kw)
         (fn? query)
         (vector? path)
         (or (nil? dispose)
             (fn? dispose))]}
  (re-frame/register-sub
    kw
    (fn [db [_ & args]]
      (let [query-token (apply query args)]
        (ratom/make-reaction
          #(get-in @db path default)
          :on-dispose #(when dispose (dispose query-token)))))))
