package com.mPocketAPITest.tests;

import org.json.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mPocketAPITest.common.BaseClass;
import com.mPocketAPITest.common.RequestLoader;
import com.nPocketAPITest.utilities.ReplaceParameters;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TC001_CreateRecord {

	private static String requestBody, extension;
	private Response response = null;
	public static String Id ;
	
	//This test is to prepare the request and also updating the placeholder of payload
	@Parameters({ "PAYLOAD", "REQUESTEXT", "NAME", "SALARY", "AGE" })
	@Test(priority = 1)
	public void getRequestDetails(String payLoad, String ext, String name, String salary, String age) {

		RestAssured.baseURI = BaseClass.endpoint;

		requestBody = RequestLoader.LoadTheRequest(payLoad);
		extension = RequestLoader.LoadTheRequest(ext);

		requestBody = ReplaceParameters.replaceRestBody(requestBody, name, salary, age);

	}
	
	// This test is hit the request and validate the response
	@Test(priority = 2)
	public void hitRequest() {
		try {
			response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).post(extension);
			if (response.getStatusCode() == 200) {
				System.out.println("The create record test is Pass!!!!");
			} else {
				System.out.println(
						"The create record  test is failed and found status code: " + response.getStatusCode());
			}

			System.out.println("Reponse body" + response.asString());
			
			//constructor of the JSONObject class 
			JSONObject obj=new JSONObject(response.asString());
			JSONObject data=(JSONObject) obj.get("data");
			int id= data.getInt("id");
			Id=String.valueOf(id);
			System.out.println("ID: "+Id);
			
		} catch (Exception e) {

			System.out.println("Exception on hit request: " + e.getMessage());

		}
	}

}
