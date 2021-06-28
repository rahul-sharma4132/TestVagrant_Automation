package com.testvagrant.drivers;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;

public class FirefoxDriverManager extends DriverManager {
	@Override
	protected void createWebDriver() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
}
