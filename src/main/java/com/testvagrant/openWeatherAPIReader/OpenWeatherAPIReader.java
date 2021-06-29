package com.testvagrant.openWeatherAPIReader;

import org.json.JSONObject;

import com.testVagant.api_services.JSONExtractor;
import com.testVagant.api_services.TemperatureConverter;
import com.testvagrant.fileReader.PropertyFileReader;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OpenWeatherAPIReader {
	
	public static String APIName;
	
	public OpenWeatherAPIReader(String apiName) {
		this.APIName=apiName;
	}

	public static Response getCityTempResponse(String cityName, String appid) {
		RestAssured.baseURI = "http://api.openweathermap.org";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.queryParam("q", cityName).queryParam("appid", appid).get("data/2.5/weather");
		return response;
	}

	public static boolean getResponseStatusCode(Response response) {
		boolean status = false;
		try {
			int statusCode = JSONExtractor.getResponseStatusCode(response);
			if (statusCode == 200)
				status = true;
		} catch (Exception e) {
		}
		return status;
	}

	public String getCityTemperatureResponseString(String cityType) {
		String temperature = null;
		try {
			if(APIName.equals("OpenWeather")) {
				String cityName=null;
				if(cityType.equals("city1"))
					cityName = PropertyFileReader.getPropValue("openWeatherReader.properties", "city");
				if(cityType.equals("city2"))
					cityName = PropertyFileReader.getPropValue("openWeatherReader.properties", "newCity");
				String appID = PropertyFileReader.getPropValue("openWeatherReader.properties", "appid");
				Response response = getCityTempResponse(cityName,appID);
				boolean hitSuccess = getResponseStatusCode(response);
				if(hitSuccess) {
					String path = "main.temp";
					String tempString = JSONExtractor.getStringAtResponseNode(response, path);
					temperature = TemperatureConverter.convertKelvintoCelsius(tempString);
				}
			}
		}catch(Exception e) {}
		return temperature;
	}

}
