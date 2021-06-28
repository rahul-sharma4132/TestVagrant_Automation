package com.testVagant.api_services;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JSONExtractor {
	
	public static int getResponseStatusCode(Response response) {
		return response.getStatusCode();
	}
	
	public static JsonPath getResponseJSONPath(Response response) {
		JsonPath responseJsonPath = null;
		try {
			responseJsonPath = response.jsonPath();
		}catch(Exception e) {}
		return responseJsonPath;
	}
	
	public static String getStringAtResponseNode(Response response, String path) {
		String responseString = null;
		try {
			if(getResponseStatusCode(response)==200)
				responseString = getResponseJSONPath(response).getString(path);
			String x = "abc";
		}catch(Exception e) {}
		return responseString;
	}
	
}