package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	private Properties prop;

	public Config() {
		prop = new Properties();
		FileInputStream ip = null;

		try {
			ip = new FileInputStream("C:\\Users\\USER-1\\eclipse-workspace\\TestNGPOM\\src\\test\\resources\\config\\config.properties");
			prop.load(ip);
			ip.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		String value = prop.getProperty(key);
		return value;
	}
}
