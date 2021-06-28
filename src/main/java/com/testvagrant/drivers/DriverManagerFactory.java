package com.testvagrant.drivers;

import java.io.File;
import java.io.IOException;

import com.testvagrant.drivers.ChromeDriverManager;
import com.testvagrant.drivers.DriverManager;
import com.testvagrant.drivers.DriverType;

public class DriverManagerFactory {
	public String path;
	public static DriverManager getDriverManager(DriverType drivertype, String appName) throws Exception{
		DriverManager drivermanager = null;
		switch(drivertype)
		{
		case FIREFOX:
			drivermanager = new FirefoxDriverManager(); 
			break;
			
		case CHROME:
			drivermanager = new ChromeDriverManager();
			break;
		default:
			break;
		}
		return drivermanager;
	}
}
