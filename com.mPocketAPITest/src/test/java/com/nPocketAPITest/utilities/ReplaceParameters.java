package com.nPocketAPITest.utilities;

import java.util.HashMap;
import java.util.Map;
import com.mPocketAPITest.common.*;

public class ReplaceParameters {

	public static Map<String, String> traversMap = new HashMap<String, String>();

	// This function is used to update the payload with test data
	public static String replaceRestBody(String requestBody, String name, String salary, String age) {

		traversMap.put("NAME", name);
		traversMap.put("SALARY", salary);
		traversMap.put("AGE", age);

		for (String key : traversMap.keySet()) {

			if (requestBody.contains(key.toString())) {
				requestBody = requestBody.replace(key.toString(), traversMap.get(key).toString());
			}
		}

		return requestBody;
	}

}
