package com.testVagant.api_services;

public class TemperatureConverter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String convertKelvintoCelsius(String tempInKelvin) {
		String tempInCelsius = null;
		try {
		double kelvinTempFloat = Double.parseDouble(tempInKelvin);
		double celsiusTempFloat = kelvinTempFloat - 273.15;
		String tempCelSubstring = Double.toString(celsiusTempFloat);
		tempInCelsius = tempCelSubstring.substring(0, 5);
		}catch(Exception e) {}
		return tempInCelsius;
	}

}