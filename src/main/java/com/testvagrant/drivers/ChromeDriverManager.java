package com.testvagrant.drivers;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ChromeDriverManager extends DriverManager {
	
	@Override
	protected void createWebDriver() throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		DriverManager.driver = new ChromeDriver();
		driver.manage().window().maximize();	
	}
}
