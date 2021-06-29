package com.testvagrant.ndtvPageObjects;

import org.openqa.selenium.WebDriver;

import com.testvagrant.fileReader.PropertyFileReader;

public class NDTVWeatherPage {

	public static WebDriver driver;
	public static NDTVElementManipulator ndtvElementManipulator;

	public NDTVWeatherPage(WebDriver driver) {
		this.driver = driver;
		ndtvElementManipulator = new NDTVElementManipulator(driver, "CommonItems.xml");
	}

	public static void handleAllowPopUp() {

		if (ndtvElementManipulator.searchelement("NotNowPopUp") != null) {
			ndtvElementManipulator.searchelement("NotNowPopUp").click();
		}
	}

	public static boolean checkWeatherPage() {
		boolean status = false;
		handleAllowPopUp();
		String actual_Title = "NDTV Weather";
		String expected_Title = PropertyFileReader.getPropValue("NDTVWebsiteReader.properties", "weatherPageTitle");
		if (expected_Title.contains(actual_Title))
			status = true;
		return status;
	}

	public void searchForSpecificCity(String city) {

		ndtvElementManipulator.writeIntoElement("CitySearch", city);
		ndtvElementManipulator.searchelement("CitySelect", city);

	}

	public static String getTemperatureforCity(String city) {

		String tempText = null;
		try {
			String cityName = PropertyFileReader.getPropValue("NDTVWebsiteReader.properties", city);
			if (ndtvElementManipulator.searchelement("CitySelect", cityName) != null) {
				tempText = ndtvElementManipulator.searchelement("TemperatureofCity", cityName).getText();
				tempText = tempText.substring(0, 2);
			}
		} catch (Exception e) {
		}
		return tempText;

	}

}
