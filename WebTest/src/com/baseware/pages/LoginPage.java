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
 * @author Vishal Gupta Class is containing locators and methods of the Login
 *         Page of the application
 */
public class LoginPage {

	// User name, Password and Submit Button locators
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/p/span")
	WebElement invalidLoginMessage;

	// User name, Password and Submit Button locators
	@FindBy(how = How.XPATH, using = "/html/body/form/input[2]")
	WebElement userName;

	@FindBy(how = How.XPATH, using = "//*[contains(@name,'password')]")
	WebElement password;

	@FindBy(how = How.XPATH, using = "//*[contains(@type,'submit')]")
	WebElement submitButton;

	// Clear any previous text from the user name text field
	public void clearUserNameTextField() {
		userName.clear();
	}

	// Type user name into the user name text field
	public void typeUserName(String uname) {
		userName.sendKeys(uname);
	}

	// Type password into the password text field
	public void typePassword(String pass) {
		password.sendKeys(pass);
	}

	// Click on Submit Button
	public void clickSubmitButton() {
		submitButton.click();
	}

	public String verifyInvalidLoginMessage() {
		return invalidLoginMessage.getText();
	}

}
