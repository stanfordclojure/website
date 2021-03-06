(ns cs95.components.bootstrap
  (:require [reagent.core :as reagent]
            [cljsjs.react-bootstrap])
  (:require-macros [cs95.utils.reagent :refer [require-reagent-class]]))

(require-reagent-class
  js/ReactBootstrap
  ["Grid" "Row" "Col"
   "Navbar" "Navbar.Header" "Navbar.Brand" "Navbar.Toggle" "Nav" "NavItem" "NavDropdown" "Navbar.Collapse"
   "MenuItem"
   "Glyphicon"
   "Form" "FormGroup" "ControlLabel" "FormControl"
   "FormControl.Feedback" "HelpBlock"
   "PageHeader"
   "Button"
   "Image"
   "Table"
   "Panel"
   "ListGroup" "ListGroupItem"
   "Alert"
   "Breadcrumb" "Breadcrumb.Item"])

(defn vspace [height]
  [:div {:style {:height height}}])

(defn hspace [width]
  [:div {:style {:width width :display "inline-block"}}])

(defn breadcrumb-item [{:keys [name href active]}]
  [Breadcrumb.Item {:href href :active active} name])

(defn breadcrumb [items]
  (let [eyes (update-in items [((comp dec count) items)] assoc :active true)]
    (into [Breadcrumb] (map breadcrumb-item eyes))))

(defn table-cell [data]
  (into [:tr] (map #(identity [:th %]) data)))

(defn table-head [data]
  [:thead
   [table-cell data]])

(defn table-body [data]
  (into [:tbody] (map #(identity [table-cell %]) data)))

(defn table
  ([head-data body-data]
   [table {} head-data body-data])
  ([opts head-data body-data]
   [Table opts
    [table-head head-data]
    [table-body body-data]]))

