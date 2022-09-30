package Money;

public class Divisa {
	
	private String nombre;
	private Double rate;
	
	/**
	 * 
	 * The rate argument of each currency indicates that Divisa's "universal" exchange rate.
	 * Imagine that we define the rate of each currency in relation to some universal currency.
	 * This means that the rate of each currency defines its value compared to this universal currency.
	 *
	 * @param nombre The nombre of this Divisa
	 * @param rate The exchange rate of this Divisa
	 */
	Divisa (String nombre, Double rate) {
		this.nombre = nombre;
		this.rate = rate;
	}

	/** Convert an cantidad of this Divisa to its value in the general "universal currency"

	 * @param cantidad An cantidad of cash of this currency.
	 * @return The value of cantidad in the "universal currency"
	 */
	public int valorUniversal(int cantidad) {
		
		return (int)(cantidad * this.rate);
	}

	/** Get the nombre of this Divisa.
	 * @return nombre of Divisa
	 */
	public String getName() {
		return this.nombre;
	}
	
	/** Get the rate of this Divisa.
	 * 
	 * @return rate of this Divisa
	 */
	public Double getRate() {
		return this.rate;
	}
	
	/** Set the rate of this currency.
	 * 
	 * @param rate New rate for this Divisa
	 */
	public void setRate(Double rate) {
		
		this.rate=rate;
	}
	
	/** Convert an cantidad from another Divisa to an cantidad in this Divisa
	 * 
	 * @param cantidad Amount of the other Divisa
	 * @param othercurrency The other Divisa
	*/
	public int valorEnEstaDivisa(int cantidad, Divisa otraDivisa) {
		
		return (int)(cantidad*otraDivisa.getRate()/this.rate);
			
	}
}
