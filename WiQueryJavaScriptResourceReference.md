# What is that ? #

With this class, you can specify a wiQuery javascript ResourceReference (which contains the logic to minify the file if needed)

# How to use #

```
public class AccordionJavaScriptResourceReference extends
		WiQueryJavaScriptResourceReference {
	private static final long serialVersionUID = -4771815414204892357L;
	
	/**
	 * Singleton instance.
	 */
	private static AccordionJavaScriptResourceReference instance = new AccordionJavaScriptResourceReference();;

	/**
	 * Builds a new instance of {@link AccordionJavaScriptResourceReference}.
	 */
	private AccordionJavaScriptResourceReference() {
		super(AccordionJavaScriptResourceReference.class, "jquery.ui.accordion.js");
	}

	/**
	 * Returns the {@link AccordionJavaScriptResourceReference} instance.
	 */
	public static AccordionJavaScriptResourceReference get() {
		return instance;
	}
}
```