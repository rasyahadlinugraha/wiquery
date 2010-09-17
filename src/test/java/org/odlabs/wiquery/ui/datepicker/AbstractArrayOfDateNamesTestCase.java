package org.odlabs.wiquery.ui.datepicker;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AbstractArrayOfDateNamesTestCase extends TestCase{
	protected static final Logger log = LoggerFactory.getLogger(
			AbstractArrayOfDateNamesTestCase.class);

	@Test
	public void testGetJavaScriptOption() {
		DefaultArrayOfDateNames arrays = new DefaultArrayOfDateNames(
				"Dimanche", "Lundi", "Mardi");
		
		// Names param
		String expectedJavascript = "['Dimanche','Lundi','Mardi']";
		String generatedJavascript = arrays.getJavascriptOption().toString();
		
		log.info(expectedJavascript);
		log.info(generatedJavascript);		
		Assert.assertEquals(generatedJavascript, expectedJavascript);
		
		// Empty exception
		try{
			arrays = new DefaultArrayOfDateNames();
			arrays.getJavascriptOption().toString();
			Assert.assertTrue(false);
		}
		catch(Exception e){
			Assert.assertEquals(e.getMessage(), "We must have a list of names");
		}
		
		// Not the desired size exception
		try{
			arrays = new DefaultArrayOfDateNames("1", "2");
			arrays.getJavascriptOption().toString();
			Assert.assertTrue(false);
		}
		catch(Exception e){
			Assert.assertEquals(e.getMessage(), "The list must have 3 names");
		}
	}
	
	private class DefaultArrayOfDateNames extends AbstractArrayOfDateNames {
		// Constants
		/** Constant of serialization */
		private static final long serialVersionUID = -9097637272858071731L;
		
		public DefaultArrayOfDateNames(String... names) {
			super(names);
		}

		@Override
		public Integer getNumberOfName() {
			// TODO Auto-generated method stub
			return 3;
		}		
	}
}
