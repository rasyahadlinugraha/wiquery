# What is that ? #

JsQuery is like the JsStatement, but it's strongly linked to a Wicket component.

# Methods #

  * $(), $(tring selector): Appends the jQuery's $ function to the current statement. The component will be use as the base of the context.
  * append(CharSequence charSequence): Append pur javascript code
  * document(): Appends $(document) to the statement.
  * getStatement(): Return the JsStatement associated of the JsQuery

# How to use #

Basic uses
```
WebMarkupContainer aComponent = new WebMarkupContainer("aComponent");
aComponent.setOutputMarkupId(true);
aComponent.setMarkupId(aComponent.getId());

new JsQuery(aComponent).$().chain("find", JsUtils.quotes("ul")).render(false); 
// $('#aComponent').find('ul')
new JsQuery(aComponent).$("ul").chain("find", JsUtils.quotes("li")).render(); 
// $('#aComponent ul').find('li');
```