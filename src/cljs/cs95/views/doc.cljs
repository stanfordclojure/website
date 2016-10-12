(ns cs95.views.doc
  (:require [re-frame.core :as re-frame]
            [cs95.views.markdown :as markdown])
  (:require-macros [cs95.utils.helper :refer [slurp-dep]]
                   [cs95.utils.re-frame :refer [with-subs]]))

(def filename->contents
  {"fireplace" (slurp-dep "./doc/fireplace.md")
   "counterclockwise" (slurp-dep "./doc/counterclockwise.md")
   "why_lisp" (slurp-dep "./doc/why_lisp.md")
   "resources" (slurp-dep "./doc/resources.md")
   })

(defn view []
  (with-subs [panel [:active-panel]]
    (let [[_ filename] panel]
      [markdown/view (get filename->contents filename "# Page not found.")])))

