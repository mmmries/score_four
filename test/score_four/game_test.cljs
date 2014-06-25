(ns score_four.game-test
  (:require-macros [cemerick.cljs.test
                    :refer (is deftest with-test run-tests testing test-var)])
  (:require [cemerick.cljs.test :as t]
            [score_four.game :as g]))

(def ng (g/new-game))

(deftest new-board-all-white
  (is (= (((g/new-board) 0) 0) "white")))

(deftest new-game-player-red
  (is (= (ng :player) "red")))

(deftest new-game-winner-nil
  (is (= (ng :winner) nil)))

(deftest playing-an-open-board
  (is (= (((g/play ng 0) :board) 0) ["white" "white" "white" "white" "white" "red"])))

(deftest playing-multiple-turns
  (let [gm (g/play (g/play ng 0) 1)]
    (is (= ((gm :board) 0) ["white" "white" "white" "white" "white" "red"]))
    (is (= ((gm :board) 1) ["white" "white" "white" "white" "white" "black"]))))

(deftest play-until-win
  (let [gm (-> ng (g/play 0) (g/play 1) (g/play 0) (g/play 1) (g/play 0) (g/play 1) (g/play 0))]
    (is (= ((gm :board) 0) ["white" "white" "red" "red" "red" "red"]))
    (is (= (gm :winner) "red"))))
