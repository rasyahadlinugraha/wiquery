# What is that ? #

JsStatement can generate some jQuery code. You can specify a classic CSS selector and/or bind it on a Wicket component.

Note: if you bind on a component, be sure that this component called 'setOutputMarkupId(true)'

# Methods #

  * $(): Appends the jQuery's $ function to the current statement. So, we can call some special jquery fonction, like $.browser
  * $(Component context), $(Component context, String selector): Appends the jQuery's $ function to the current statement. Component will be use as the base of the context.
  * append(CharSequence charSequence): Append pur javascript code
  * chain(ChainableStatement chainableStatement), chain(CharSequence statementLabel, CharSequence... statementArgs): Chains a function call to this statement
  * document(): Appends $(document) to the statement.
  * each(JsScope scope): Appends the 'each' jQuery statement.
  * getStatement(): Return the StringBuilder of the statement
  * ready(JsScope scope): Appends the 'ready' jQuery statement.
  * render(), render(boolean semicolon): Renders this statement.
  * self(): Appends the 'this' keyword to this statement.

# How to use #

Basic uses
```
WebMarkupContainer aComponent = new WebMarkupContainer("aComponent");
aComponent.setOutputMarkupId(true);
aComponent.setMarkupId(aComponent.getId());

new JsStatement().$().chain("trim", JsUtils.quotes("  abc ")).render(); 
// $.trim(' abc ');
new JsStatement().$(aComponent).chain("find", JsUtils.quotes("ul")).render(false); 
// $('#aComponent').find('ul')
new JsStatement().$(aComponent, "ul").chain("find", JsUtils.quotes("li")).render(); 
// $('#aComponent ul').find('li');
new JsStatement().$(null, "ul").chain("find", JsUtils.quotes("li")).render(false); 
// $('ul').find('li')
new JsStatement().self().render(); 
// $(this);
new JsStatement().document().chain("ready", "function(){ alert('a'); }").render(); 
// $(document).ready(function(){ alert('a'); });

```