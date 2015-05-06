# How to use #

See example here: http://wiquery-examples-1-1-x.appspot.com/?wicket:bookmarkablePage=:org.odlabs.wiquery.examples.draggable.DraggablePage

## XHTML ##

```
<div wicket:id="dragPanel" style="background-color: lightgrey; height: 50px; width: 75px;">
	Drag me !!
</div>

```

## Java ##

```
DraggableBehavior draggableBehavior = new DraggableBehavior();
draggableBehavior.setContainment(new 	DraggableContainment(ContainmentEnum.PARENT));
add(draggableBehavior);

```

# Options #

See http://docs.jquery.com/UI/Draggable

TODO