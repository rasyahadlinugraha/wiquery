# How to use #

See example here: http://wiquery-examples-1-1-x.appspot.com/?wicket:bookmarkablePage=:org.odlabs.wiquery.examples.button.ButtonPage

## XHTML ##

```
<button wicket:id="firstButton">[A button element]</button>
<input value="A submit button" type="submit" wicket:id="secondButton" />
<a href="#" wicket:id="thirdButton">[An anchor]</a>

<wicket:container wicket:id="radioSet"></wicket:container>
<wicket:container wicket:id="checkSet"></wicket:container>
```

## Java ##

```
// Classic buttons
formButtons.add(new Button("firstButton").add(new ButtonBehavior().setLabel("A button element")));
formButtons.add(new Button("secondButton").add(new ButtonBehavior()));
formButtons.add(new Button("thirdButton").add(new ButtonBehavior().setLabel("An anchor")));

// Radio & check set
List<ButtonElement<String>> elements = new ArrayList<ButtonElement<String>>();
elements.add(new ButtonElement<String>(new Model<String>("button1"), new Model<String>("Button One")));
elements.add(new ButtonElement<String>(new Model<String>("button2"), new Model<String>("Button Two")));
elements.add(new ButtonElement<String>(new Model<String>("button3"), new Model<String>("Button Three")));

formButtons.add(new ButtonRadioSet<String>("radioSet", elements));
formButtons.add(new ButtonCheckSet<String>("checkSet", elements));
```

# Options #

See http://docs.jquery.com/UI/Button

TODO