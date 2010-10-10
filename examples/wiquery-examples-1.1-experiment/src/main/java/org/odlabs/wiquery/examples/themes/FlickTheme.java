package org.odlabs.wiquery.examples.themes;

import org.apache.wicket.ResourceReference;
import org.odlabs.wiquery.ui.themes.WiQueryCoreThemeResourceReference;

/**
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
 *
 */
public class FlickTheme extends UITheme {

	private static final long serialVersionUID = 1L;
	
	public static final ResourceReference THEME = new WiQueryCoreThemeResourceReference("flick");
	
	private static FlickTheme instance;
	
	
	/**
	 * @param name
	 */
	private FlickTheme() {
		super("Flick");
	}

	/* (non-Javadoc)
	 * @see es.liberty.fwkdemo.web.jquery.themes.UITheme#getTheme()
	 */
	@Override
	public ResourceReference getTheme() {
		return THEME;
	}

	public static FlickTheme getInstance() {
		if(instance==null) {
			instance = new FlickTheme();
		}
		return instance;
	}

}