(ns cs95.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [cs95.core-test]))

(doo-tests 'cs95.core-test)
