JAVA=java
TMPDIR=tmp

CLOJURE=${HOME}/.m2/repository/org/clojure/clojure/1.8.0/clojure-1.8.0.jar

# JARDIR=/usr/local/share/saxon
# SAXON=saxon9he.jar

# XSLDIR=xsl
# HTMLDIR=html
# SRC=../perseus/lane

# ROOT=

test: FORCE
	${JAVA} \
	-cp "/usr/local/share/saxon/saxon9he.jar:/usr/local/share/xerces/xercesImpl.jar:${CLOJURE}:src/main/clj:target" \
	-Dfile.encoding=utf8 \
	-Djavax.xml.parsers.DocumentBuilderFactory=org.apache.xerces.jaxp.DocumentBuilderFactoryImpl \
	-Djavax.xml.parsers.SAXParserFactory=org.apache.xerces.jaxp.SAXParserFactoryImpl \
	-Dorg.apache.xerces.xni.parser.XMLParserConfiguration=org.apache.xerces.parsers.XIncludeAwareParserConfiguration \
	net.sf.saxon.Transform \
	-init:org.sibawayhi.saxon.init \
	-xi:on \
	-xsl:test.xsl \
	-s:../test.xml \
	-o:${TMPDIR}/out.xml \
	2> ${TMPDIR}/test.log;

FORCE:
