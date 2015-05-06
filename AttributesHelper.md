# What is that ? #

Utility class to bind on your JsStatement or JsQuery some DOM attributes manipulation

# Methods #

  * attr(String key, String value): add an attribute on the element
  * attr(String key, JsScope computedValue): add an attribute on the element. The value is returned with the scope
  * removeAttr(String key): remove the attribute of the element
  * addClass(String className): add the CSS class
  * removeClass(String className): remove the CSS class
  * toggleClass(String className): add or remove the CSS class
  * html(CharSequence htmlContents): inject the html content into the element

# Examples #

```
// Add the title attribute on the button
button.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK) {
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 * @see org.odlabs.wiquery.core.events.Event#callback()
	 */
	@Override
	public JsScope callback() {
		return JsScope.quickScope(new JsQuery(button).$().chain(AttributesHelper.attr("title", "A title on my button")).render());
	}
}));
```