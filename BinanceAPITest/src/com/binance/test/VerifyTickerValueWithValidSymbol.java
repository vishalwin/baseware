/**
 * 
 */
package com.binance.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.apache.log4j.Logger;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objectHelper.GetApiEndPoints;

/**
 * @author Vishal Gupta Verify ticker value with valid symbol API endpoint: GET
 *         /api/v3/ticker/price Query the endpoint with valid GET parameter
 *         "symbol=BTCUSDT" Test assertion: Server responds with HTTP status 200
 */
public class VerifyTickerValueWithValidSymbol extends GetApiEndPoints {

	// Load property file
	@BeforeClass
	public void loadPropertyFile() {
		readPropertyFile();
	}

	@Test
	public void verifyTickerValue() throws IOException {
		// Initialize the log
		Logger log = Logger.getLogger("devpinoyLogger");
		log.debug("VerifyTickerValueWithValidSymbol Test Starts..");
		RestAssured.baseURI = baseURI();
		log.debug("Get the base url");
		RequestSpecification httpRequest = RestAssured.given().queryParam("symbol", "BTCUSDT");
		log.debug("Added the query parameter to the request as valid symbol");
		Response response = httpRequest.get(getSymbolPriceTickerURI());
		log.debug("Get the response from the " + getSymbolPriceTickerURI());

		// Get the status code from the Response. In case of
		// a successfull interaction with the web service, we
		// should get a status code of 200.

		int statusCode = response.getStatusCode();
		log.debug("Get the response code as " + statusCode);
		
		
		// Verify the response code is HTTP 200
		AssertJUnit.assertEquals(statusCode, 200);
		log.debug("Verify the response");
		log.debug("VerifyTickerValueWithValidSymbol Test End..");
		
	}

}
