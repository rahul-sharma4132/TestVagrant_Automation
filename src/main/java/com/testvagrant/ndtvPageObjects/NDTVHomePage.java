package com.testvagrant.ndtvPageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.testvagrant.fileReader.PropertyFileReader;

public class NDTVHomePage {
	
	public static WebDriver driver;
	public static NDTVElementManipulator ndtvElementManipulator;
	
	public NDTVHomePage(WebDriver driver) {
		this.driver = driver;
		ndtvElementManipulator = new NDTVElementManipulator(driver,"CommonItems.xml");
	}
	
	public boolean checkHomePage() {
		boolean status = false;
		String actualURL = driver.getCurrentUrl();
		String expectedURL = PropertyFileReader.getPropValue("NDTVWebsiteReader.properties", "url");
		if(expectedURL.equals(actualURL))
			status = true;
		return status;
	}
	
	public void navigateToWeatherPage() throws InterruptedException {
		Thread.sleep(500);
		ndtvElementManipulator.clickElement("TopMenuExpandButton");
		ndtvElementManipulator.clickElement("WeatherLink");
		Thread.sleep(500);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
	}

}
