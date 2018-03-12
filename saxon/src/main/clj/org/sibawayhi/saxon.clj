(ns org.sibawayhi.saxon
  (:import (net.sf.saxon.lib ExtensionFunctionDefinition
                             Initializer) ;; Interface
           (net.sf.saxon Configuration)))

;; We generate the two classes needed, one for the extension shim and
;; one for Saxon's initializer.

;; Extension shims - these must come first, since the initializer refers
;; to the generated classes. One per extension function. They delegate
;; to impl-ns.
(gen-class
 :name org.sibawayhi.saxon.test
 :main false
 :extends net.sf.saxon.lib.ExtensionFunctionDefinition
 :impl-ns org.sibawayhi.saxon.test-impl
 )

(gen-class
 :name org.sibawayhi.saxon.init
 :main false
 :implements [net.sf.saxon.lib.Initializer]
 :prefix "sax-"
 )

(defn sax-initialize
  [this ^Configuration config]
  (.registerExtensionFunction config (org.sibawayhi.saxon.test.)))
