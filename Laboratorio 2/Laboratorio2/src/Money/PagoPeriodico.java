package Money;

public class PagoPeriodico {
	
	private Cuenta decuenta;
	private Money cantidad;
	private Cuenta tocuenta;
	
	PagoPeriodico(Money cantidad, Cuenta decuenta, Cuenta tocuenta) {
		
		this.cantidad = cantidad;
		this.decuenta = decuenta;
		this.tocuenta = tocuenta;
	}
	
}