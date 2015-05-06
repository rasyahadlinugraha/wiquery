# How to use #

See example here: http://wiquery-examples-1-1-x.appspot.com/?wicket:bookmarkablePage=:org.odlabs.wiquery.examples.draggable.DraggablePage

## XHTML ##

```
<div wicket:id="dragAjaxPanel" style="background-color: lightgreen; height: 50px; width: 75px;">
Drag me with Ajax !!
</div>

```

## Java ##

```
DraggableAjaxBehavior draggableAjaxBehavior = new DraggableAjaxBehavior(DraggableEvent.STOP) {
	private static final long serialVersionUID = 1L;
	
	/* (non-Javadoc)
	 * @see org.odlabs.wiquery.ui.draggable.DraggableAjaxBehavior#onDrag(org.apache.wicket.Component, org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	@Override
	public void onDrag(Component component, AjaxRequestTarget ajaxRequestTarget) {
		// Nothing
	}

	/* (non-Javadoc)
	 * @see org.odlabs.wiquery.ui.draggable.DraggableAjaxBehavior#onStart(org.apache.wicket.Component, org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	@Override
	public void onStart(Component component, AjaxRequestTarget ajaxRequestTarget) {
		// Nothing
	}

	/* (non-Javadoc)
	 * @see org.odlabs.wiquery.ui.draggable.DraggableAjaxBehavior#onStop(org.apache.wicket.Component, org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	@Override
	public void onStop(Component draggedComponent,
			AjaxRequestTarget ajaxRequestTarget) {
		ajaxRequestTarget.appendJavascript("alert('drag stop');");
	}

	/* (non-Javadoc)
	 * @see org.odlabs.wiquery.ui.draggable.DraggableAjaxBehavior#onInvalid(org.apache.wicket.Component, org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void onInvalid(Component component,
			AjaxRequestTarget ajaxRequestTarget) {
		ajaxRequestTarget.appendJavascript("alert('drag invalid');");
	}

	/* (non-Javadoc)
	 * @see org.odlabs.wiquery.ui.draggable.DraggableAjaxBehavior#onValid(org.apache.wicket.Component, org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void onValid(Component component,
			AjaxRequestTarget ajaxRequestTarget) {
		ajaxRequestTarget.appendJavascript("alert('drag valid');");
	}
};
draggableAjaxBehavior.getDraggableBehavior().setContainment(
		new DraggableContainment("'#ajaxContainer'"));

```

# Options #

See http://docs.jquery.com/UI/Draggable

TODO