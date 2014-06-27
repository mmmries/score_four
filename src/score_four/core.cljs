(ns score_four.core
  (:require [om.core :as om :include-macros true]
            [score_four.board :as b]
            [score_four.game  :as g]))

(def app-state (atom (g/new-game)))

(om/root
  b/board
  app-state
  {:target (. js/document (getElementById "app"))})
