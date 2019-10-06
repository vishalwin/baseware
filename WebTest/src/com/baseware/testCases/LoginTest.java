/**
 * 
 */
package com.baseware.testCases;

import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.baseware.helper.assertion.AsertHelper;
import com.baseware.helper.assertion.VerificationHelper;
import com.baseware.helper.wait.WaitHelper;
import com.baseware.pages.LoginPage;
import com.baseware.pages.TestAppHomePage;
import com.baseware.testBase.TestBase;

import dataprovider.TestDataProvider;
import helperObects.BrowserFactory;

/**
 * @author Vishal Gupta
 * 
 *         To verify the application login functionality
 *
 */
public class LoginTest extends TestBase {
	private String url = "E:\\website\\website\\website\\index.html";

	private WebDriver driver;
	TestAppHomePage home_page;


	@BeforeClass
	public void setUp() {
		System.out.println("*******************");
		System.out.println("Verify Successful Login with Valid Credentials");

		driver = BrowserFactory.startBrowser("chrome", url);
	}

	// Verify Login account

	@Test(dataProvider = "validUserDataProvider", dataProviderClass = TestDataProvider.class)
	public void verifyLogin(String userName, String password) {

		// Initialize the login page by using page factory

		LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);

		// Clear the user name text field

		login_page.clearUserNameTextField();

		// Type the user name into user name text field
		login_page.typeUserName(userName);

		// Type the password in password text field
		login_page.typePassword(password);

		// Click the submit button
		login_page.clickSubmitButton();
		
	
		
		// Setting up some wait 
		new WaitHelper(driver).setImplicitWait(4,TimeUnit.SECONDS);
		
		
	
		// Instantiate home page after successful login
		home_page = PageFactory.initElements(driver, TestAppHomePage.class);

		// Verify that user is on home page after successfully logging into the
		// application
		
		Assert.assertEquals(home_page.getLogoutButtonText(), "Logout");

	}

	// Tear down the application

	@AfterClass
	public void tearDown() {

		if (driver != null) {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			// Setting up some wait 
			new WaitHelper(driver).setImplicitWait(4,TimeUnit.SECONDS);
			
		
			// logout from the home page
			home_page.clickLogoutButton();
		}

		System.out.println("Closing browser");
		driver.quit();
	}

}
