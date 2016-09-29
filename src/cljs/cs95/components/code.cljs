(ns cs95.components.code
  (:require [cljsjs.highlight]))

(.initHighlightingOnLoad js/hljs)

(defn show [src]
  [:pre [:code.clojure src]])
