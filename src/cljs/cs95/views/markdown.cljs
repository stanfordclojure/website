(ns cs95.views.markdown
  (:require [re-frame.core :as re-frame]
            [cs95.components.bootstrap :as bs]
            [cs95.components.markdown :as md]
            [cljsjs.markdown-it]))

(defn view [markdown]
  [md/md-div markdown])

