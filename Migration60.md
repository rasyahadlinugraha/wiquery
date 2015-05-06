# Migration to WiQuery 6.0.0 #

Migrating to WiQuery 6.0.0 has never been easier. Most of the core functionality from WiQuery 1.5 has been made superfluous because of the new resource management in Wicket 6.0.0. It is recommended you read [Wicket](https://cwiki.apache.org/WICKET/migration-to-wicket-60.html) migration guide so you understand what has been changed.

As said, all of the resource management can now be done by Wicket. Rendering resource references was changed to Wickets approach in WiQuery 1.5 you can follow the [Wicket](https://cwiki.apache.org/WICKET/migration-to-wicket-60.html) migration guide to see what you need to change in order to render resources.

The IWiQueryPlugin interface is now deprecated as users can now more easily render their statements in the Component#renderHead(..) function. This makes the interface rather useless. All code which you had in IWiQueryPlugin#statement() can be moved to the Component#renderHead(..) function.

Here is a shortlist with the major classes and why they have been changed/removed.

IWiQueryPlugin: deprecated, use Component#renderHead(..) for both resources and statements.
WiQuerySettings: removed, no longer needed as all core resource management can now be done using Wickets Settings classes.
WiQueryDecoratingHeaderResponse: removed, no longer needed as plugins no longer need to implement an interface and there is no longer any setting to take into account.
IWiQueryInitializer: removed, no longer needed as there is no WiQuerySettings.
CoreJavaScriptResourceReference: removed, no longer needed as Wicket now has a reference to jQuery.
WiQueryJavaScriptResourceReference: removed, no longer needed as Wicket now has incorporated this into its ResourceReference.
WiQueryStyleSheetResourceReference: removed, no longer needed as Wicket now has incorporated this into its ResourceReference.

WiQueryUtil: added more functions, to more easily allow users to migrate to Wicket 6.0.0.
JavaScriptHeaderItems: util to more easily define a list of HeaderItems.


Our footprint has decreased considerably, both in LOC and performance. There is no need for a WiQueryDecoratingHeaderResponse, which was our biggest footprint performance wise.

Here are 2 snippets which explains the biggest change in WiQuery and Wicket:

Rendering a plugin in WiQuery 1.5. Implement 2 functions, pass the resource to the response directly and return a JsStatement object when WiQuery asks for it to pass to Wicket at a later point.
```
@Override
public void renderHead(IHeaderResponse response)
{
	response.renderJavaScriptReference(AccordionJavaScriptResourceReference.get());
}
	public JsStatement statement()
{
	return new JsQuery(this).$().chain("accordion", options.getJavaScriptOptions());
}
```

Rendering a plugin in WiQuery 6.0.0. Implement 2 functions, pass the resource AND a statement to Wicket directly. Much easier right?
```
@Override
public void renderHead(IHeaderResponse response)
{
	response.render(JavaScriptHeaderItem.render(ReferenceAccordionJavaScriptResourceReference.get()));
	response.render(OnDomReadyHeaderItem.forScript(new JsQuery(this).$().chain("accordion", options.getJavaScriptOptions()).render()));
}
```

Defining a resourcereference in WiQuery 1.5, optionally define an array of resources on which this resource depends:
```
public class AccordionJavaScriptResourceReference extends WiQueryJavaScriptResourceReference
		implements ICoreUIJavaScriptResourceReference
{

...

	@Override
	public AbstractResourceDependentResourceReference[] getDependentResourceReferences()
	{
		AbstractResourceDependentResourceReference[] list =
			new AbstractResourceDependentResourceReference[2];
		list[0] = CoreUIJavaScriptResourceReference.get();
		list[1] = WidgetJavaScriptResourceReference.get();

		return list;
	}
}
```

Defining a resourcereference in WiQuery 6.0.0, optionally define an array of resources on which this resource depends. Use JavaScriptHeaderItems to more easily define a list of items.
```
public class AccordionJavaScriptResourceReference extends JavaScriptResourceReference
{

...

	@Override
	public Iterable< ? extends HeaderItem> getDependencies()
	{
		return JavaScriptHeaderItems.forReferences(CoreUIJavaScriptResourceReference.get(),
			WidgetJavaScriptResourceReference.get());
	}
}
```


If you are using a custom theme for JQuery UI you will notice that IThemeApplication does no longer does the trick. If you are planning to make one you will have to the following:
```

public class CustomApplication extends Application {

...

	@Override
	protected void init()
	{
		addResourceReplacement(WiQueryCoreThemeResourceReference.get(), new WiQueryCoreThemeResourceReference("custom"));
	}
}
```

and place your JQuery UI theme in a package in your project with the package name "org.odlabs.wiquery.ui.themes.custom". Where "custom" is the name of your theme.