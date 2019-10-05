/**
 * 
 */
package com.binance.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objectHelper.GetApiEndPoints;
import org.apache.log4j.Logger;

/**
 * @author Vishal Gupta Verify Check server time API endpoint: GET /api/v1/time
 *         Test assertion: Success only if server's time is within 5 seconds of
 *         client's time
 */
public class VerifyServerTime extends GetApiEndPoints {

	// Load property file
	@BeforeClass
	public void loadPropertyFile() {
		readPropertyFile();
	}

	@Test
	public void verifyServerTime() throws Exception {

		// Initialize the log
		Logger log = Logger.getLogger("devpinoyLogger");
		log.debug("verifyServerTime Test Starts..");

		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = baseURI();
		log.debug("Get the base url");
		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method
		// URL.
		// This will return the Response from the server. Store the response in a
		// variable.
		Response response = httpRequest.request(Method.GET, serverTimeURI());
		log.debug("Get the response from the " + serverTimeURI());
		// Get the status code
		int statusCode = response.getStatusCode();
		log.debug("Get the response code as " + statusCode);
		// Verify the response code is HTTP 200
		AssertJUnit.assertEquals(statusCode, 200);
		log.debug("Verify the response");

		log.debug("Verify that server time is less than 5 seconds");
		boolean flag = true; // flag variable for checking the time if response time is greater than 5
								// seconds then it is false
		if (response.getTime() > 5000)
			flag = false;

		// Varify that response time is not greater than 5 seconds
		AssertJUnit.assertEquals(flag, true);

		log.debug("VerifyServerTime Test End..");

	}

}
