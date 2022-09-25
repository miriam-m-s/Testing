package Money;

public class Divisa {
	
	private String nombre;
	private Double rate;
	
	/**
	 * 
	 * El valor de rate corresponde al valor de la divisa en una divisa universal.
	 * @param nombre nombre de la Divisa
	 * @param rate cambio de la divisa
	 */
	Divisa (String nombre, Double rate) {
		this.nombre = nombre;
		this.rate = rate;
	}

	/** Convierte una cantidad al importe correspondiente en la divisa universal

	 * @param cantidad Cantidad en la divisa actual.
	 * @return valor en la divisa universal
	 */
	public int valorUniversal(int cantidad) {
		double valor = cantidad * rate;
		int entera= (int) (valor/100); // 1
		int decimal=(int) (valor%100); // 50
		
		return entera * 100 + decimal;
	}

	/** Nombre de la divisa
	 * @return nombre de la divisa
	 */
	public String getName() {
		return nombre;
	}
	
	/** Rate de la divisa
	 * 
	 * @return rate de la divisa
	 */
	public Double getRate() {
		return rate;
	}
	
	/** Actualiza rate de la divisa
	 * 
	 * @param rate  Nuevo rate de la divisa
	 */
	public void setRate(Double rate_) {
		rate=rate_;
	}
	
	/** Convierte una cantidad de una divisa al importe correspondiente en la divisa actual
	 * 
	 * @param cantidad importe a convertir 
	 * @param otraDivisa divisa origen
	*/
	public int valorEnEstaDivisa(int cantidad, Divisa otraDivisa) {
		
		int universal_ = valorUniversal(cantidad);
		
		return universal_ / otraDivisa.rate;
	}
}
