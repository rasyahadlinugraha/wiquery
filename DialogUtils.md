# Goal #

Offers some utilities methods for the dialog. For example, create a simple dialog, an alert dialog ....

# How to use #

See example here: http://wiquery-examples-1-1-x.appspot.com/wicket:bookmarkablePage=:org.odlabs.wiquery.examples.dialog.util.DialogUtilsPage

## XHTML ##

```
<button wicket:id="simpleDialog">Simple dialog</button>
<button wicket:id="errorDialog">Error dialog</button>
```

## Java ##

```
WebMarkupContainer simpleDialog = new WebMarkupContainer("simpleDialog");
simpleDialog.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK) {
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 * @see org.odlabs.wiquery.core.events.Event#callback()
	 */
	@Override
	public JsScope callback() {
		return JsScope.quickScope(dialogUtilsBehavior.simpleDialog("A title", "My message"));
	}
}));
add(simpleDialog);

WebMarkupContainer errorDialog = new WebMarkupContainer("errorDialog");
errorDialog.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK) {
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 * @see org.odlabs.wiquery.core.events.Event#callback()
	 */
	@Override
	public JsScope callback() {
		return JsScope.quickScope(dialogUtilsBehavior.errorDialog("An error message"));
	}
}));
add(errorDialog);
```