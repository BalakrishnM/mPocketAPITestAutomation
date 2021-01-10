package com.mPocketAPITest.tests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mPocketAPITest.common.BaseClass;
import com.mPocketAPITest.common.RequestLoader;
import com.nPocketAPITest.utilities.ReplaceParameters;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TC002_GetEmployeeByID {
	

	private static String extension;
	private Response response = null;
	
	//This test is to prepare the request
	@Parameters({"REQUESTEXT", "REQUESTEXT" })
	@Test(priority = 1)
	public void getRequestDetails(String payLoad, String ext) {

		RestAssured.baseURI = BaseClass.endpoint;

		extension = RequestLoader.LoadTheRequest(ext);
			
		extension =extension +"/"+ TC001_CreateRecord.Id;
		
		System.out.println("Ready extension: "+ extension);

	}
	
	// This test is hit the request and validate the response
	@Test(priority = 2)
	public void hitRequest() {
		try {
			response = RestAssured.given().contentType(ContentType.JSON).get(extension);
			if (response.getStatusCode() == 200) {
				System.out.println("The get employee by id test is Pass!!!!");
			} else {
				System.out.println(
						"The get employee by id test is failed and found status code: " + response.getStatusCode());
			}

			System.out.println("Reponse body" + response.asString());
		} catch (Exception e) {

			System.out.println("Exception on hit request: " + e.getMessage());

		}
	}
	
	//This test is used to verify the response data by comparing with test data properties
	@Parameters({"NAME", "SALARY", "AGE"})
	@Test(priority=3)
	public void validateResponseDate(String name, String salary, String age) {
		
		try {
		JSONObject obj=new JSONObject(response.asString());
		JSONObject data=(JSONObject) obj.get("data");
		
		String empName= data.getString("employee_name");
		
		//Name
		Assert.assertTrue(empName.equalsIgnoreCase(name));
		
		String empSal= data.getString("employee_salary");
		
		//Salary
		Assert.assertTrue(empSal.equalsIgnoreCase(salary));
		
		String empAge= data.getString("employee_age");
		
		//Age
		Assert.assertTrue(empAge.equalsIgnoreCase(age));
		
		System.out.println("Response Data validation is successfull!");
		
		}catch(Exception e) {
			
			System.out.println("Data validation exception: "+ e.getMessage());
			
		}
	}

}
