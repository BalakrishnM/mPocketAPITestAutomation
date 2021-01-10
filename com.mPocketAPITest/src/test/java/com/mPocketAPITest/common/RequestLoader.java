package com.mPocketAPITest.common;

public class RequestLoader {

	static ReadProperties loadRequest = new ReadProperties();
	public static String data;

	public static String LoadTheRequest(String requestString) {

		try {
			data = loadRequest.loadRequest(requestString);
		} catch (Exception e) {
			System.out.println("Load Request properties exeption: " + e.getMessage());
		}

		return data;

	}
}
