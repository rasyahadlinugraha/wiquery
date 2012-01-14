/*
 * Copyright (c) 2008 Objet Direct
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.odlabs.wiquery.ui.button;

import org.odlabs.wiquery.core.commons.WiQueryJavaScriptResourceReference;

/**
 * $Id$
 * <p>
 * 	References the JavaScript resource to get the Button component.
 * </p>
 * @author Julien Roche
 * @since 1.1
 */
public class ButtonJavascriptResourceReference extends
		WiQueryJavaScriptResourceReference {
	private static final long serialVersionUID = -4771815414204892357L;
	
	/**
	 * Singleton instance.
	 */
	private static ButtonJavascriptResourceReference instance;

	/**
	 * Builds a new instance of {@link ButtonJavascriptResourceReference}.
	 */
	private ButtonJavascriptResourceReference() {
		super(ButtonJavascriptResourceReference.class, "jquery.ui.button.js");
	}

	/**
	 * Returns the {@link ButtonJavascriptResourceReference} instance.
	 */
	public static ButtonJavascriptResourceReference get() {
		if (instance == null)
			instance = new ButtonJavascriptResourceReference();
		return instance;
	}
}
