(ns score_four.game-test
  (:require-macros [cemerick.cljs.test
                    :refer (is deftest with-test run-tests testing test-var)])
  (:require [cemerick.cljs.test :as t]
            [score_four.game :as g]))

(deftest new-board-all-white
  (is (= (((g/new-board) 0) 0) "white")))
