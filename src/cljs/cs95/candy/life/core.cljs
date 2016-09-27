(ns cs95.candy.life.core)


;; http://clj-me.cgrand.net/2011/08/19/conways-game-of-life/

;; compute neighbors
(defn neighbors [[x y]]
  (for [dx [-1 0 1] dy (if (zero? dx) [-1 1] [-1 0 1])]
    [(+ dx x) (+ dy y)]))

;; compute cells available in next generation
(defn step [cells]
  (set (for [[loc n] (frequencies (mapcat neighbors cells))
             :when (or (= n 3) (and (= n 2) (cells loc)))]
         loc)))

;; ;; compute neighbors
;; (defn neighbors [[x y]]
;;   (for [dx [-1 0 1]
;;         dy [-1 0 1]
;;         :when (not= [dx dy] [0 0])]
;;     [(+ dx x) (+ dy y)]))
;;
;; ;; compute cells available in next generation
;; (defn step [cells]
;;   (let [all-neighbors (mapcat neighbors cells)
;;         neighbor-counts (frequencies all-neighbors)]
;;     (set (for [[loc n] neighbors
;;                :when (or (= n 3) (and (= n 2) (cells loc)))]
;;            loc))))
