(ns copa2014.core
  (:require [copa2014.data :refer :all]
            [clojure.pprint :refer [print-table]]))

(defn update-map-value [map-teams teams u-key f]
  (assoc map-teams
         (teams 0) (update-in (map-teams (teams 0)) [(u-key 0)] (f 0))
         (teams 1) (update-in (map-teams (teams 1)) [(u-key 1)] (f 1))))

(defn update-scores [winner loser map-teams & draw]
  (let [winner-team (-> (keys winner) first)
        winner-goals (winner winner-team)
        winner-info (map-teams winner-team)
        loser-team  (-> (keys loser) first)
        loser-goals (loser loser-team)
        loser-info  (map-teams loser-team)]
    (if draw
      (assoc map-teams winner-team
           (merge winner-info {:draw (inc (winner-info :draw))
                               :points (inc (winner-info :points))
                               :goals  (+ (winner-info :goals) winner-goals)})
           loser-team
           (merge loser-info {:draw (inc (loser-info :draw))
                              :points (inc (loser-info :draw))
                              :goals  (+ (loser-info :goals) loser-goals)}))
      (assoc map-teams
        winner-team
           (merge winner-info {:win (inc (winner-info :win))
                               :points (+ (winner-info :points) 3)
                               :goals  (+ (winner-info :goals) winner-goals)})
        loser-team
           (merge loser-info {:los (inc (loser-info :los))
                              :goals  (+ (loser-info :goals) loser-goals)})))))

(defn game-result [map-teams x]
  (let [team1 {(x 0) (x 1)}
        team2 {(x 2) (x 3)}
        score (fn [x] (-> (keys x) first (x)))]
    (cond
     (> (score team1) (score team2)) (update-scores team1 team2 map-teams)
     (> (score team2) (score team1)) (update-scores team2 team1 map-teams)
     :else (update-scores team1 team2 map-teams :draw))))

(defn map-teams-formatter [x]
  (zipmap (map :team x) x))

(defn statistics [x]
  (let [teams (-> (into (map #(% 0) x) (map #(% 2) x)) distinct)
        map-teams (->> (map #(assoc {} :team % :win 0 :los 0 :draw 0 :goals 0 :points 0) teams)
                       map-teams-formatter)
        values  (loop [x x
                       map-teams map-teams]
                  (if (empty? x) map-teams
                      (recur (rest x) (game-result map-teams (first x)))))]
    (print-table
     [:team :win :draw :los :goals :points]
     (reverse
      (sort-by (juxt :win :points :goals)
               (map #(get values %) teams))))))
