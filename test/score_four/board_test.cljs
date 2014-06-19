(ns score_four.board-test
  (:require-macros [cemerick.cljs.test
                    :refer (is deftest with-test run-tests testing test-var)])
  (:require [cemerick.cljs.test :as t]))

(deftest board-test
  (is (= 2 2)))

(deftest another
  (is (= 1 2)))

(deftest seriously?
  (is (= 12 "WAT")))
