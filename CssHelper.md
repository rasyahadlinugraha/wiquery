# What is that ? #

Utility class to bind on your JsStatement or JsQuery some CSS manipulation

# Methods #

  * css(Options options): affect all the css properties define into the Options
  * css(String name, String value)

# Examples #

```
// Change the body background color
button.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK) {
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 * @see org.odlabs.wiquery.core.events.Event#callback()
	 */
	@Override
	public JsScope callback() {
		return JsScope.quickScope(new JsStatement().$(null, "body").chain(CssHelper.css("background-color", "red")).render());
	}
}));
```