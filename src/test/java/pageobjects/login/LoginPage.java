package pageobjects.login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private final WebDriverWait wait;

	private By usernameInputLocator = By.id("username");
	private By passwordInputLocator = By.cssSelector("input[type=password]");
	private By loginButtonLocator = By.xpath("//button[text()='Iniciar sesión']");
	// private WebDriver driver;

	public LoginPage(WebDriver driver) {
		// this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void login(String username, String password) {

		// this.driver.findElement(usernameInputLocator).sendKeys("Isma");
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputLocator)).sendKeys(username);

		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputLocator)).sendKeys(password);

		wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator)).isDisplayed();
		wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator)).click();
	}

}
