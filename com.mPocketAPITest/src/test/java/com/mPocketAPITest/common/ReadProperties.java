package com.mPocketAPITest.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public Properties propertyRequestLoader() throws FileNotFoundException {
		
		Properties prop=new Properties();
		
		FileInputStream inputFile = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator +"test" + File.separator
				
				+ "java" + File.separator +"com" + File.separator + "mPocketAPITest" + File.separator +"config" + File.separator + "TestData.properties");
		
		if(inputFile !=null) {
			
			try {
				prop.load(inputFile);
			}catch (IOException e) {
				System.out.println("Load properties exeption: " + e.getMessage());
				
			}
		}
		
		return prop;
		
	}
	
	public String loadRequest(String property) throws FileNotFoundException {
		
		Properties propLocal = propertyRequestLoader();
		String propertyValue= propLocal.getProperty(property);
		return propertyValue;
		
	}

}
