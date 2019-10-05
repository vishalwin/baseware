/**
 * 
 */
package objectHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import resource.*;

/**
 * @author Vishal Gupta This class returns various API end points for
 *         automations
 */
public class GetApiEndPoints {

	static private Properties properties;

	public static void readPropertyFile() {
		/// Binance/src/resource/ApiEndPoints
		properties = new Properties();
		// Load property file
		// File propertyFile=new
		// File(System.getProperty("user.dir")+"src\\resource\\ApiEndPoints.properties");
		try {
			FileInputStream fileReader = new FileInputStream(
					"src\\resource\\config.properties");
			properties.load(fileReader);

		} catch (IOException io) {
			System.err.println("API Endpoint property file is not found" + io.getMessage());
		}
	}

	public static String baseURI() throws IOException {
		System.out.println(properties.getProperty("baseUrl"));
		return properties.getProperty("baseUrl");
	}

	public static String serverTimeURI() throws IOException {
		System.out.println(properties.getProperty("serverTimeURI"));
		return properties.getProperty("serverTimeURI");

	}

	// symbolPriceTickerURI

	public static String getSymbolPriceTickerURI() throws IOException {
		System.out.println(properties.getProperty("symbolPriceTickerURI"));
		return properties.getProperty("symbolPriceTickerURI");

	}

}
