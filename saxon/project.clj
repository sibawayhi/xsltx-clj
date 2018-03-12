(defproject saxon "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :aot [#"saxon.*"]
  :java-source-paths ["src/main/java"]
  :repl-options {:port 4005}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.logging "0.2.6"]
                 ;;[net.sf.saxon/Saxon-HE "9.4"]
                 ;; saxon 9.1.0.8 is the last free version
                 ;; that supports extension functions
                 [net.sourceforge.saxon/saxon "9.1.0.8"]
                 ])
