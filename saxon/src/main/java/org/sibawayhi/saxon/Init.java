package org.sibawayhi.saxon;

import net.sf.saxon.lib.Initializer;
import net.sf.saxon.Configuration;

import org.sibawayhi.Test;

public class Init implements Initializer
{

    public void initialize(Configuration config)
	throws javax.xml.transform.TransformerException
    {
	System.out.print("RUNNING org.sibawayhi.saxon.Init::initializer\n");
	config.registerExtensionFunction(new Test());
    }
}
