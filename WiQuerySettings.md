# What is that ? #

You have the interface IWiQuerySettings and the class WiQuerySettings. The interface must be placed on your WebApplication definition. You will have a method where you will create a WiQuerySettings bean which will contains some configrations for wiQuery.

# How to use #

```
public class WicketApplication extends WebApplication implements IThemableApplication, IWiQuerySettings {
	// Constants
	private static final Logger LOGGER = LoggerFactory.getLogger(WicketApplication.class);
	
	/**
	 * Constructor
	 */
	public WicketApplication() {
		super();
	}
	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * {@inheritDoc}
	 * @see org.odlabs.wiquery.core.commons.IWiQuerySettings#getWiQuerySettings()
	 */
	public WiQuerySettings getWiQuerySettings() {
		WiQuerySettings settings = new WiQuerySettings();
		settings.setEnableResourcesMerging(true);
		
		return settings;
	}
}
```

# Possible configurations #
  * addListener: you can a listener where you can define if we must import some javascripts / stylesheet for this kind of wiquery component.
  * setAutoImportJQueryResource: shall we automatically import the jQuery API ?
  * setAutoImportJQueryUIResource: shall we automatically import the jQuery UI API ?
  * setEnableResourcesMerging : shall we merge the javascripts and stylesheets files ?
  * setEnableWiqueryResourceManagement: If set to false, all resource contributions by Wiquery are disabled. No jQuery or jQueryUI resource are contributed by the framework, nor any resources from plugins. Useful if one wants to manage resources globally or use a CDN network to load resources.
  * setEmbedGeneratedStatements: If set to false (default), the generated JavaScript statements will be loaded using a dynamic resource named xxxxxxxx-wiquery-gen.js
  * setJQueryCoreResourceReference: specify the resource for the jQuery API
  * setMinifiedResources: shall we minified javascripts and stylesheets files