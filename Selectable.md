# How to use #

See example here: http://wiquery-examples-1-1-x.appspot.com/?wicket:bookmarkablePage=:org.odlabs.wiquery.examples.selectable.SelectablePage

## XHTML ##

```
<ol wicket:id="selectableWicket">
	<li wicket:id="listView"><span wicket:id="item"></span></li>
</ol>

<div id="selectedResult"></div>

```

## Java ##

```
List<String> values = Arrays.asList("Value 1", "Value 2", "Value 3", "Value 4", "Value 5");
ListView<String> listView = new ListView<String>("listView", values) {
private static final long serialVersionUID = 1L;

@Override
protected void populateItem(ListItem<String> item) {
	item.add(new Label("item", item.getModel()));
}
};

WebMarkupContainer selectableWicket = new WebMarkupContainer("selectableWicket");
selectableWicket.setMarkupId("selectableWicket");
selectableWicket.add(listView);

StringBuffer javascript = new StringBuffer();
javascript.append("var selected = new Array();");
javascript.append("jQuery.each($('#selectableWicket').children(\"*[class*='ui-selected']\")");
javascript.append(", function(){selected.push($(this).text());});");
javascript.append("$('#selectedResult').text(jQuery.unique(selected).toString());");

SelectableBehavior selectableBehavior = new SelectableBehavior();
selectableBehavior.setStopEvent(JsScopeUiEvent.quickScope(javascript.toString()));
selectableWicket.add(selectableBehavior);
add(selectableWicket);

```

# Options #

See http://docs.jquery.com/UI/selectable

TODO