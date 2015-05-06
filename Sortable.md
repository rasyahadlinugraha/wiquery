# How to use #

See example here: http://wiquery-examples-1-1-x.appspot.com/?wicket:bookmarkablePage=:org.odlabs.wiquery.examples.sortable.SortablePage

## XHTML ##

```
<ul wicket:id="sortableWicket" class="connectedSortable">
	<li wicket:id="listView"><span wicket:id="item"></span></li>
</ul>

```

## Java ##

```
List<String> values1 = Arrays.asList("Sort 1 - Value 1", "Sort 1 - Value 2","Sort 1 - Value 3","Sort 1 - Value 4","Sort 1 - Value 5");
ListView<String> listView = new ListView<String>("listView", values1) {
 private static final long serialVersionUID = 1L;

 @Override
 protected void populateItem(ListItem<String> item) {
 item.add(new Label("item", item.getModel()));
 item.setOutputMarkupId(true);
 }
 };

 WebMarkupContainer sortableWicket = new WebMarkupContainer("sortableWicket");
 SortableBehavior sortableBehavior = new SortableBehavior();
 sortableBehavior.setConnectWith(".connectedSortable");
 sortableWicket.add(sortableBehavior);
 sortableWicket.add(listView);
 add(sortableWicket);

```

# Options #

See http://docs.jquery.com/UI/Sortable

TODO