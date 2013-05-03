(ns leiningen.styleguide
  (:require [leiningen.core.eval :refer [eval-in-project]]
            [me.raynes.fs :as fs]))

(comment
  "An example of a user-specified location to place the styleguide
   assets. Used in development."
  (def tmp-project {:styleguide {:base-dir "resources/public/styleguide"
                                 :widgets-dir "resources/public/styleguide/widgets"}}))



(def tmpl-dirs
  {:base-tmpl-dir "resources/styleguide/base"
   :widget-tmpl-dir "resources/styleguide/widgets"})

(defn mkdirs+ [& paths]
  (doseq [path paths]
    (fs/mkdirs path)))

(defn styleguide
  "Generates a styleguide"
  [project & args]
  (let [config (get-in project [:styleguide])]
    (if config
      (let [config (get-in project [:styleguide])
            {:keys [base-tmpl-dir widget-tmpl-dir]} tmpl-dirs
            {:keys [base-dir widgets-dir]}          config]
        (mkdirs+ base-dir widgets-dir)
        (fs/copy-dir base-tmpl-dir base-dir)
        (fs/copy-dir widget-tmpl-dir widgets-dir)))
    (println "You need to specify :styleguide in your project.clj")))
