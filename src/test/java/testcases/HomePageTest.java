package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utilities.Config;
import utilities.DriverFactory;

public class HomePageTest {
	HomePage hp;
	LoginPage lp;
	Config reader = new Config();

	//@BeforeMethod
	@BeforeClass
	public void setup() throws IOException, InterruptedException {
		hp = new HomePage();
	}

	//@AfterMethod
	@AfterClass
	public void close() {
		System.out.println("quit now");
		//df.quitbrowser(this.driver);
		//WebDriver driver = hp.driver;
		//driver.quit();
		DriverFactory.driver.quit();
	}

	@Test(priority = 1)
	public void getPageTitle() {
		String title = hp.launchurl(reader.getProperty("url"));
		Assert.assertEquals(title, "My Store");
		System.out.println("URL opened successfully");
	}

	@Test(priority = 2)
	public void search() {
		boolean b = hp.isSearchDisplayed();
		Assert.assertTrue(b);
		System.out.println("Searchbox is displayed");
	}

	@Test(priority = 3)
	public void clicksignin() throws InterruptedException, IOException {
		lp = hp.clickSignIn();
		System.out.println("Clicked on 'Sign In' link");
	}
}
