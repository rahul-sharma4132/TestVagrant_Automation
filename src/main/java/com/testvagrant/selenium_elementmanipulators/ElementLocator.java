package com.testvagrant.selenium_elementmanipulators;

import org.openqa.selenium.WebElement;

public interface ElementLocator {
	
	public WebElement searchelement(String ElementLocator, String...cityName);
	
	public String getXpath(String propVal, String...cityName);

}
