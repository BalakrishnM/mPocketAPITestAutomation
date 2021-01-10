# mPocketAPITestAutomation

Steps to setup automation suite
1. Clone the project into local
2. Import the Project as maven project
3. Update/Add the test data, request payloads and URLs in TestData.properties file under config package in java/test
4. All the requried dependencies have included in pom.xml so maven will automatically load all required jars

Steps to execute the test
1. Use the exisiting testng.xml file to execute the test or modify the and execute
2. OR create new testng.xml file and add all the required tests based on the flow

Note: You can set the Parameters as test data through testng
