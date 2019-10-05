/**
 * 
 */
package com.baseware.testCases;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import dataprovider.TestDataProvider;
import com.baseware.pages.LoginPage;
import com.baseware.pages.TestAppHomePage;
import helperObects.BrowserFactory;

/**
 * @author Vishal Gupta To verify unauthorized user is not able to login
 *
 */
public class InvalidLoginTest {

	private String url = "E:\\website\\website\\website\\index.html";
	private WebDriver driver;
	TestAppHomePage home_page;

	@BeforeClass
	public void setUp() {
		System.out.println("*******************");
		System.out.println("launching Web Browser");
		driver = BrowserFactory.startBrowser("chrome", url);
	}

	// Verify invalid login attempt
	@Test(dataProvider = "invalidUserDataProvider", dataProviderClass = TestDataProvider.class)
	public void verifyInvalidLogin(String invalidUser, String password) {

		// Initialize the login page by using page factory

		LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);

		// Clear the user name text field

		login_page.clearUserNameTextField();

		// Type invalid user name into user name text field
		login_page.typeUserName(invalidUser);

		// Type the password in password text field
		login_page.typePassword(password);

		// Click the submit button
		login_page.clickSubmitButton();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// Varify that invalid login message appears for invalid user login attempt

		Assert.assertEquals(login_page.verifyInvalidLoginMessage(), "Invalid credentials!",
				"Message is not as per expected value");

	}

	// Tear down the application

	@AfterClass
	public void tearDown() {

		if (driver != null) {

			System.out.println("Closing browser");
			driver.quit();
		}
	}

}
