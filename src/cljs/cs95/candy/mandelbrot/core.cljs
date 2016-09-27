(ns cs95.candy.mandelbrot.core
  (:require [cs95.candy.mandelbrot.complex :as c]
            [monet.canvas :as canvas]
            [goog.color :as color]
            [clojure.string :as string]))

;; https://nakkaya.com/2009/09/29/fractals-in-clojure-mandelbrot-fractal/

;; Helpers

(defn draw-dot [ctx color x y]
  (aset ctx "fillStyle" color)
  (.fillRect ctx x y 1 1))

;; Mandelbrot

(defn calc-iterations [p q max-iterations]
  (let [c [p q]]
    (loop [z c
           iterations 0]
      (if  (or (> (c/abs z) 2.0)
               (> iterations max-iterations))
        (if (= 0 iterations)
          0
          (- iterations 1))
        (recur (c/add c (c/multiply z z)) (inc iterations))))))

(defn calc-pixel-color [iterations max-iterations]
  (if (or (< iterations 10)
          (= iterations max-iterations))
    (color/rgbToHex 0 0 0)
    (let [gray (int (/ (* iterations 255) max-iterations))
          r gray
          g (Math/min (int ( / (* 5 ( * gray gray)) 255)) 255)
          b (Math/min (int (+ 40 ( / (* 5 (* gray gray)) 255))) 255)]
      (color/rgbToHex r g b))))

(defn draw [ctx x y width height max-iterations
            surface-width surface-height]
  (doseq [i (range surface-width)
          j (range surface-height)]
    (let  [p (+ x (* width (/ i surface-width)))
           q (+ y (* height (/ j surface-height)))
           iterations (calc-iterations p q max-iterations)
           color (calc-pixel-color iterations max-iterations)]
      (draw-dot ctx color i j))))

;; Main

(defn dostuff []
  (let [canvas-dom (.getElementById js/document "candy-canvas")
        monet-canvas (canvas/init canvas-dom "2d")
        ctx (:ctx monet-canvas)]
    (draw ctx -2.1 -1.15 3.0 3.1 32 300 200)))

