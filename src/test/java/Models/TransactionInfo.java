package Models;

/**
 * Contenedor de los datos de una transacción leída de la tabla.
 * No usa Selenium ni guarda cambios en el navegador o en una base de datos.
 * Sus setters guardan valores en memoria y sus getters permiten leerlos.
 */
public class TransactionInfo {

	// private impide acceder directamente a estos campos desde otras clases.
	// En esta clase los exponemos mediante métodos públicos get y set.
	// Todos son String: el monto conserva el texto leído, por ejemplo "1000".
	private String date;
	private String amount;
	private String description;

	/** Getter: devuelve la fecha guardada en este objeto. */
	public String getDate() {
		return date;
	}

	/** Setter: recibe una fecha y la guarda; no devuelve un valor (void). */
	public void setDate(String date) {
		// this.date es el campo del objeto; date es el parámetro recibido.
		this.date = date;
	}

	/**
	 * Getter: devuelve el monto que el setter guardó previamente.
	 * Después de setAmount("1000"), getAmount() devuelve "1000".
	 * No vuelve a consultar la tabla del navegador.
	 */
	public String getAmount() {
		return amount;
	}

	/** Setter: guarda el monto recibido dentro de este objeto. */
	public void setAmount(String amount) {
		// Guardamos el parámetro amount en el campo this.amount del objeto.
		this.amount = amount;
	}

	/** Getter: devuelve la descripción guardada. */
	public String getDescription() {
		return description;
	}

	/** Setter: guarda la descripción recibida. */
	public void setDescription(String description) {
		// this.description es el campo; description es el parámetro recibido.
		this.description = description;
	}

}
