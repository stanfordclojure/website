(ns cs95.components.code
  (:require [cljsjs.highlight]))

(.initHighlighting js/hljs)

(defn show [src]
  [:pre>code src])
