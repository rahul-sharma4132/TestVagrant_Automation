package com.testVagrant.Test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class NDTVHomePageTest extends BaseTest {
	
	/*
	 * Test Case - Checking if user lands on HomePage
	 * 
	 * Steps :-
	 * Load the webdriver with the URL in the Base Test
	 * Verify that the current page is NDTV HomePage
	 * 
	 *  Expected Result - Assertion should return true
	 */
	
	@Test
	public void checkNDTVHomePage() {
		assertTrue(ndtvHomePage.checkHomePage());
	}
	
}
