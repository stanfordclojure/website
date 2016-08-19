(ns cs95.core-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [cs95.core :as core]))

(deftest fake-test
  (testing "fake description"
    (is (= 1 2))))
