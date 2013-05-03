(defproject lein-styleguide "0.2.0-SNAPSHOT"
  :description "Generate a styleguide for your Clojure web application"
  :url "https://github.com/devn/lein-styleguide"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "The same license as Clojure"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [me.raynes/fs "1.4.0"]]
  :profiles {:dev {:dependencies [[midje "1.5.1" :exclusions [org.clojure/clojure]]
                                  [clj-webdriver "0.6.0"]]
                   :plugins [[lein-midje "3.0.1"]]}}
  :eval-in-leiningen true
  :styleguide {:base-dir "resources/public/styleguide"
               :widgets-dir "resources/public/styleguide/widgets"}
  :min-lein-version "2.0.0")
