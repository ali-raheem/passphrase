(defproject passphrase "0.1.1-SNAPSHOT"
  :description "Passphrase generator"
  :url "https://github.com/wolfmankurd/passphrase"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot passphrase.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
