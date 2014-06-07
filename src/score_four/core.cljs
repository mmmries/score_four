(ns score_four.core
  (:require [om.core :as om :include-macros true]
            [score_four.board :as b]))

(def app-state (atom [
  ["white" "white" "white" "white" "white" "white" "white"]
  ["white" "white" "white" "white" "white" "white" "white"]
  ["white" "white" "white" "white" "white" "white" "white"]
  ["white" "white" "white" "white" "white" "white" "white"]
  ["white" "white" "white" "white" "white" "white" "white"]
  ["white" "white" "white" "white" "white" "red"   "red"  ]]))

(om/root
  b/board
  app-state
  {:target (. js/document (getElementById "app"))})
