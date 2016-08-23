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
   "Alert"])

(defn vspace [height]
  [:div {:style {:height height}}])

(defn hspace [width]
  [:div {:style {:width width :display "inline-block"}}])

