(ns day1 
  (:require [shared :refer [aoc]]))

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


(def go #(->> % 
              (map parse-int)
              splitter
              (map (partial reduce + 0))
              sort
              reverse))

(defn parta [_]
  (aoc go first))

(defn partb [_]
  (aoc
   go
   (take 3)
   (reduce + 0)))