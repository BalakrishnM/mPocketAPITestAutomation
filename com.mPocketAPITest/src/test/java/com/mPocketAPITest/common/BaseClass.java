package com.mPocketAPITest.common;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClass {
	
	public static String name, salary, age;
	public static String endpoint;
	public static Map<String, String> traversMap = new HashMap<String, String>();
	
	//This test to read and store all the parameters
	@Parameters({"URL", "NAME", "SALARY", "AGE"})
	@Test
	public static void getProperties(String endpoint, String name, String salary, String age ) {
		
		try {
		BaseClass.name=name;
		BaseClass.salary=salary;
		BaseClass.age=age;
		BaseClass.endpoint=endpoint;
		}catch(Exception e) {
			System.out.println("BaseClass Load properties exception: "+ e.getMessage());
		}
		
	}
	

}
