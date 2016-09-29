(ns cs95.candy.mandelbrot.view
  (:require [cs95.components.bootstrap :as bs]
            [cs95.candy.mandelbrot.core :as mandelbrot]
            [cs95.components.code :as code])
  (:require-macros [cs95.utils.helper :refer [slurp-dep]]))

;; this code creates the page you see now. woooo magic.
(defn explanation []
  [:div
   [:h3 "cs95.candy.mandelbrot.complex"]
   [code/show (slurp-dep "src/cljs/cs95/candy/mandelbrot/complex.cljs")]
   [:h3 "cs95.candy.mandelbrot.core"]
   [code/show (slurp-dep "src/cljs/cs95/candy/mandelbrot/core.cljs")]
   [:h3 "cs95.candy.mandelbrot.view"]
   [code/show (slurp-dep "src/cljs/cs95/candy/mandelbrot/view.cljs")]])

(defn view []
  [:div
   [:canvas#candy-canvas {:style {:width 600 :height 400 :border "1px solid black"}}]
   [:br]
   [bs/Button {:bs-style "primary" :on-click mandelbrot/dostuff} "Draw Mandelbrot Set (slow)"]
   [:hr]
   [explanation]])

