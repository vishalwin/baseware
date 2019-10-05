Hi Sir,
Please find attached work as eclipse-workspace.rar file.  It contains two folders V.I.Z. BinanceAPITest and WebTest which are solutions to the assignment provided to me.  Please find the details as mentioned below:
1. WebTest folder contains the framework where I Implemented the one successful and one unsuccessful login test against the provided test website.
2. BinanceAPITest folder contains the framework where I Implemented a simple test suite for Binance API covering some public endpoints.
Description : WebTest – It’s a page object model framework.  It is divided into four packages :
i. “com.baseware.pages” containing pages representing each page of the provided application and respective page elements and method behaviours of the page.
ii. “com.baseware.testCases” containing test cases which where TestNG assertions are being used for verifications. TestNG is also used as data provider for test cases.
iii. “dataprovider” contains the TestDataProvider class which is providing data to the test cases.
iv. “helperObects” contains the BrowserFactory class which is being used for initializing the web browsers. 
v. testng.xml is used to execute the suite

Description : BinanceAPITest– It’s is divided into three packages :
i. “com.binance.test” it contains three test cases V.I.Z. VerifyServerTime, VerifyTickerValueWithInvalidSymbol and VerifyTickerValueWithValidSymbol which are automating GET /api/v1/time, GET /api/v3/ticker/price with invalid symbol as request parameter and /api/v3/ticker/price with valid symbol as request parameter.
I used Rest Assured, TestNG and Log4j and Properties file for providing various URI inorder to automate the application’s end point dynamically.
ii. “objectHelper” , this package contains the GetApiEndPoint class which is providing the API endpoints to the test cases dynamically.
iii. “resource” it contains “config.properties” file which is acts as a repository of the API end points for the applicattion and can be used to accommodate more API end points in future
iv. Manual.log file can used used to read the logs generaged from log4j framework in order to debug testing framework as and when required.
v. testng.xml is used for execution of the test suite.



