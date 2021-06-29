package com.testVagrant.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class APISuccessTest extends BaseTest {
	
	/*
	 * Test Case - Checking if the OpenWeather API are working fine
	 * 
	 * Steps :-
	 * Fetch the City and App ID from Base Test
	 * Pass the City and App ID as query parameters in the OpenWeather API
	 * Send an HTTP Get request
	 * Verify the status code of the response
	 * 
	 *  Expected Result - status code should be 200
	 */
  @Test
  public void verifyAPIStatus() {
	  assertTrue(openWeatherAPIReader.getResponseStatusCode(openWeatherAPIReader.getCityTempResponse(city, appID)));
  }
}
