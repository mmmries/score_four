(ns score_four.game)

(defn fill-out-column [col]
  (let [number-of-whites (- 6 (count col))]
    (apply conj col (repeat number-of-whites "white"))))

(defn fill-out-board [board]
  (map board fill-out-column))

(defn new-board []
  [[] [] [] [] [] [] []])

(defn new-game []
  {:board (new-board) :player "red" :winner nil})

(defn- toggle-player [game]
  (if (= (game :player) "red")
    (assoc-in game '(:player) "black")
    (assoc-in game '(:player) "red")))

(defn- set-board-piece [game, column]
  (let [idx (count ((game :board) column))]
    (assoc-in game (array :board column idx) (game :player))))

(defn play [game column]
  (-> game (set-board-piece column) (toggle-player)))
