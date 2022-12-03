(ns shared)

(defmacro
  aoc
  [& forms]
  `(->> (java.io.BufferedReader. *in*)
        (line-seq)
        ~@forms
        print))