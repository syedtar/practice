package com.rest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rest.base.APIBaseClass;
import com.rest.utility.RestLibrary;

import io.restassured.response.Response;

public class RestAssuredExamples extends APIBaseClass
{
 	private static Response responseBody = null;
  
	@Test(description="Fetch the Details of the Rest Service using GET Method",enabled=true) 
	public void verifyGetMethodDynamicUrl() 
	{
		try 
		{
			String url = pro.getProperty("getCusomters");
			System.out.println("Url stored in the Property file::" + url);
			responseBody =  RestLibrary.getServiceResponse(url);
			System.out.println(responseBody.prettyPrint());		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Retrieve information for Enterprises");
		}
	}
	@Test(description="Fetch the Details of the Rest Service using GET Method",enabled=false) 
	public void verifyGetMethodRunTimeValues() 
	{
		try 
		{
			String url = pro.getProperty("getParticularCustomer");
			System.out.println("Url stored in the Property file::" + url);
			url = url.replace("$CUSTOMERID", "1");
			System.out.println("Url updated with Customer ID::: "  + url);
			responseBody =  RestLibrary.getServiceResponse(url);
			System.out.println(responseBody.prettyPrint());

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Retrieve information for Enterprises");
		}
	}
	@Test(description="Retrieve All the Customers") 
	public void verifyGetAllCustomers() 
	{
		try 
		{
			responseBody =  RestLibrary.getServiceResponse("http://localhost:8080/sqlrest/CUSTOMER/");
			System.out.println(responseBody.prettyPrint());

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Retrieve information for Enterprises");
		}
	}
	@Test(description="Using the getProperty and setProperty" ) 
	public void verifyGetServiceUsingProperties() 
	{
		try 
		{
			String url = pro.getProperty("getCusomters");
			System.out.println("Url stored in the Configuration Properties::" + url);
			RestLibrary.setSysProperty("CUSTOMERID", "1");
			url =url+"/"+RestLibrary.getSysProperty("CUSTOMERID"); 
			System.out.println("Updated url using getSystemProperty Value"+ url);
			responseBody =  RestLibrary.getServiceResponse(url);
			System.out.println(responseBody.prettyPrint());
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Retrieve information for Enterprises");
		}
	}
}