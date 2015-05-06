# How to use #

See example here: http://wiquery-examples-1-1-x.appspot.com/?wicket:bookmarkablePage=:org.odlabs.wiquery.examples.droppable.DroppablePage

## XHTML ##

```
<div wicket:id="dropZone" style="width: 50px; height: 50px; border: 1px solid black;">

</div> 

```

## Java ##

```
WebMarkupContainer dropZone = new WebMarkupContainer("dropZone");
dropZone.add(new DroppableAjaxBehavior<ListItem<Fruit>>() {
	private static final long serialVersionUID = 1L;
	
	/* (non-Javadoc)
	 * @see org.odlabs.wiquery.ui.droppable.DroppableAjaxBehavior#onDrop(org.apache.wicket.Component, org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	@Override
	public void onDrop(ListItem<Fruit> droppedComponent,
			AjaxRequestTarget ajaxRequestTarget) {
		
		if(droppedComponent != null){
			Fruit fruit = droppedComponent.getModelObject();
			Integer nb = 1;
			if(selection.containsKey(fruit.getName())){
				nb = selection.get(fruit.getName()) + 1;
			}
			selection.put(fruit.getName(), nb);
			
			StringBuffer buffer = new StringBuffer();
			buffer.append("<ul>");
			for(String key : selection.keySet()){
				buffer.append("<li>");
				buffer.append(selection.get(key));
				buffer.append(" " + key + "(s)");
				buffer.append("</li>");
			}
			buffer.append("</ul>");
			selectionLabel.setDefaultModelObject(buffer.toString());
			ajaxRequestTarget.addComponent(selectionLabel);
		}				
	}
});
add(dropZone);

```

# Options #

See http://docs.jquery.com/UI/Droppable

TODO