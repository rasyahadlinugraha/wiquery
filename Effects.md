# What is that ? #

We can declare some jQuery effects in our JsStatement and JsQuery. You can use the predefined effect, like Hide, Show, Toggle ..., or you can declare your own with Effect.

You can too execute the effects with behaviors, like EffectBehavior and WiqueryAjaxEffectBehavior.

# How to use #

```
// Hide on load
WebMarkupContainer hideTextOnLoad = new WebMarkupContainer("hideTextOnLoad");
hideTextOnLoad.add(new EffectBehavior(new Hide()));
add(hideTextOnLoad);
```

```
// Show / Hide a text with the slide effect
WebMarkupContainer button = new WebMarkupContainer("myButton");	
button.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK) {
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 * @see org.odlabs.wiquery.core.events.Event#callback()
	 */
	@Override
	public JsScope callback() {
		return JsScope.quickScope(new JsStatement().$(null, "#myText").chain(new SlideToggle()).render());
	}
}));

add(button);
```