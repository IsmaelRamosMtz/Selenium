package pageobjects.navigation;

import org.openqa.selenium.WebDriver;

public class PageNavigator {


	private final WebDriver driver;

	public PageNavigator(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToLoginPage(String loginPageUrl) {
		this.driver.get(loginPageUrl);
	}

}
