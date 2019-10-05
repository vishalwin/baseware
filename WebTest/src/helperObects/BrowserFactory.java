/**
 * 
 */
package helperObects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author Vishal Gupta
 * This class help in initializing web browsers
 */
public class BrowserFactory {
	
	private static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url)
	{
		
		//Initialize firefox or other drivers
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\automationtools\\browsers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		
		//Maximize browser windows
		driver.manage().window().maximize();
		
		//Access the application URL 
		driver.get(url);
		
		
		return driver;
	}
	

}
