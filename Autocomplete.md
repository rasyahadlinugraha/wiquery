# How to use #

See example here: http://wiquery-examples-1-1-x.appspot.com/?wicket:bookmarkablePage=:org.odlabs.wiquery.examples.autocomplete.AutocompletePage

## XHTML ##

```
<input type="text" wicket:id="autocomplete" />
```

## Java ##

```
ArrayItemOptions<LiteralOption> array = new ArrayItemOptions<LiteralOption>();
array.add(new LiteralOption("c++"));
array.add(new LiteralOption("java"));
array.add(new LiteralOption("php"));
array.add(new LiteralOption("coldfusion"));
array.add(new LiteralOption("javascript"));
array.add(new LiteralOption("asp"));
array.add(new LiteralOption("ruby"));
array.add(new LiteralOption("python"));
array.add(new LiteralOption("c"));
array.add(new LiteralOption("scala"));
array.add(new LiteralOption("groovy"));
array.add(new LiteralOption("haskell"));
array.add(new LiteralOption("perl"));

Autocomplete<String> autocomplete = new Autocomplete<String>("autocomplete");
autocomplete.setSource(new AutocompleteSource(array));
add(autocomplete);
```

# Options #

See http://docs.jquery.com/UI/Autocomplete

TODO