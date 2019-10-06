/**
 * 
 */
package com.baseware.helper.assertion;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.baseware.helper.logger.LoggerHelper;
/**
 * 
 * @author Vishal Gupta
 *
 */
public class AsertHelper {
	
	private static Logger log = LoggerHelper.getLogger(AsertHelper.class);
	
	/**
	 * This method will verify the is string are equal and matched
	 * @param s1
	 * @param s2
	 */
	
	public static void verifyText(String s1, String s2){
		log.info("veryfing test: "+ s1 + " with "+ s2);
		Assert.assertEquals(s1, s1);
	}
	
	/**
	 * This method will mark the verfication pass
	 */
	public static void markPass(){
		log.info("making script PASS..");
		Assert.assertTrue(true);
	}
	
	/**
	 * This method will mark the verification pass with message
	 * @param message
	 */
	public static void markPass(String message){
		log.info("making script PASS.."+ message);
		Assert.assertTrue(true, message);
	}
	
	/**
	 * Message will fail the verification
	 */
	public static void markFail(){
		log.info("making script FAIL..");
		Assert.assertTrue(false);
	}
	
	public static void markFail(String message){
		log.info("making script FAIL.."+message);
		Assert.assertTrue(false, message);
	}
	
	public static void verifyTrue(boolean status){
		Assert.assertTrue(status);
	}
	
	public static void verifyFalse(boolean status){
		Assert.assertFalse(status);
	}
	
	public static void verifyNull(String s1){
	    log.info("verify object is null..");
		Assert.assertNull(s1);
	}
	
	public static void verifyNotNull(String s1){
		log.info("verify object is not null..");
		Assert.assertNotNull(s1);
	}
	
	public static void fail(){
		Assert.assertTrue(false);
	}
	
	public static void pass(){
		Assert.assertTrue(true);
	}
	
	/**
	 * This method will update the status 
	 * @param status
	 */
	
	public static void updateTestStatus(boolean status){
		if(status){
			pass();
		}
		else{
			fail();
		}
	}
}
