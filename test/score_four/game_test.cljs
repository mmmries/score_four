(ns score_four.game-test
  (:require-macros [cemerick.cljs.test
                    :refer (is deftest with-test run-tests testing test-var)])
  (:require [cemerick.cljs.test :as t]
            [score_four.game :as g]))

(def ng (g/new-game))

(deftest fill-out-column-with-whites
  (is (= (g/fill-out-column ["red"]) ["red" "white" "white" "white" "white" "white"])))

(deftest new-game-player-red
  (is (= (ng :player) "red")))

(deftest new-game-winner-nil
  (is (= (ng :winner) nil)))

(deftest playing-an-open-board
  (is (= (((g/play ng 0) :board) 0) ["red"])))

(deftest playing-multiple-turns
  (let [gm (g/play (g/play ng 0) 1)]
    (is (= ((gm :board) 0) ["red"]))
    (is (= ((gm :board) 1) ["black"]))))

(deftest play-until-win
  (let [gm (-> ng (g/play 0) (g/play 1) (g/play 0) (g/play 1) (g/play 0) (g/play 1) (g/play 0))]
    (is (= ((gm :board) 0) ["red" "red" "red" "red"]))
    (is (= (gm :winner) "red"))))
