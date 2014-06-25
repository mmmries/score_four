(ns score_four.game)

(defn new-board []
  [["white" "white" "white" "white" "white" "white"]
   ["white" "white" "white" "white" "white" "white"]
   ["white" "white" "white" "white" "white" "white"]
   ["white" "white" "white" "white" "white" "white"]
   ["white" "white" "white" "white" "white" "white"]
   ["white" "white" "white" "white" "white" "white"]
   ["white" "white" "white" "white" "white" "white"]])

(defn new-game []
  {:board (new-board) :player "red" :winner nil})

(defn- toggle-player [game]
  (if (= (game :player) "red")
    (assoc-in game '(:player) "black")
    (assoc-in game '(:player) "red")))

(defn- set-board-piece [game, column]
  (assoc-in game (array :board column 5) (game :player)))

(defn play [game column]
  (-> game (set-board-piece column) (toggle-player)))
