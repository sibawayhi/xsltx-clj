(ns org.sibawayhi.saxon.test-impl
  (:require [clojure.string :as str :refer [join split]])
  (:import (net.sf.saxon.om StructuredQName
                            Item        ; an Interface
                            Sequence)   ; an Interface
           (net.sf.saxon.expr XPathContext)
           (net.sf.saxon.lib ExtensionFunctionCall)
           (net.sf.saxon.trans XPathException)
           (net.sf.saxon.value SequenceType
                               StringValue)))

(defn munge [txt]
  (str "Foobar " (str/upper-case txt)))

;; @Override
(defn ^StructuredQName
  -getFunctionQName [this]
  (StructuredQName. "" "http://sibawayhi.org/xslt-fns" "test"))

;; @Override
(defn ^"[Lnet.sf.saxon.value.SequenceType;" ; type for SequenceType[]
  -getArgumentTypes [this]
  ;; return new SequenceType[]{...};
  (into-array SequenceType [SequenceType/SINGLE_STRING]))

;; @Override
(defn ^SequenceType -getResultType
  [this ^"[Lnet.sf.saxon.value.SequenceType;" argtypes]
  SequenceType/SINGLE_STRING
  )

;; @Override
(defn ^ ExtensionFunctionCall
  -makeCallExpression [this]
  (proxy [net.sf.saxon.lib.ExtensionFunctionCall] []
      (^Sequence
       call [^XPathContext context
             ^"[Lnet.sf.saxon.value.SequenceType;" arguments]
        (let [arg1 (aget arguments 0)
              hd (.head arg1)
              content (.getStringValue hd)
              result (munge content)
              ]
          ;; return must implement saxon's Sequence interface
          (StringValue. result)))))
