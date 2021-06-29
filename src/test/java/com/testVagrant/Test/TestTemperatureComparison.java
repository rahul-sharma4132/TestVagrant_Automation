package com.testVagrant.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testVagant.api_services.TemperatureComaprator;

public class TestTemperatureComparison extends BaseTest {
  
	@Test(priority=3)
	@Parameters({"city"})
	public static void verifyWeatherComparison(String city) {
		String temperatureFromNDTV = ndtvWeatherPage.getTemperatureforCity(city);
		String temperatureFromAPI = openWeatherAPIReader.getCityTemperatureResponseString();
		assertFalse(TemperatureComaprator.compareStrings(temperatureFromNDTV, temperatureFromAPI));
	}
	
}