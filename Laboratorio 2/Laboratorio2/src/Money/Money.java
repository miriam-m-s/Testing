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
	 * Return the cantidad of money.
	 * @return Amount of money in Double type.
	 */
	public int getCantidad() {
		return this.cantidad;
	}
	
	/**
	 * Returns the divisa of this Money.
	 * @return Divisa object representing the divisa of this Money
	 */
	public Divisa getDivisa() {
		return this.divisa;
	}
	
	/**
	 * Returns the cantidad of the money in the string form "(cantidad) (divisaname)", e.g. "10.5 SEK".
	 * Recall that we represent decimal numbers with integers. This means that the "10.5 SEK" mentioned
	 * above is actually represented as the integer 1050
	 *  @return String representing the cantidad of Money.
	 */
	public String toString() {
		
		return (this.cantidad/100) + "." +  + (this.cantidad%100) + " " + this.divisa.getName();
	}
	
	/**
	 * Gets the universal value of the Money, according the rate of its Divisa.
	 * @return The value of the Money in the "universal divisa"
	 */
	public int valorUniversal() {
		
		return this.divisa.valorUniversal(this.cantidad);
	}
	
	/**
	 * Check to see if the value of this money is equal to the value of another Money of some other Divisa.
	 * @param other The other Money that is being compared to this Money.
	 * @return A Boolean indicating if the two monies are equal.
	 */
	public Boolean equals(Money otra) {
		
		return this.divisa.valorUniversal(this.cantidad)== otra.divisa.valorUniversal(otra.cantidad);
	}
	
	/**
	 * Adds a Money to this Money, regardless of the Divisa of the other Money.
	 * @param other The Money that is being added to this Money.
	 * @return A new Money with the same Divisa as this Money, representing the added value of the two.
	 * (Remember to convert the other Money before adding the cantidads)
	 */
	public Money add(Money otra) {
		
		int valor= this.divisa.valorEnEstaDivisa(otra.cantidad, otra.divisa);
		return new Money(valor+this.cantidad, this.divisa);
	}

	/**
	 * Subtracts a Money from this Money, regardless of the Divisa of the other Money.
	 * @param other The money that is being subtracted from this Money.
	 * @return A new Money with the same Divisa as this Money, representing the subtracted value.
	 * (Again, remember converting the value of the other Money to this Divisa)
	 */
	public Money sub(Money otra) {
		
		int valor= this.divisa.valorEnEstaDivisa(otra.cantidad, otra.divisa);
		return new Money(this.cantidad-valor, this.divisa);
	}
	
	/**
	 * Check to see if the cantidad of this Money is zero or not
	 * @return True if the cantidad of this Money is equal to 0.0, False otherwise
	 */
	public Boolean isZero() {
		
		return this.cantidad==0.0;
	}
	/**
	 * Negate the cantidad of money, i.e. if the cantidad is 10.0 SEK the negation returns -10.0 SEK
	 * @return A new instance of the money class initialized with the new negated money cantidad.
	 */
	public Money negate() {
		return new Money((-1)*this.cantidad, this.divisa);
	}
	
	/**
	 * Compare two Monies.
	 * compareTo is required because the class implements the Comparable interface.
	 * (Remember the universalValue method, and that ints already implement Comparable).
	 * Also, since compareTo must take an Object, you will have to explicitly downcast it to a Money.
	 * @return 0 if the values of the monies are equal.
	 * A negative integer if this Money is less valuable than the other Money.
	 * A positive integer if this Money is more valuiable than the other Money.
	 */
	public int compareTo(Object otra) {
		
		Money nuevaMoney=(Money)(otra);
		
		return this.valorUniversal() - nuevaMoney.valorUniversal();
		
		
	}
}