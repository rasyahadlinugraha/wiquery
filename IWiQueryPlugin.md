# What is that ? #

This interface is used to specify which behaviors and components must be managed with wiQuery. You will 1 method:

  * statement: this method is used to execute a portion of javascript when the component is inserted into the page

Where previously a contribute method had to be overridden, this is now done by overriding the renderHead(..) function of Component.

The jQuery API will be loaded.

# How to use #

This example is extract of the accordion component:

```
/*
 * (non-Javadoc)
 *
 * @see org.objetdirect.wickext.core.commons.JavaScriptCallable#statement()
 */
public JsStatement statement() {
	return new JsQuery(this).$().chain("accordion",
			options.getJavaScriptOptions());
}
```