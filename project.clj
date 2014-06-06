(defproject score_four "0.1.0"
  :description "A Simple Game of connect Four Dots"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2227"]
                 [org.clojure/core.async "0.1.303.0-886421-alpha"]
                 [om "0.6.3"]]

  :plugins [[lein-cljsbuild "1.0.3"]]

  :source-paths ["src"]

  :cljsbuild {
    :builds [{:id "score_four"
              :source-paths ["src"]
              :compiler {
                :output-to "score_four.js"
                :output-dir "out"
                :optimizations :none
                :source-map true}}]})
