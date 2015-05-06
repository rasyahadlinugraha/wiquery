# What is that ? #

WiQuery is configurable using the WiQuerySettings class. Not everything is configurable (yet), but most features are.

# How to use #

  * The preferred way for changing WiQuery settings upon startup is creating a wicket.properties and an IWiQueryInitializer. This is similar to how Wicket loads it's IInitializer classes. In short: Wicket scans the classpath for wicket.properties files which contain the full classname of implementations of the IInitializer class. Since WiQuery implements one WiQuery is able to do the same but then for wiquery.properties and implementations of the IWiQueryInitializer class respectively. Here is how you can implement your own IWiQueryInitializer:

  * Create a class like so:

```
package org.odlabs;

import org.apache.wicket.Application;
import org.odlabs.wiquery.core.IWiQueryInitializer;
import org.odlabs.wiquery.core.WiQuerySettings;

public class MyWiQueryInitializer implements IWiQueryInitializer
{
	private static final long serialVersionUID = 1L;

	public void init(Application application, WiQuerySettings wiQuerySettings)
	{
		//use WiQuerySettings.get() to get the singleton and alter settings.
	}
}

```

  * Create a file in src/main/resources called wiquery.properties and have it contain:

```
initializer: org.odlabs.MyWiQueryInitializer
```

  * if your logging system is set to allow INFO messages for org.apache.wicket and/or org.odlabs.wiquery you will see which Initializers were found. Here is an example output:

```
>>> STARTING EMBEDDED JETTY SERVER, PRESS ANY KEY TO STOP
INFO  - Server                     - jetty-7.5.0.v20110901
INFO  - tandardDescriptorProcessor - NO JSP Support for {}, did not find {}
INFO  - ContextHandler             - started {}
INFO  - WebXmlFile                 - web.xml: url mapping found for filter with name wicket.quickstart: [/*]
INFO  - Application                - [wicket.quickstart] init: org.odlabs.wiquery.core.WiQueryInitializer@5e6ffd79
INFO  - WiQueryInitializer         - [wicket.quickstart] init: org.odlabs.MyWiQueryInitializer@5374a6e2
INFO  - WiQueryInitializer         - [wicket.quickstart] init: org.odlabs.wiquery.core.WiQueryCoreInitializer@2d35da43
INFO  - WiQueryInitializer         - [wicket.quickstart] init: org.odlabs.wiquery.ui.listener.WiQueryUIInitializer@77a9f87c
INFO  - Application                - [wicket.quickstart] init: Wicket core library initializer
```

# Possible configurations #
  * addListener: you can a listener where you can define if we must import some javascripts / stylesheet for this kind of wiquery component.
  * setAutoImportJQueryResource: shall we automatically import the jQuery API ?
  * setAutoImportJQueryUIJavaScriptResource: shall we automatically import the jQuery UI JS ?
  * setAutoImportJQueryUIStyleSheetResource: shall we automatically import the jQuery UI CSS ?
  * setEnableWiqueryResourceManagement: If set to false, all resource contributions by Wiquery are disabled. No jQuery or jQueryUI resource are contributed by the framework, nor any resources from plugins. Useful if one wants to manage resources globally or use a CDN network to load resources.
  * setMinifiedJavaScriptResources(boolean): shall we use the minified versions of javascripts files, **note that this requires the minified files to be present on the classpath using predefined filename format, see WiQueryJavaScriptResourceReference**.
  * setMinifiedStyleSheetResources(boolean): shall we use the minified versions of stylesheets files, **note that this requires the minified files to be present on the classpath using predefined filename format, see WiQueryJavaScriptResourceReference**.
  * getResourceGroupingKeys(): gives the preset list of groupingkeys used to sort all resources added to the header. use .clear() to remove this sorting or use .add(...) to add your own key to the end of the list. see AbstractWiQueryDecoratingHeaderResponse.