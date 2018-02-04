(defproject cs95 "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.225"]
                 [org.clojure/core.async "0.2.385"]
                 [reagent "0.6.0-rc"]
                 [re-frame "0.8.0"]
                 [secretary "1.2.3"]
                 [cljsjs/react-bootstrap "0.30.2-0"]
                 [cljs-ajax "0.7.3"]
                 [compojure "1.5.0"]
                 [yogthos/config "0.8"]
                 [ring "1.4.0"]
                 [cljsjs/markdown-it "7.0.0-0"]
                 [cljsjs/highlight "9.5.0-0"]
                 [rm-hull/monet "0.3.0"]
                 [com.andrewmcveigh/cljs-time "0.4.0"]]

  :plugins [[lein-cljsbuild "1.1.3"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj" "dev"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"
                                    "test/js"]

  :figwheel {:css-dirs ["resources/public/css"]
             :ring-handler cs95.handler/dev-handler
             :server-port 3001}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.9.2"]
                   [figwheel-sidecar "0.5.9"]
                   [com.cemerick/piggieback "0.2.1"]]

    ;; need to add dev source path here to get user.clj loaded
    :source-paths ["src/cljs" "dev"]

    ;; for CIDER
    ;; :plugins [[cider/cider-nrepl "0.12.0"]]
    :repl-options {; for nREPL dev you really need to limit output
                   :init (set! *print-length* 50)
                   :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

    :plugins      [[lein-figwheel "0.5.4-3"]
                   [lein-doo "0.1.6"]]
    }}


  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs" "src/clj"]
     :figwheel     {:on-jsload "cs95.core/mount-root"}
     :compiler     {:main                 cs95.core
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :asset-path           "js/compiled/out"
                    :source-map-timestamp true}}

    {:id           "min"
     :source-paths ["src/cljs"]
     :jar true
     :compiler     {:main            cs95.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}
    {:id           "test"
     :source-paths ["src/cljs" "test/cljs"]
     :compiler     {:output-to     "resources/public/js/compiled/test.js"
                    :output-dir           "resources/public/js/compiled/test"
                    :main          cs95.runner
                    :optimizations :none}}
    ]}

  :main cs95.server

  :aot [cs95.server]

  :uberjar-name "cs95.jar"

  :prep-tasks [["cljsbuild" "once" "min"] "compile"]
  )
