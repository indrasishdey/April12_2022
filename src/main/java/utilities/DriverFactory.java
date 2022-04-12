package utilities;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	//private WebDriver driver;
	public static WebDriver driver;

	Config configReader = new Config();

	public WebDriver initializebrowser() throws IOException, InterruptedException {
		String b = configReader.getProperty("browser");

		if (b.equals("chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// ".\\src\\test\\resources\\browserdriver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (b.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.get(configReader.getProperty("url"));
		return driver;
	}

//	public WebDriver getbrowser() {
//		return driver;
//	}

	public void quitbrowser() {
		driver.quit();
	}
}
