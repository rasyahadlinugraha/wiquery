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
divContainer.add(new ResizableBehavior());
add(divContainer);

```

# Options #

See http://docs.jquery.com/UI/Resizable

TODO