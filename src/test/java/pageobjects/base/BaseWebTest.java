package pageobjects.base;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Photorapher;

public abstract class BaseWebTest {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Photorapher photorapher;

	@BeforeEach
	public void setUp() {
		driver = new ChromeDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		photorapher = new Photorapher(driver);
	}
	
	@AfterEach
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
