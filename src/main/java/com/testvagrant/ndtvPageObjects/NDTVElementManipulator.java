package com.testvagrant.ndtvPageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testvagrant.fileReader.PropertyFileReader;
import com.testvagrant.fileReader.XMLFileReader;
import com.testvagrant.selenium_elementmanipulators.ElementFeeders;
import com.testvagrant.selenium_elementmanipulators.ElementLocator;

public class NDTVElementManipulator implements ElementFeeders, ElementLocator {

	public static WebDriver driver;
	
	public static String pageObject;

	public NDTVElementManipulator(WebDriver driver, String pageObject) {
		this.driver = driver;
		this.pageObject = pageObject;
		
	}

	@Override
	public String getXpath(String propVal, String... replacementValue) {
		// TODO Auto-generated method stub
		String xpath = null;
		try {
			xpath = XMLFileReader.readXMLReader(propVal, pageObject);
			if (xpath.contains("#")) {
				xpath = xpath.replace("#", replacementValue[0]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return xpath;
		}
	}

	@Override
	public WebElement searchelement(String elementLocator, String... replacementValue) {
		WebElement element = null;
		String xpath = null;
		try {
			xpath = getXpath(elementLocator, replacementValue);
			driver.manage().timeouts().implicitlyWait(250, TimeUnit.MILLISECONDS);
			element = driver.findElement(By.xpath(xpath));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return element;
		}
	}

	public String getElementPropertyValue(String filename, String propertyname) {
		// TODO Auto-generated method stub
		String propertyName = null;
		try {
			PropertyFileReader psr = new PropertyFileReader();
			propertyName = psr.getPropValue(filename, propertyname);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return propertyName;
		}
	}

	public void clickElement(String elementName,String...elementText) {
		try {
			Thread.sleep(500);
			driver.manage().timeouts().implicitlyWait(250, TimeUnit.MILLISECONDS);
			WebElement elementToClick = searchelement(elementName,elementText);
			elementToClick.click();
			Thread.sleep(500);
			driver.manage().timeouts().implicitlyWait(250, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
		}
	}

	public void writeIntoElement(String elementName, String value,String...elementText) {
		try {
			Thread.sleep(500);
			driver.manage().timeouts().implicitlyWait(250, TimeUnit.MILLISECONDS);
			WebElement elementToClick = searchelement(elementName,elementText);
			elementToClick.sendKeys(value);
			Thread.sleep(500);
			driver.manage().timeouts().implicitlyWait(250, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
		}
	}
	
}
