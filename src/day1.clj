(ns day1 
  (:require [clojure.string :as string]))

(defn parse-int [^String n]
  (try
    (Integer/parseInt n)
    (catch NumberFormatException _ nil)))

(defn splitter
  [input]
  (loop [data input acc []]
    (if (empty? data)
      acc
      (recur (rest (drop-while (comp not nil?) data))
             (conj acc (take-while (comp not nil?) data))))))


(defn core []
  (->> (java.io.BufferedReader. *in*)
       (line-seq)
       (map parse-int)
       splitter
       (map (partial reduce + 0))
       sort
       reverse))

(defn parta [_]
  (->> (core)
       first
       print))

(defn partb [_]
  (->> (core)
       (take 3)
       (reduce + 0)
       print))