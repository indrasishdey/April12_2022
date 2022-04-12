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

public class HomePage {
	public WebDriver driver = null;
	DriverFactory df = new DriverFactory();
	Config reader = new Config();
	WebDriverWait wait;

	public HomePage() throws IOException, InterruptedException {
		driver = df.initializebrowser();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Log in to your customer account']")
	WebElement signLink;
	@FindBy(id = "search_query_top")
	WebElement searchTxt;
	
	public String launchurl(String url) {
		driver.get(url);
		return driver.getTitle();
	}
	
	public boolean isSearchDisplayed() {
		return searchTxt.isDisplayed();
	}
	
	public LoginPage clickSignIn() throws InterruptedException, IOException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(signLink));
		signLink.click();
		return new LoginPage();
	}
}
