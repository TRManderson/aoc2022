(ns day2
  (:require [clojure.string :as string]))

(defn parse-line
  [line]
  (let [row (vec line)
        fst (first row)
        lst (nth row 2)]
    [(case fst
       \A :rock
       \B :paper
       \C :scissors)
     (case lst
       \X :rock
       \Y :paper
       \Z :scissors)])
  )

(defn score
  [game]
  (case game
    [:rock :rock] 4
    [:scissors :scissors] 6
    [:paper :paper] 5
    [:rock :scissors] 3
    [:scissors :paper] 2
    [:paper :rock] 1
    [:rock :paper] 8
    [:paper :scissors] 9
    [:scissors :rock] 7
    ))

(defn core [_]
  (->> (java.io.BufferedReader. *in*)
       (line-seq)
       (map parse-line)
       (map score)
       (reduce + 0)
       print))