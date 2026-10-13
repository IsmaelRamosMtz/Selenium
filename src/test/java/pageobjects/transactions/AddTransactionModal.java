package pageobjects.transactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddTransactionModal {
	
	
	private By addTransactionButtonLocator = By.xpath("//button[text()='Añadir transacción']");
	private By transactionDateInputLocator = By.id("date");
	private By transactionAmountInputLocator = By.id("amount");
	private By transactionDescriptionInputLocator = By.id("description");
	private By saveTransactionButtonLocator = By.xpath("//button[text()='Guardar']");
	
	private final WebDriverWait wait;
	private WebDriver driver;
	
	public AddTransactionModal(WebDriver driver) {
		// this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	public void addTransaction(String transactionDate, String transactionAmount, String transactionDescription) {

		wait.until(ExpectedConditions.elementToBeClickable(addTransactionButtonLocator)).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(transactionDateInputLocator))
				.sendKeys(transactionDate);

		wait.until(ExpectedConditions.visibilityOfElementLocated(transactionAmountInputLocator))
				.sendKeys(transactionAmount);

		wait.until(ExpectedConditions.visibilityOfElementLocated(transactionDescriptionInputLocator))
				.sendKeys(transactionDescription);

		wait.until(ExpectedConditions.elementToBeClickable(saveTransactionButtonLocator)).click();

	}

}
