(ns day2b
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
       \X :lose
       \Y :draw
       \Z :win)])
  )

(defn score
  [game]
  (case game
    [:rock :win] 8
    [:scissors :win] 7
    [:paper :win] 9
    [:rock :draw] 4
    [:scissors :draw] 6
    [:paper :draw] 5
    [:rock :lose] 3
    [:paper :lose] 1
    [:scissors :lose] 2
    ))

(defn core [_]
  (->> *in*
       slurp
       string/split-lines
       (map parse-line)
       (map score)
       (reduce + 0)
       print))