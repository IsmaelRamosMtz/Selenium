package pageobjects.transactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.TransactionInfo;

/**
 * Page Object que lee las filas de la tabla mediante Selenium.
 * Devuelve sus datos como TransactionInfo para que el test pueda compararlos.
 * Las verificaciones del resultado permanecen en el test.
 */
public class TrasactionsTable {

	// private WebDriver driver;
	private WebDriverWait wait;

	private By WebElement = (By.id("transactions - list"));

	/** Recibe el navegador del test y prepara la espera para localizar la fila. */
	public TrasactionsTable(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	/**
	 * Lee fecha, monto y descripción de una fila de la página actual de la tabla.
	 *
	 * @param rowIndex posición de la fila en XPath: 1 es la primera, 2 la segunda.
	 * @return un objeto nuevo que contiene los textos leídos en ese momento.
	 */
	public TransactionInfo getTransactionInfoFromRow(int rowIndex) {
		// Construimos el XPath de la fila. Para rowIndex = 1 termina en /tr[1].
		String rowInfo = "//tbody[@id='transactions-list']/tr[" + rowIndex + "]";

		// Esperamos a que la fila sea visible; rowElement representa esa fila HTML.
		WebElement rowElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(rowInfo)));

		// ./ busca dentro de rowElement. td[1] es su primera celda: la fecha.
		// getText() consulta Selenium y devuelve el texto que muestra esa celda.
		String currentDate = rowElement.findElement(By.xpath("./td[1]")).getText();

		// La segunda celda contiene el monto; getText() lo devuelve como String.
		String currentAmount = rowElement.findElement(By.xpath("./td[2]")).getText();

		// La tercera celda contiene la descripción de la misma fila.
		String currentDescription = rowElement.findElement(By.xpath("./td[3]")).getText();

		// Creamos un contenedor en memoria para reunir los tres valores observados.
		// Todavía no tiene datos: sus campos String empiezan con null.
		TransactionInfo transactionInfo = new TransactionInfo();
		// Los setters guardan los textos en el objeto; no escriben en la página.
		// Por ejemplo, si currentAmount es "1000", setAmount guarda ese String.
		transactionInfo.setAmount(currentAmount);
		transactionInfo.setDate(currentDate);
		transactionInfo.setDescription(currentDescription);

		// Entregamos el objeto al test. Allí getAmount() leerá el monto guardado.
		// Este objeto es una copia de los datos: no se actualiza si cambia la tabla.
		return transactionInfo;

	}

}
