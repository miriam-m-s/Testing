package Money;

public class Money implements Comparable {
	
	private int cantidad;
	private Divisa divisa;

	/**
	 * @param cantidad	
	 * @param divisa	
	 */
	Money (int cantidad, Divisa divisa) {
		this.cantidad = cantidad;
		this.divisa = divisa;
	}
	
	/**
	 * Return Cantidad.
	 * @return Cantidad.
	 */
	public int getCantidad() {
		return cantidad;
	}
	
	/**
	 * Returns Divisa.
	 * @return Divisa asociada a esta cantidad
	 */
	public Divisa getDivisa() {
		return divisa;
	}
	
	/**
	 * Devuelve un String "cantidad nombre de divisa", e.g. "10.5 SEK".
	 * Los numeros decimales se representan con enteros, e.g "10.5 SEK" se almacena como 1050
	 * 
	 *  @return String con informaci�n de la moneda.
	 */
	public String toString() {
		int entero=cantidad/100;
		int decimal=cantidad%100;
		if(decimal%10==0)decimal/=10;
		return (entero+","+decimal+" "+ divisa.getName());
	}
	
	/**
	 * Valor universal de la cantidad de acuerdo al rate asociado a la divisa
	 * @return Valor universal de la cantidad
	 */
	public int valorUniversal() {
		return divisa.valorUniversal(cantidad);
		
	}
	
	/**
	 * Chequea si el valor universal de otro objeto Money es equivalente al actual
	 * @param Objeto Money a comparar
	 * @return Boolean indicando equivalencia
	 */
	public Boolean equals(Money otra) {
		return otra.valorUniversal() == valorUniversal();
	}
	
	/**
	 * A�ade un objeto Money al actual 
	 * @param Objeto Money a a�adir.
	 * @return Un nuevo objeto Money con la divisa del actual, y la cantidad acumulada con el importe del objeto Money recibido.
	 **/
	public Money add(Money otra) {
		//Pasamos la cantidad del money recibido a nuestra divisa, y lo sumamos al nuestro
		return new Money(cantidad + divisa.valorEnEstaDivisa(otra.cantidad, otra.divisa), divisa);
	}

		
	/**
	 * 
	 * @return True si cantidad es cero, false e.o.c.
	 */
	public Boolean isZero() {
		return cantidad==0;
	}
	/**
	 * Convierte la cantidad del objeto actual a negativo
	 * @return Un nuevo objeto Money con la cantidad en negativo
	 */
	public Money negate() { 
		return new Money(-cantidad,divisa);
	}
	
	/**
	 * Compara dos objetos Money
	 * @return 0  si sus valores son iguales
	 * Un entero negativo si el objeto actual tiene menos valor que el recibido
	 * Un entero positivo si el objeto actual tiene m�s valor que el recibido
	 */
	public int compareTo(Object otra) {
		Money din=(Money)otra;
		if(equals(din))return 0;
		else return valorUniversal() - din.valorUniversal();
	}
}