package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserDashboardPage;
import utilities.Config;
import utilities.DriverFactory;
@Listeners(CustomListener.class)
public class LoginPageTest {
	HomePage hp;
	LoginPage lp;
	UserDashboardPage udb;
	Config reader = new Config();

	@BeforeClass
	public void setup() throws IOException, InterruptedException {
		hp = new HomePage();
		hp.launchurl(reader.getProperty("url"));
		lp = hp.clickSignIn();
	}

	@AfterClass
	public void quit() {
		DriverFactory.driver.quit();
	}

	@Test(priority = 1)
	public void pagetitletest() {
		String title = lp.pageTitle();
		Assert.assertEquals(title, "Login - My Store");
	}

	@Test(priority = 2)
	public void validateloginid() {
		boolean idvis = lp.idVisible();
		Assert.assertTrue(idvis, "ID not visible");
	}

	@Test(priority = 3)
	public void enterloginid() {
		lp.enterlogin(reader.getProperty("id"));
		System.out.println("Entered Login");
	}

	@Test(priority = 4)
	public void validatepass() {
		boolean idpass = lp.passwordVisible();
		Assert.assertTrue(idpass, "passwrd not visible");
	}

	@Test(priority = 5)
	public void enterpasswrd() {
		lp.enterpassword(reader.getProperty("password"));
		System.out.println("Entered password");

	}

	@Test(priority = 6)
	public void submitcredentials() {
		udb = lp.submit();
		System.out.println("Clicked Submit");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
