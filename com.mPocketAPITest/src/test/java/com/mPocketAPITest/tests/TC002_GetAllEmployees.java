package com.mPocketAPITest.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mPocketAPITest.common.BaseClass;
import com.mPocketAPITest.common.RequestLoader;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TC002_GetAllEmployees {
	
	private static String extension;
	private Response response = null;
	
	//This test is to prepare the request
	@Parameters({"REQUESTEXT", "REQUESTEXT" })
	@Test(priority = 1)
	public void getRequestDetails(String payLoad, String ext) {

		RestAssured.baseURI = BaseClass.endpoint;

		extension = RequestLoader.LoadTheRequest(ext);

	}
	
	// This test is hit the request and validate the response
	@Test(priority = 2)
	public void hitRequest() {
		try {
			response = RestAssured.given().contentType(ContentType.JSON).when().get(extension);
			if (response.getStatusCode() == 200) {
				System.out.println("The create record test is Pass!!!!");
			} else {
				System.out.println(
						"The create record  test is failed and found status code: " + response.getStatusCode());
			}

			System.out.println("Reponse body" + response.asString());
		} catch (Exception e) {

			System.out.println("Exception on hit request: " + e.getMessage());

		}
	}

}
