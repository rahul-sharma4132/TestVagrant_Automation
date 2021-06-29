package com.testvagrant.drivers;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ChromeDriverManager extends DriverManager {
	
	@Override
	protected WebDriver createWebDriver() throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();	
		return driver;
	}
}
