# What is that ? #

wiQuery offers the possiblity to bind standard and custom javascript event. To declare a type of event, you have to create an object that implements the interface "EventLabel".
For all events binding by wiQuery, we use some enumerations.

After that, you can use WiQueryEventBehavior or WiQueryAjaxEventBehavior to declare a javascript event and to execute what you want

# How to use #

Example of to create events (extract from MouseEvent)

```
public enum MouseEvent implements EventLabel {

	CLICK, DBLCLICK, MOUSEDOWN, MOUSEENTER, MOUSELEAVE, MOUSEMOVE, MOUSEOUT, MOUSEOVER, MOUSEUP, SCROLL;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.odlabs.wiquery.core.events.EventLabel#getEventLabel()
	 */
	public String getEventLabel() {
		return this.name().toLowerCase();
	}

}
```

Examples to declare events:

```
clickButton.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK) {
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 * @see org.odlabs.wiquery.core.events.Event#callback()
	 */
	@Override
	public JsScope callback() {
		return JsScope.quickScope("alert('click done');");
	}
}));

ajaxClickButton.add(new WiQueryAjaxEventBehavior(MouseEvent.CLICK) {
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 * @see org.odlabs.wiquery.core.events.WiQueryAjaxEventBehavior#onEvent(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	@Override
	protected void onEvent(AjaxRequestTarget target) {
		target.appendJavascript("alert('ajax click done');");
	}
});
```