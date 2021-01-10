package com.mPocketAPITest.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.IAlterSuiteListener;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlSuite;

public class PropertyInjectorListener implements IAlterSuiteListener {

	private void getPropertiesFromFile(Properties properties, String fileName)
			throws FileNotFoundException, IOException {

		properties.load(new FileReader(Paths
				.get(System.getProperty("user.dir"), "src", "test", "java", "com", "mPocketAPITest", "config", fileName)
				.toFile()));
	}

	@Parameters({ "ConfigFile" })
	public void alter(List<XmlSuite> suites) {

		XmlSuite suite = suites.get(0);
		String configFile = suite.getParameter("ConfigFile");

		Properties properties = new Properties();

		try {
			this.getPropertiesFromFile(properties, configFile);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Map<String, String> para = new HashMap<String, String>();
		for (Map.Entry<Object, Object> each : properties.entrySet()) {
			para.put(each.getKey().toString(), each.getValue().toString());
		}
		suite.setParameters(para);

	}

}
