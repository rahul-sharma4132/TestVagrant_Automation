package com.testVagrant.Test;

import org.testng.annotations.Test;

import com.testvagrant.drivers.DriverManager;
import com.testvagrant.drivers.DriverManagerFactory;
import com.testvagrant.drivers.DriverType;
import com.testvagrant.fileReader.PropertyFileReader;
import com.testvagrant.ndtvPageObjects.NDTVHomePage;
import com.testvagrant.ndtvPageObjects.NDTVWeatherPage;
import com.testvagrant.openWeatherAPIReader.OpenWeatherAPIReader;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	public static DriverManager drivermanager;
	public static WebDriver driver;
	public static NDTVHomePage ndtvHomePage;
	public static NDTVWeatherPage ndtvWeatherPage;
	public static OpenWeatherAPIReader openWeatherAPIReader;
	
	@BeforeSuite
	public WebDriver driversetup() throws Exception {
		String browser = PropertyFileReader.getPropValue("config.properties", "browser");
		String applicationName = PropertyFileReader.getPropValue("config.properties", "applicationName");
		if(browser.equals("Chrome"))
		{
		drivermanager = DriverManagerFactory.getDriverManager(DriverType.CHROME, null);
		driver = drivermanager.getWebDriver(applicationName);
		}
		if(browser=="Firefox")
		{
		drivermanager = DriverManagerFactory.getDriverManager(DriverType.FIREFOX, null);
		driver = drivermanager.getWebDriver(applicationName);
		}
		ndtvHomePage = PageFactory.initElements(driver, NDTVHomePage.class);
		ndtvWeatherPage = PageFactory.initElements(driver, NDTVWeatherPage.class);
		return driver;
	}
	
	@BeforeSuite
	public void setup() {
		String apiName = PropertyFileReader.getPropValue("config.properties", "APIName");
		openWeatherAPIReader = new OpenWeatherAPIReader(apiName);
	}
	
	@AfterSuite
	public void tearDown() {
		drivermanager.quitDriver();
	}

}
