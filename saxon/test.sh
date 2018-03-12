#!/bin/sh

# http://www.saxonica.com/documentation9.1/using-xsl/commandline.html

# to get <CLASSPATH> do  $ lein classpath > cp.log and copy from there

$CLASSPATH=

java -cp ${CLASSPATH} net.sf.saxon.Transform -s:../test.xml -xsl:test.xsl
