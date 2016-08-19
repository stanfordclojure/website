(ns cs95.utils.reagent)

(defmacro require-reagent-class [root deps]
  (cons 'do
        (for [dep deps]
          `(def ~(symbol dep) (reagent.core/adapt-react-class (aget ~root ~@(clojure.string/split dep #"\.")))))))

