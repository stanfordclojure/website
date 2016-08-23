(ns cs95.components.markdown
  (:require [re-frame.core :as re-frame]
            [cs95.components.bootstrap :as bs]
            [cljsjs.markdown-it]))

(def md (js/markdownit #js {:linkify true}))
(def render-md #(.render md %))

(defn html-div [html-content]
  [:div {"dangerouslySetInnerHTML" #js {:__html html-content}}])

(defn md-div [markdown]
  [html-div (render-md markdown)])

