# How to use #

See example here: http://wiquery-examples-1-1-x.appspot.com/?wicket:bookmarkablePage=:org.odlabs.wiquery.examples.sortable.SortablePage

## XHTML ##

```
<ul wicket:id="sortableAjaxWicket" class="connectedSortable">
	<li wicket:id="listAjaxView"><span wicket:id="itemAjax"></span></li>
</ul>

```

## Java ##

```
List<String> values1 = Arrays.asList("Sort 1 - Value 1", "Sort 1 - Value 2","Sort 1 - Value 3","Sort 1 - Value 4","Sort 1 - Value 5");
ListView<String> listAjaxView = new ListView<String>("listAjaxView", values2) {
	private static final long serialVersionUID = 1L;
	
	/* (non-Javadoc)
	 * @see org.apache.wicket.markup.html.list.ListView#populateItem(org.apache.wicket.markup.html.list.ListItem)
	 */
	@Override
	protected void populateItem(ListItem<String> item) {
		item.add(new Label("itemAjax", item.getModel()));
		item.setOutputMarkupId(true);
	}
};

WebMarkupContainer sortableAjaxWicket = new WebMarkupContainer("sortableAjaxWicket");
SortableAjaxBehavior<Component> sortableAjaxBehavior = new SortableAjaxBehavior<Component> () {
	private static final long serialVersionUID = 1L;
	
	/* (non-Javadoc)
	 * @see org.odlabs.wiquery.ui.sortable.SortableAjaxBehavior#onReceive(org.apache.wicket.Component, int, org.apache.wicket.Component, org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	@Override
	public void onReceive(Component sortedComponent, int index, 
			Component parentSortedComponent,
			AjaxRequestTarget ajaxRequestTarget) {
		ajaxRequestTarget.appendJavascript("alert('received  : " 
				+ sortedComponent.getMarkupId() +" - " 
				+ sortedComponent.getDefaultModelObject().toString()  
				+" - index : " + index + "')");
		ajaxRequestTarget.appendJavascript("alert('received from  : " 
				+ parentSortedComponent.getMarkupId() 
				+ "')");
	}

	/* (non-Javadoc)
	 * @see org.odlabs.wiquery.ui.sortable.SortableAjaxBehavior#onUpdate(org.apache.wicket.Component, int, org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	@Override
	public void onUpdate(Component sortedComponent, int index,
			AjaxRequestTarget ajaxRequestTarget) {
		ajaxRequestTarget.appendJavascript("alert('updated  : " 
				+ sortedComponent.getMarkupId() +" - " 
				+ sortedComponent.getDefaultModelObject().toString()
				+" - index : " + index + "')");
	}

	/* (non-Javadoc)
	 * @see org.odlabs.wiquery.ui.sortable.SortableAjaxBehavior#onRemove(org.apache.wicket.Component, org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	@Override
	public void onRemove(Component sortedComponent,
			AjaxRequestTarget ajaxRequestTarget) {
		ajaxRequestTarget.appendJavascript("alert('removed  : " 
				+ sortedComponent.getMarkupId() 
				+" - " 
				+ sortedComponent.getDefaultModelObject().toString()  
				+"')");
	}
};
sortableAjaxBehavior.getSortableBehavior().setConnectWith(".connectedSortable");
sortableAjaxWicket.add(sortableAjaxBehavior);
sortableAjaxWicket.add(listAjaxView);
add(sortableAjaxWicket);

```

# Options #

See http://docs.jquery.com/UI/Sortable

TODO