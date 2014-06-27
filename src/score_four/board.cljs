(ns score_four.board
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [score_four.game :as g]
            [cljs.core.async :refer [put! chan <!]]))

(defn play [cell]
  (om/transact! cell [0] (fn [state] "red")))

(defn cell [cell owner]
  (reify
  om/IRender
  (render [this]
    (dom/td nil
      (dom/div #js {
        :className (str "hole " (first cell))
        :onClick (fn [e] (play cell))
      } nil)))))

(defn row [row owner]
  (reify
  om/IRender
  (render [this]
    (apply dom/tr nil
      (om/build-all cell row)))))

(defn board [app owner]
  (reify
  om/IRender
  (render [this]
    (apply dom/table #js {:id "board"}
      (om/build-all row app)))))
