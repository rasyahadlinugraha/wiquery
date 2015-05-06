# How to use #

See example here: http://wiquery-examples-1-1-x.appspot.com/?wicket:bookmarkablePage=:org.odlabs.wiquery.examples.autocomplete.AutocompletePage

## XHTML ##

```
<div wicket:id="autocompleteAjaxComponent"></div>
```

## Java ##

```
ArrayItemOptions<LiteralOption> languages = new ArrayItemOptions<LiteralOption>();
languages.add(new LiteralOption("c++"));
languages.add(new LiteralOption("java"));
languages.add(new LiteralOption("php"));
languages.add(new LiteralOption("coldfusion"));
languages.add(new LiteralOption("javascript"));
languages.add(new LiteralOption("asp"));
languages.add(new LiteralOption("ruby"));
languages.add(new LiteralOption("python"));
languages.add(new LiteralOption("c"));
languages.add(new LiteralOption("scala"));
languages.add(new LiteralOption("groovy"));
languages.add(new LiteralOption("haskell"));
languages.add(new LiteralOption("perl"));

AutocompleteAjaxComponent<String> autocompleteAjaxComponent  = new AutocompleteAjaxComponent<String>("autocompleteAjaxComponent", new Model<String>()) {
			private static final long serialVersionUID = 1L;

			/**
			 * {@inheritDoc}
			 * @see org.odlabs.wiquery.ui.autocomplete.AutocompleteAjaxComponent#getValues(java.lang.String)
			 */
			@Override
			public List<String> getValues(String term) {
				ArrayList<String> values = new ArrayList<String>();
				for(String l : languages){
					if(l.contains(term)){
						values.add(l);
					}
				}
				return values;
			}
			
			/**
			 * {@inheritDoc}
			 * @see org.odlabs.wiquery.ui.autocomplete.AutocompleteAjaxComponent#getValueOnSearchFail(java.lang.String)
			 */
			@Override
			public String getValueOnSearchFail(String input) {
				return input;
			}
		};
add(autocompleteAjaxComponent);
```

# Options #

See http://docs.jquery.com/UI/Autocomplete

TODO