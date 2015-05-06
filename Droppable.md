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
dropZone.add(new DroppableBehavior());
add(dropZone);

```

# Options #

See http://docs.jquery.com/UI/Droppable

TODO