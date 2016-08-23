(ns cs95.utils.helper)

(defmacro b
  ([f]
   `(cs95.utils.helper/benchmark (fn [] ~f)))

  ([msg f]
   `(cs95.utils.helper/benchmark ~msg (fn [] ~f))))

(defmacro slurp-dep [path]
  (let [contents (slurp path)]
    contents))

