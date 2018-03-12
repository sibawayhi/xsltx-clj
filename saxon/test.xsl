<?xml version='1.0' encoding='UTF-8'?>
<xsl:stylesheet version='2.0'
		xmlns:ext="http://sibawayhi.org/xslt-fns"
		xmlns:xj='java:saxon.ext'
		xmlns:fib='xalan://fib.FibonacciNumber'
		xmlns:xsl='http://www.w3.org/1999/XSL/Transform'
		exclude-result-prefixes='xj fib'>

  <xsl:output method='xml' indent='yes'/>

  <xsl:template match='/'>
    <reRoot>
      <reNode>
	<xsl:value-of select='/root/node/@val' /> world
      </reNode>
      <xsl:apply-templates/>
    </reRoot>
  </xsl:template>

  <xsl:template match="node">
    <xsl:element name="bar">
      <xsl:value-of select='.'/>
    </xsl:element>
    <xsl:text>&#x0A;</xsl:text>
    <foo><xsl:value-of select='ext:test(.)'/></foo>
  </xsl:template>
</xsl:stylesheet>
