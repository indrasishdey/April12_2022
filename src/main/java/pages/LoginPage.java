package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Config;
import utilities.DriverFactory;

public class LoginPage {
	// DriverFactory df;
	WebDriver driver = null;
	WebDriverWait wait;

	public LoginPage() throws IOException, InterruptedException {
		// df = new DriverFactory();
		driver = DriverFactory.driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement idfield;
	@FindBy(id = "passwd")
	WebElement passwordfield;
	@FindBy(id = "SubmitLogin")
	WebElement submitBtn;

	public String pageTitle() {
		return driver.getTitle();
	}

	public boolean idVisible() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(idfield));
		return idfield.isDisplayed();
	}

	public boolean passwordVisible() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(passwordfield));
		return passwordfield.isDisplayed();
	}

	public void enterlogin(String id) {
		idfield.sendKeys(id);
	}

	public void enterpassword(String password) {
		passwordfield.sendKeys(password);
	}

	public UserDashboardPage submit() {
		submitBtn.click();
		return new UserDashboardPage();
	}
}
