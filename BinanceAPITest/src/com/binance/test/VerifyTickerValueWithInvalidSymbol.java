
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
 * @author Vishal Gupta Verify ticker value with invalid symbol API endpoint:
 *         GET /api/v3/ticker/price Query the endpoint with valid GET parameter
 *         "symbol=INVALID"
 * 
 */
public class VerifyTickerValueWithInvalidSymbol extends GetApiEndPoints {

	// Load property file
	@BeforeClass
	public void loadPropertyFile() {
		readPropertyFile();
	}

	@Test
	public void verifyTickerValueWithInvalidSymbol() throws Exception {
		// Initialize the log
		Logger log = Logger.getLogger("devpinoyLogger");
		log.debug("verifyTickerValueWithInvalidSymbol Test Starts..");
		RestAssured.baseURI = baseURI();
		log.debug("Get the base url");
		RequestSpecification httpRequest = RestAssured.given().queryParam("symbol", "INVALID");
		log.debug("Added the query parameter to the request as invalid symbol");
		Response response = httpRequest.request(Method.GET, getSymbolPriceTickerURI());
		log.debug("Get the response from the " + getSymbolPriceTickerURI());
		int statusCode = response.getStatusCode();
		log.debug("Get the response code as " + statusCode);
		System.out.println(statusCode);
		log.debug("Verify the response");
		// Verify the response code is HTTP 400
		AssertJUnit.assertEquals(statusCode, 400);
		log.debug("VerifyTickerValueWithInvalidSymbol Test End..");

	}

}
