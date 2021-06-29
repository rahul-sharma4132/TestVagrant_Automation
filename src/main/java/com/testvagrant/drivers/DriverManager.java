package com.testvagrant.drivers;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.testvagrant.fileReader.PropertyFileReader;

public abstract class DriverManager {
	protected static WebDriver driver;
	private static String path;

	protected abstract WebDriver createWebDriver() throws Exception;

	public void quitDriver() {
		if (null != driver) {
			driver.quit();
			driver = null;
		}
	}

	public WebDriver getWebDriver(String ApplicationName) throws Exception {
		if (null == driver) {
			driver = createWebDriver();
			if (ApplicationName.contains("NDTV")) {
				String url = PropertyFileReader.getPropValue("NDTVWebsiteReader.properties", "url");
				driver.get(url);
			}
		}
		return driver;
	}
}
