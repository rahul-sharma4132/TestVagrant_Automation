package com.testVagrant.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testVagant.api_services.TemperatureComaprator;

public class TestTemperatureComparison extends BaseTest {
  
	/*
	 * Test Case - Checking if temperatures from NDTV Weather Page and OpenWeather API are equal
	 * 
	 * Steps :-
	 * Load the webdriver with the URL in the Base Test
	 * Navigate to Weather Page
	 * Get the degrees celsius temperature text for New Delhi from the Weather Page
	 * Get the temperature(in Kelvin) of Delhi from OpenWeather API and convert degree Celsius
	 * Compare the 2 temperatures
	 * 
	 * Expected Result - The temperatures should be equal
	 */
	@Test
	@Parameters({"city"})
	public static void verifyWeatherComparison(String city) throws InterruptedException {
		ndtvHomePage.navigateToWeatherPage();
		String temperatureFromNDTV = ndtvWeatherPage.getTemperatureforCity(city);
		String temperatureFromAPI = openWeatherAPIReader.getCityTemperatureResponseString(city);
		assertTrue(TemperatureComaprator.compareSimpleTempStrings(temperatureFromNDTV, temperatureFromAPI));
	}
	
	
	/*
	 * Test Case - Checking if temperatures from NDTV Weather Page and OpenWeather API, of a user selected city, have a difference within the user defined variance
	 * 
	 * Steps :-
	 * Load the webdriver with the URL in the Base Test
	 * Navigate to Weather Page
	 * Select a city to pin to the main display. For example :- Ahmedabad
	 * Get the degrees celsius temperature text for Ahmedabad from the Weather Page
	 * Get the temperature(in Kelvin) of Ahmedabad from OpenWeather API and convert degree Celsius
	 * Compare the 2 temperatures with a user defined (in this case, variance = 2)
	 * 
	 * Expected Result - If the temperature difference is within the variance, the Assertion should return true
	 */
	@Test
	@Parameters({"citySelected","variance"})
	public static void verifyWeatherComparisonWithVariance(String citySelected, String variance) throws InterruptedException {
		ndtvHomePage.navigateToWeatherPage();
		String temperatureFromNDTV = ndtvWeatherPage.getTemperatureforSelectedCity(citySelected);
		String temperatureFromAPI = openWeatherAPIReader.getCityTemperatureResponseString(citySelected);
		assertFalse(TemperatureComaprator.compareVarianceTempStrings(temperatureFromNDTV, temperatureFromAPI, variance));
	}
	
}