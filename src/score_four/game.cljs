(ns score_four.game)

(defn new-board []
  [["white" "white" "white" "white" "white" "white" "white"]
   ["white" "white" "white" "white" "white" "white" "white"]
   ["white" "white" "white" "white" "white" "white" "white"]
   ["white" "white" "white" "white" "white" "white" "white"]
   ["white" "white" "white" "white" "white" "white" "white"]
   ["white" "white" "white" "white" "white" "white" "white"]])

(defn new-game []
  {:build (new-board) :player "red" :winner nil})
