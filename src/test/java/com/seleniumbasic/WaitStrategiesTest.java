package com.seleniumbasic;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStrategiesTest {

	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeEach
	public void setUp() {
		driver = new ChromeDriver();
		// Damos 6 segundos de espera antes que falle (implicito)
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

		// Explicito si se pasa de 6 truena si es menos renderiza (Recomendado)
		wait = new WebDriverWait(driver, Duration.ofSeconds(6));
	}

	@AfterEach
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void readMessageWithoutExplicitWait() {
		driver.get("file:///D:/Workspace%20selenium/mini-web-apps/mini-web-apps/esperas.html");
		
		
		WebElement showMessageButton = driver.findElement(By.id("loadBtn"));

		WebElement successAlert = driver.findElement(By.cssSelector("div[class=alert-success]"));

		String successMessageText = successAlert.getText();

		System.out.println("Success Message is: " + successMessageText);

	} // #END Class

	@Test
	public void readMessageWithExplicitWait() {
		driver.get("file:///D:/Workspace%20selenium/mini-web-apps/mini-web-apps/esperas.html");

		WebElement showMessageButton = driver.findElement(By.id("loadBtn"));

		showMessageButton.click();

		WebElement successAlert = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=alert-success]")));


		String successMessageText = successAlert.getText();

		System.out.println("Success Message is: " + successMessageText);

	} // #END Class

	@Test
	public void readMessageWithFluentWait() {
		driver.get("file:///D:/Workspace%20selenium/mini-web-apps/mini-web-apps/esperas.html");
		
		Wait<WebDriver> fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);

		WebElement showMessageButton = driver.findElement(By.id("loadBtn"));

		showMessageButton.click();

		WebElement successAlert = fluentWait
				.until(browser -> browser.findElement(By.cssSelector("div[class=aler-success]")));


		String successMessageText = successAlert.getText();

		System.out.println("Success Message is: " + successMessageText);
	}

} // #END Suite
