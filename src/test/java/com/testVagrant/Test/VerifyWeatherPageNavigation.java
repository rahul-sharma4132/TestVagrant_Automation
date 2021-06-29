package com.testVagrant.Test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.testvagrant.ndtvPageObjects.NDTVWeatherPage;

public class VerifyWeatherPageNavigation extends BaseTest {
	
	
	/*
	 * Test Case - Checking if user lands on Weather Page
	 * 
	 * Steps :-
	 * Load the webdriver with the URL in the Base Test
	 * Navigate to Weather Page
	 * Verify that the current page is NDTV Weather Page
	 * 
	 *  Expected Result - Assertion should return true
	 */
	
	@Test
	public static void verifyWeatherPage() throws InterruptedException {
		ndtvHomePage.navigateToWeatherPage();
		assertTrue(NDTVWeatherPage.checkWeatherPage());
	}
	
}
