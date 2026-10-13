package com.seleniumbasic;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercadoLibreSearchTest {

	private WebDriver driver;

	@Test
	public void searchForProduct() {

		try {
			// Navegar a sitio https://www.mercadolibre.com/
			driver = new ChromeDriver();
			driver.get("https://www.mercadolibre.com/");

			// Seleccionar Mexico
			WebElement mexicoLink = driver.findElement(By.cssSelector("#MX"));
			mexicoLink.isDisplayed();
			mexicoLink.click();

			// Buscar producto
			WebElement searchInput = driver.findElement(By.cssSelector("#cb1-edit"));

			// click/enter en la lupa
			searchInput.sendKeys("Play 5");
			// searchInput.sendKeys("Play 5", Keys.ENTER);

			// Obtener precio
			WebElement firstProductPriceElement = driver.findElement(By.cssSelector(
					"#xGawKThGCXN1LEmZQSeSxH4F513ct1oM9cec5vrLy98 > div.poly-card__content > div.poly-component__price > div.poly-price__current"));
			firstProductPriceElement.isDisplayed();

			// Imprimirlo en consola
			String firstProductPriceText = firstProductPriceElement.getText();
			System.out.println("El precio es: " + firstProductPriceText);

		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			driver.quit();
		}
	}

}
