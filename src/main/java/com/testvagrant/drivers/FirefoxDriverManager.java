package com.testvagrant.drivers;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;

public class FirefoxDriverManager extends DriverManager {
	@Override
	protected WebDriver createWebDriver() {
		WebDriverManager.firefoxdriver().setup();
		driver.manage().window().maximize();
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
		WebDriver driver = new FirefoxDriver(options);
		return driver;
	}
}
