package org.sibawayhi;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

import net.sf.saxon.lib.ExtensionFunctionDefinition;
import net.sf.saxon.lib.ExtensionFunctionCall;
import net.sf.saxon.om.Item;
import net.sf.saxon.om.StructuredQName;
import net.sf.saxon.value.SequenceType;
import net.sf.saxon.value.StringValue;

// interfaces
import net.sf.saxon.expr.XPathContext;
import net.sf.saxon.om.Sequence;

import net.sf.saxon.trans.XPathException;

// import net.sf.saxon.s9api.ExtensionFunction;
// import net.sf.saxon.s9api.ItemType;
// import net.sf.saxon.s9api.OccurrenceIndicator;
// import net.sf.saxon.s9api.QName;
// import net.sf.saxon.s9api.SaxonApiException;
// import net.sf.saxon.s9api.SequenceType;
// import net.sf.saxon.s9api.XdmAtomicValue;
// import net.sf.saxon.s9api.XdmValue;

public class Test extends ExtensionFunctionDefinition {
    @Override
    public StructuredQName getFunctionQName() {
        return new StructuredQName("eg",
				   "http://sibawayhi.org/xslt-fns",
				   "test");
    }

    @Override
    public SequenceType[] getArgumentTypes() {
        // return new SequenceType[]{};
        return new SequenceType[]{SequenceType.SINGLE_STRING};
        // return new SequenceType[]{SequenceType.SINGLE_INTEGER, SequenceType.SINGLE_INTEGER};
    }

    @Override
    public SequenceType getResultType(SequenceType[] suppliedArgumentTypes) {
        return SequenceType.SINGLE_STRING;
    }

    @Override
    public ExtensionFunctionCall makeCallExpression() {
        return new ExtensionFunctionCall() {
            @Override
            public Sequence call(XPathContext context, Sequence[] arguments) throws XPathException {
		System.out.print("RUNNING Test::call\n");

		Item arg1 = arguments[0].head();
		String content = arg1.getStringValue();

		System.out.print("Input string: " + content + "\n");

		final IFn require = Clojure.var("clojure.core", "require");

		require.invoke(Clojure.read("org.sibawayhi.saxon.test"));

		IFn munge = Clojure.var("org.sibawayhi.saxon.test", "munge");

		String result = (String)munge.invoke(content);

		return new StringValue(result);
		//return new StringValue("XXXXZ");
            }
        };
    }
}

