(ns cs95.components.frame
  (:require [cs95.components.bootstrap :as bs]))

(defn nav-item [{:keys [title] :as opts}]
  [bs/NavItem opts title])

(defn navbar [nav-items active-panel]
  [bs/Navbar {:inverse true}
   [bs/Navbar.Header
    [bs/Navbar.Brand
     [:a {:href "#"} "StanfordClojure"]]
    [bs/Navbar.Toggle]]
   [bs/Navbar.Collapse
    (-> [bs/Nav {:pull-right true
                 :active-key active-panel}]
      (concat (map nav-item nav-items))
      vec)]])

