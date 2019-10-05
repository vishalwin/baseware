/**
 * 
 */
package com.baseware.testCases;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.baseware.pages.LoginPage;
import com.baseware.pages.TestAppHomePage;

import dataprovider.TestDataProvider;
import helperObects.BrowserFactory;

/**
 * @author Vishal Gupta
 * 
 *         To verify the application login functionality
 *
 */
public class LoginTest {
	private String url = "E:\\website\\website\\website\\index.html";
	
	private WebDriver driver;
	TestAppHomePage home_page;

	@BeforeClass
	public void setUp() {
		System.out.println("*******************");
		System.out.println("launching Web Browser");

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

		// Instantiate home page after successful login
		home_page = PageFactory.initElements(driver, TestAppHomePage.class);
	}

	// Tear down the application

	@AfterClass
	public void tearDown() {

		if (driver != null) {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			// logout from the home page
			home_page.clickLogoutButton();
		}

		System.out.println("Closing browser");
		driver.quit();
	}

}