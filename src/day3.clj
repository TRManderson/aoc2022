(ns day3
  (:require [clojure.set :refer [intersection]]))


(defn priority
  [^Character data]
  (let [num (byte data)]
    (cond 
      (and (>= num (byte \a)) (<= num (byte \z))) (- num (byte \a) -1)
      (and (>= num (byte \A)) (<= num (byte \Z))) (- num (byte \A) -27)
      true 0
      )))

(defn in-both
  [rucksack]
  (let [split (/ (count rucksack) 2)
        fst (take split rucksack)
        snd (drop split rucksack)]
    (first (intersection (set fst) (set snd)))))

(defn parta
  [_]
  (->> (java.io.BufferedReader. *in*)
       line-seq
       (map in-both)
       (map priority)
       (reduce + 0)
       print)
  )

(defn in-three
  [all]
  (first (reduce intersection (map set all))))

(defn partb
  [_]
  (->> (java.io.BufferedReader. *in*)
       line-seq
       (partition 3)
       (map in-three)
       (map priority)
       (reduce + 0)
       print))