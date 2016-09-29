(ns cs95.candy.mandelbrot.complex
  (:require [goog.math :as math]))

(defn add
  "Complex addition"
  [c1 c2]
  (map + c1 c2))

(defn multiply
  "Complex Multiplication"
  [[real-a imag-a] [real-b imag-b]]
  [(- (* real-a real-b)
      (* imag-a imag-b))

   (+ (* real-a imag-b)
      (* imag-a real-b))])

(defn abs
  "Complex Absolute Value"
  [[real imag]]
  (js/Math.sqrt
    (+ (* real real)
       (* imag imag))))

