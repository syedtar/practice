package com.rest.utility;

import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RestLibrary {
	private static Map<String,Object> headersMap;
	public static Response getServiceResponse(String serviceURL) throws Exception {
		RequestSpecification request = RestAssured.given();
		request.headers(provideHeaders());
		Response response =  request.when().get(serviceURL);
		return response;
	}

	/**
	 * Provide the Header Values
	 * Content-type
	 * tenantID
	 * Authorization
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> provideHeaders( ) throws Exception{
		try{
			headersMap = new LinkedHashMap<String, Object>();
			//				headersMap.put("Content-type","application/json");
			//				headersMap.put("tenant","tenantID");
			//			 	headersMap.put("Authorization","tokenvalue");
			return headersMap;
		}catch(Exception e){

		}
		return headersMap;
	}
	public static String getSysProperty(String propName) {
		String propValue = System.getProperty(propName);
		return propValue != null ? propValue : null;
	}
	public static void setSysProperty(String propName, String propValue) {
		if (propValue != null) {
			System.setProperty(propName, propValue);
		} else {
			System.setProperty(propName, (String) null);
		}

	}
}