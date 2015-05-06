# How to use #

See example here: http://wiquery-examples-1-1-x.appspot.com/?wicket:bookmarkablePage=:org.odlabs.wiquery.examples.resizable.ResizablePage

## XHTML ##

```
<div wicket:id="divContainer" style="border: 1px black solid; height: 150px; width: 150px">
	Div Container
</div>

```

## Java ##

```
WebMarkupContainer divContainer = new WebMarkupContainer("divContainer");
divContainer.add(new ResizableAjaxBehavior(){
	private static final long serialVersionUID = 1L;
	
	/**
	 * onResize is triggered at the end of a resize operation. 
	 * 
	 * @param height Height of the resized {@link Component}
	 * @param width Width of the resized {@link Component}
	 * @param ajaxRequestTarget the Ajax target
	 */
	public abstract void onResize(int height, int width, AjaxRequestTarget ajaxRequestTarget) {
		ajaxRequestTarget.appendJavascript("alert('width:" + width + "');");
	}
});
add(divContainer);

```

# Options #

See http://docs.jquery.com/UI/Resizable

TODO