package com.seleniumbasic;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/** Pruebas sencillas de navegación, registro y ejemplos de AssertJ. */
public class NavigationTest {

	private static int setupCount = 0;
	private static int teardownCount = 0;

	private WebDriver driver;

	@BeforeEach
	public void setUp() {
		setupCount++;
		System.out.println("Ejecutando antes de cada test: " + setupCount);
		// WebDriver controla una ventana de Chrome como lo haría una persona.
		driver = new ChromeDriver();
	}

	@AfterEach
	public void tearDown() {
		teardownCount++;
		System.out.println("Ejecutando despues de cada test: " + teardownCount);
		if (driver != null) {
			driver.quit();
		}

	}

	@Test
	public void navigateToGoogle() {
		// get abre la dirección indicada y espera a que termine de cargar.
		driver.get("https://www.google.com/?hl=es");
		// Thread.sleep(3000);

		// isDisplayed indica si el elemento aparece en pantalla; AssertJ hace fallar la
		// prueba si es falso.
		WebElement pageBody = driver.findElement(By.tagName("body"));
		assertThat(pageBody.isDisplayed()).as("El contenido de Google debe ser visible").isTrue();
		assertThat(driver.getTitle()).as("El título debe corresponder a Google").contains("Google");

	}

	@Test
	public void submitRegistrationForm() throws InterruptedException {

		// Este formulario HTML está fuera del proyecto; toURI crea una dirección válida
		// para el navegador.
		File registrationPageFile = new File(
				"D:\\Workspace selenium\\mini-web-apps\\mini-web-apps\\registration\\register.html");
		driver.get(registrationPageFile.toURI().toString());

		// Verificamos que la página que vamos a completar se muestra al usuario.
		WebElement registrationForm = driver.findElement(By.id("register-form"));
		assertThat(registrationForm.isDisplayed()).as("El formulario de registro debe ser visible").isTrue();

		// Estos son los datos que después buscaremos en la página de resumen.
		String firstName = "Ismael";
		String lastName = "Ramos";
		String age = "26";
		String country = "Mexico";
		String email = "ismael.ramos@gmail.com";

		// findElement localiza cada campo; sendKeys escribe y click selecciona
		// opciones.
		WebElement firstNameInput = driver.findElement(By.cssSelector("#name"));
		firstNameInput.sendKeys(firstName);

		WebElement lastNameInput = driver.findElement(By.cssSelector("#last-name"));
		lastNameInput.sendKeys(lastName);

		WebElement ageInput = driver.findElement(By.cssSelector("#age"));
		ageInput.sendKeys(age);

		// Select permite elegir una opción por el texto que ve el usuario.
		Select countrySelect = new Select(driver.findElement(By.cssSelector("#country")));
		countrySelect.selectByVisibleText(country);

		WebElement maleRadioButton = driver.findElement(By.cssSelector("#sex-m"));
		maleRadioButton.click();

		WebElement emailInput = driver.findElement(By.cssSelector("#email"));
		emailInput.sendKeys(email);

		WebElement mondayCheckbox = driver.findElement(By.cssSelector("#monday"));
		mondayCheckbox.click();

		// En un campo de archivo, sendKeys recibe la ruta absoluta de la imagen.
		File profileImageFile = new File("src/test/java/resources/wallpaper.png");
		WebElement profileImageInput = driver.findElement(By.cssSelector("#picture"));
		profileImageInput.sendKeys(profileImageFile.getAbsolutePath());

		WebElement saveButton = driver.findElement(By.cssSelector("#save-btn"));
		saveButton.click();

		// Guardar abre otra pestaña. Mantenemos el sleep que usabas para darle tiempo
		// al navegador.
		Thread.sleep(3000);
		Object[] windowHandles = driver.getWindowHandles().toArray();
		driver.switchTo().window((String) windowHandles[1]);

		// Buscamos el resumen después del sleep y comprobamos que se vea.
		WebElement summaryTitle = driver.findElement(By.tagName("h2"));
		assertThat(summaryTitle.isDisplayed()).as("El título del resumen debe ser visible").isTrue();
		assertThat(summaryTitle.getText()).as("El título debe indicar que estamos en el resumen").isEqualTo("Resumen");

		WebElement firstNameSummary = driver.findElement(By.cssSelector("#summary-details > p:nth-child(1)"));
		WebElement lastNameSummary = driver.findElement(By.cssSelector("#summary-details > p:nth-child(2)"));
		assertThat(firstNameSummary.isDisplayed()).as("El nombre debe ser visible en el resumen").isTrue();
		assertThat(lastNameSummary.isDisplayed()).as("El apellido debe ser visible en el resumen").isTrue();

		// Visible indica que se muestra; estas comparaciones verifican además el
		// contenido guardado.
		assertThat(firstNameSummary.getText()).as("El resumen debe incluir el nombre ingresado").contains(firstName);
		assertThat(lastNameSummary.getText()).as("El resumen debe incluir el apellido ingresado").contains(lastName);
	}

	@Test
	public void demonstrateAssertJAssertions() {
		String email = "Isma@gmail.com";
		// isEqualTo exige coincidencia exacta con el valor esperado.
		assertThat(email).isEqualTo("Isma@gmail.com");
		// isEqualToIgnoringCase acepta diferencias entre mayúsculas y minúsculas.
		assertThat(email).isEqualToIgnoringCase("isma@gmail.com");

		// También se pueden comprobar valores nulos y listas, sin abrir el navegador.
		String nullableText = null;
		assertThat(nullableText).isNull();
		nullableText = "Ya tiene valor";
		assertThat(nullableText).isNotNull();

		List<String> automationTools = List.of("Selenium", "cypress", "playwrght");
		assertThat(automationTools).as("La lista es la esperada").contains("Selenium").contains("cypress")
				.doesNotContain("postman");

		assertThat(automationTools).hasSize(3);
		assertThat(automationTools.size()).isGreaterThan(0).isLessThan(5);
	}

	@Test
	public void closeBrowserInFinally() {

		try {
			File registrationPageFile = new File(
					"D:\\Workspace selenium\\mini-web-apps\\mini-web-apps\\registration\\register.html");
			WebElement registrationForm = driver.findElement(By.id("no-existe"));
			assertThat(registrationForm.isDisplayed()).as("El formulario de registro debe ser visible").isTrue();
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
