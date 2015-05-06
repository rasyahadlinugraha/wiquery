# What is that ? #

Utility class to bind on your JsStatement or JsQuery some DOM manipulation

# Methods #

  * after(CharSequence html): insert content, specified by the parameter, after each element in the set of matched elements.
  * insertAfter(String expression): insert every element in the set of matched elements after the target.
  * before(CharSequence html): insert content, specified by the parameter, before each element in the set of matched elements.
  * insertBefore(String expression): insert every element in the set of matched elements before the target.

# Examples #

```
// Add some text after the button
button.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK) {
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 * @see org.odlabs.wiquery.core.events.Event#callback()
	 */
	@Override
	public JsScope callback() {
		return JsScope.quickScope(new JsQuery(button).$().chain(ManipulatingHelper.after("<p>Test</p>")).render());
	}
}));
```