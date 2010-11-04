/*
 * Copyright (c) 2009 WiQuery team
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
package org.odlabs.wiquery.ui.dialog.util;

import java.util.Locale;

import junit.framework.TestCase;

import org.odlabs.wiquery.ui.dialog.util.DialogUtilsBehavior.DialogUtilsLanguages;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test on {@link DialogUtilsLanguages}
 * @author Julien Roche
 *
 */
public class DialogUtilsLanguagesTestCase extends TestCase {
	/**
	 * Test on {@link DialogUtilsLanguages#getDialogUtilsLanguages(java.util.Locale)}
	 */
	@Test
	public void testGetDialogUtilsLanguages() {
		Assert.assertEquals(DialogUtilsLanguages.getDialogUtilsLanguages(null), 
				DialogUtilsLanguages.ENGLISH);
		
		Assert.assertEquals(DialogUtilsLanguages.getDialogUtilsLanguages(new Locale("af")), 
				DialogUtilsLanguages.ENGLISH);
		
		Assert.assertEquals(DialogUtilsLanguages.getDialogUtilsLanguages(new Locale("hi", "IN")), 
				DialogUtilsLanguages.HINDI);
	}
	
	/**
	 * Test on {@link DialogUtilsLanguages#getDialogUtilsLiteral(DialogUtilsLanguages)}
	 */
	@Test
	public void testGetDialogUtilsLiteral() {
		Assert.assertEquals(DialogUtilsLanguages.getDialogUtilsLiteral(DialogUtilsLanguages.ENGLISH), 
				"'en'");
		
		Assert.assertEquals(DialogUtilsLanguages.getDialogUtilsLiteral(DialogUtilsLanguages.HINDI), 
		"'hi_IN'");
	}
}
