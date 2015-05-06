# What is that ? #

With this class, you can specify a wiQuery stylesheet ResourceReference (which contains the logic to minify the file if needed)

# How to use #

```
public class WijSplitterStyleSheetResourceReference extends WiQueryStyleSheetResourceReference {
	// Constants
	/** Constant of serialization */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Singleton instance.
	 */
	private static final WijSplitterStyleSheetResourceReference INSTANCE = new WijSplitterStyleSheetResourceReference();

	/**
	 * Default constructor
	 */
	private WijSplitterStyleSheetResourceReference() {
		super(WijSplitterStyleSheetResourceReference.class, "../theme/jquery.ui.wijsplitter.css");
	}

	/**
	 * Returns the {@link WijSplitterStyleSheetResourceReference} instance.
	 */
	public static WijSplitterStyleSheetResourceReference get() {
		return INSTANCE;
	}
}
```