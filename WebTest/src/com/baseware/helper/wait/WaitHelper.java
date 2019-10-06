/**
 * 
 */
package com.baseware.helper.wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseware.helper.logger.LoggerHelper;

/**
 * @author Vishal Gupta This class serves various waits to the framework
 *
 */
public class WaitHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}


	/**
	 * Setting up implicit wait
	 * @param timeout
	 * @param unit
	 */
	public void setImplicitWait(long timeout, TimeUnit unit) {
		log.info("Implicit Wait has been st to " + timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}

	/**
	 * Setting up polling time
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */

	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec)); // pollingEvery(pollingEveryInMiliSec);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;

	}

	/**
	 * Polling for element visibility
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 */
	
	public void waitForElementVisible(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
		log.info("Waiting for : " + element.toString() + "for :" + timeOutInSeconds);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Elemenyt is visible now");

	}
	
	
	/**
	 * Polling until element is clickable
	 * @param element
	 * @param timeOutInSeconds
	 */

	
	public void waitForElementClickable(WebElement element, int timeOutInSeconds) {
		log.info("Waiting for : " + element.toString() + "for :" + timeOutInSeconds);
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Elemenyt is visible now");
	}

	/**
	 * Method to wait till a particular element disappear from UI
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	
	public boolean waitForElementNotPresent(WebElement element, int timeOutInSeconds) {
		log.info("Waiting for : " + element.toString() + "for :" + timeOutInSeconds);
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("Element is clickable");
		return status;

	}
	
	
	/**
	 * This method will wait for frame and switch to it
	 * @param element
	 * @param timeOutInSeconds
	 */
	

	public void  waitForFrameToBeAvailableAndSwitchToIt(WebElement element, int timeOutInSeconds) {
		log.info("Waiting for : " + element.toString() + "for :" + timeOutInSeconds);
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("Frame is available and switched");
		

	}
	
	/**
	 * This method will provide a fluent wait
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */
	private Wait <WebDriver> getFluentWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		
		Wait <WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.ignoring(NoSuchElementException.class);
		return fluentWait;
	}
	
	/**
	 * This method will return web element when it is visible
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */
	
	public WebElement waitForElement(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
		Wait <WebDriver> fluentWait=getFluentWait(timeOutInSeconds,pollingEveryInMiliSec);
		fluentWait.until(ExpectedConditions.invisibilityOf(element));
		return element;
	}

	/**
	 * This method healp us in page loading wait time
	 * @param timeout
	 * @param unit
	 */
	public void pageLoadTime(long timeout,TimeUnit unit) {
		log.info("Waiting for page to load for  : "+unit);
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("Page is loaded");
	}
}
