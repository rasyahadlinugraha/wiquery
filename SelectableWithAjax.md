# How to use #

See example here: http://wiquery-examples-1-1-x.appspot.com/?wicket:bookmarkablePage=:org.odlabs.wiquery.examples.selectable.SelectablePage

## XHTML ##

```
<ol wicket:id="selectableAjaxWicket">
	<li wicket:id="listAjaxView"><span wicket:id="itemAjax"></span></li>
</ol>

<div id="ajaxSelectedResult"></div>

```

## Java ##

```
List<String> values = Arrays.asList("Value 1", "Value 2", "Value 3", "Value 4", "Value 5");
ListView<String> listAjaxView = new ListView<String>("listAjaxView", values) {
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

final Label ajaxSelectedResult = new Label("ajaxSelectedResult", new Model<String>());
ajaxSelectedResult.setOutputMarkupId(true);
ajaxSelectedResult.setVersioned(false); // GAE fix. Otherwise java.security.AccessControlException: access denied (java.io.SerializablePermission enableSubstitution)
add(ajaxSelectedResult);

WebMarkupContainer selectableAjaxWicket = new WebMarkupContainer("selectableAjaxWicket");
selectableAjaxWicket.setMarkupId("selectableAjaxWicket");
selectableAjaxWicket.add(new SelectableAjaxBehavior(){
	private static final long serialVersionUID = 1L;
	
	/* (non-Javadoc)
	 * @see org.odlabs.wiquery.ui.selectable.SelectableAjaxBehavior#onSelection(org.apache.wicket.Component[], org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	@Override
	public void onSelection(Component[] components,
			AjaxRequestTarget ajaxRequestTarget) {
		StringBuffer buffer = new StringBuffer();
		for(Component c : components){
			buffer.append("[");
			buffer.append(c.getDefaultModelObject().toString());
			buffer.append("]");
		}
		
		ajaxSelectedResult.setDefaultModelObject(buffer.toString());
		ajaxRequestTarget.addComponent(ajaxSelectedResult);
	}
	
});
selectableAjaxWicket.add(listAjaxView);
add(selectableAjaxWicket);

```

# Options #

See http://docs.jquery.com/UI/selectable

TODO