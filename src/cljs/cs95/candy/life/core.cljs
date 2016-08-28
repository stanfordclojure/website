(ns cs95.candy.life.core
  (:require))

;; http://clj-me.cgrand.net/2011/08/19/conways-game-of-life/

(defn neighbors [[x y]]
  (for [dx [-1 0 1] dy (if (zero? dx) [-1 1] [-1 0 1])]
    [(+ dx x) (+ dy y)]))

(defn step [cells]
  (set (for [[loc n] (frequencies (mapcat neighbors cells))
             :when (or (= n 3) (and (= n 2) (cells loc)))]
         loc)))
