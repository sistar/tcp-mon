(ns tcp-mon.core
  (:require [byte-streams :as b]
            [manifold.stream :as s]
            [aleph.tcp :as tcp])
  (:gen-class))

(defn dump-handler2 [s info]
  (s/consume #(prn (b/convert % String)) s))
(defn -main
  "dead simple tcp port monitor."
  [& args]
  (tcp/start-server dump-handler2 {:port 10007}))
