(ns main.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            ["moment" :as moment]
            ;; doesn't work, probably because no `dist` file.
            #_["ak-design-system/lib/Button" :default Button]))

(defn app
  []
  [:<>
   [:h1 "It works 🎉"]
   [:p "This file has been executed at " (.format (moment)) "."]
   #_[:> Button {:on-click (fn [_e] (println "clicked"))
               :className ""
               :style {}}]])

(defn ^:export init []
  (re-frame/clear-subscription-cache!)
  (->> "app"
       (.getElementById js/document)
       (reagent/render [app])))
