# What is that ? #

JsScope is the representation of a javascript scope.

# How to use #

Basic uses
```
JsScope.quickScope("alert('a');").render(); // function(){ alert('a'); }

JsScope scope = new JsScope("event"){
	private static final long serialVersionUID = 1L;

	@Override
	protected void execute(JsScopeContext scopeContext){
		scopeContext.append("alert('b with event:' + event);");
	}
	}.render(); // function(event){ alert('b with event:' + event); }

	new JsScope(){
	private static final long serialVersionUID = 1L;

	@Override
	protected void execute(JsScopeContext scopeContext){
		scopeContext.self().chain("find", JsUtils.quotes("ul"));
	}
}.render(); // function(){ $(this).find('ul'); }

```

Declare your custom JsScope
```
public abstract class JsScopeEvent extends JsScope {
	private static final long serialVersionUID = 1L;

	public JsScopeEvent() {
		super("event");
	}

	public static JsScopeEvent quickScope(final CharSequence javascriptCode) {
		return new JsScopeEvent() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void execute(JsScopeContext scopeContext) {
				scopeContext.append(javascriptCode);
			}
			};
			}

			public static JsScopeEvent quickScope(final JsStatement jsStatement) {
			return new JsScopeEvent() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void execute(JsScopeContext scopeContext) {
				scopeContext.append(jsStatement == null ? "" : jsStatement.render());
			}
		};
	}
}
```