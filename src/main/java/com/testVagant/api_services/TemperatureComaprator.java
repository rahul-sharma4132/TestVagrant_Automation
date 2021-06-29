package com.testVagant.api_services;

public class TemperatureComaprator {
	
	public static boolean compareStrings(String str1, String str2) {
		boolean status = false;
		if(str1==null||str2==null)
			return false;
		if(str1.equals(str2))
			status = true;
		return status;
		
	}
	
}
