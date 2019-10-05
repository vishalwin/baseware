/**
 * 
 */
package com.baseware.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Vishal Gupta Class is containing locators and methods of the
 *         TestAppHomePage of the application
 */

public class TestAppHomePage {
	private WebDriver driver;

	// Logout button locator
	@FindBy(how = How.XPATH, using = "//button[@id='btn_logout']")
	WebElement logOutButton;

	// Initialize the web driver of required web browser
	public TestAppHomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Click on Submit Button
	public void clickLogoutButton() {
		logOutButton.click();
	}

}
