package com.testVagant.api_services;

public class TemperatureComaprator {
	
	public static boolean compareSimpleTempStrings(String str1, String str2) {
		boolean status = false;
		if(str1==null||str2==null)
			return false;
		if(str1.equals(str2))
			status = true;
		return status;
		
	}
	
	public static boolean compareVarianceTempStrings(String str1, String str2, String variance) {
		boolean status = false;
		if(str1==null||str2==null)
			return false;
		if(str1.equals(str2))
			status = true;
		int tempInt1 = Integer.parseInt(str1);
		int tempInt2 = Integer.parseInt(str2);
		int tempDiff = tempInt1 - tempInt2;
		if(tempDiff<2||tempDiff>-2)
			status=true;
		return status;
		
	}
	
}
