package com.seleniumbasic;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Models.TransactionInfo;
import pageobjects.base.BaseWebTest;
import pageobjects.login.LoginPage;
import pageobjects.navigation.PageNavigator;
import pageobjects.transactions.AddTransactionModal;
import pageobjects.transactions.TrasactionsTable;

public class LoginAndTransactionTest extends BaseWebTest {


	@Test
	public void addTransactionWithoutPageObjects() {

		driver.get("file:///D:/Workspace%20selenium/mini-web-apps/mini-web-apps/login/login.html");

		WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

		/*
		 * WebElement usernameInput = driver.findElement(By.name("username"));
		 * 
		 * WebElement usernameInput =
		 * driver.findElement(By.xpath("//input[@id="username"]"));
		 * 
		 * WebElement usernameInput =
		 * driver.findElement(By.cssSelector("input[id=username]"));
		 * 
		 * WebElement usernameInput =
		 * driver.findElement(By.cssSelector("input#username"));
		 */

		usernameInput.sendKeys("user");

		WebElement passwordInput = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=password]")));
		passwordInput.sendKeys("pass");

		WebElement loginButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Iniciar sesión']")));
		loginButton.click();

		WebElement addTransactionButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Añadir transacción']")));
		addTransactionButton.click();

		WebElement transactionDateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("date")));
		transactionDateInput.sendKeys("21/07/2000");

		WebElement transactionAmountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount")));
		transactionAmountInput.sendKeys("4000");

		WebElement transactionDescriptionInput = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("description")));
		transactionDescriptionInput.sendKeys("Descprcion de transaccion");

		WebElement saveTransactionButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Guardar']")));
		saveTransactionButton.click();

	}

	@Test
	public void logInWithPageObject() {
		driver.get("file:///D:/Workspace%20selenium/mini-web-apps/mini-web-apps/login/login.html");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("user", "pass");
	}

	@Test
	public void addTransactionWithPageObjects() throws IOException {

		String date = "14/04/24";
		String amount = "1000";
		String description = "Este es un test";


		PageNavigator pageNavigator = new PageNavigator(driver);
		pageNavigator.navigateToLoginPage(
				"file:///D:/Workspace%20selenium/mini-web-apps/mini-web-apps/login/login.html");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("user", "pass");

		AddTransactionModal addTransactionModal = new AddTransactionModal(driver);
		addTransactionModal.addTransaction(date, amount, description);

		// Creamos el Page Object que sabe localizar y leer la tabla del navegador.
		TrasactionsTable trasactionsTable = new TrasactionsTable(driver);
		// Leemos la primera fila. El método usa getText() y guarda los tres textos
		// con setDate(), setAmount() y setDescription() en un TransactionInfo nuevo.
		TransactionInfo transactionInfo = trasactionsTable.getTransactionInfoFromRow(1);

		// getAmount() obtiene el monto observado que está guardado en el objeto.
		// amount es el monto esperado que definimos al inicio del test.
		// AssertJ compara ambos y hace fallar la prueba si son diferentes.
		// Esta aserción verifica el monto; no verifica aún fecha ni descripción.
		photorapher.takePhoto("transactions");
		assertThat(transactionInfo.getAmount()).isEqualTo(amount);

	}
}
