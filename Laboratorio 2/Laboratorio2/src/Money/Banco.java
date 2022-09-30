package Money;

import java.util.Hashtable;

public class Banco {
	
	private Hashtable<String, Cuenta> listacuentas;
	private String nombre;
	private Divisa divisa;
	
	/**
	 * Nuevo Banco
	 * @param nombre 
	 * @param divisa base del banco
	 */
	Banco(String nombre, Divisa divisa) {
		listacuentas = new Hashtable<String, Cuenta>();
		this.nombre = nombre;
		this.divisa = divisa;
	}
	
	/**
	 * @return  nombre del banco
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @return divisa del banco
	 */
	public Divisa getDivisa() {
		return divisa;
	}
	
	/**
	 * @return cuentas del banco
	 */
	public Hashtable<String, Cuenta> getCuentas() {
		return listacuentas;
	}
	
	/**
	 * Saldo de una cuenta
	 * @param cuentaid cuenta del saldo solicitado
	 * @return saldo de la cuenta
	 * @throws CuentaNoExisteException si la cuenta ya existe
	 */
	public Integer getSaldo(String cuentaid) throws CuentaNoExisteException {
		if (!listacuentas.containsKey(cuentaid)) {
			throw new CuentaNoExisteException("Cuenta no existente");
		}
		else {
			return listacuentas.get(cuentaid).getSaldo().getCantidad();
		}
	}
		
	
	/**
	 * Abre una cuenta en el banco
	 * @param cuentaid cuenta, titular nombre 
	 * @throws CuentaExisteException si la cuenta ya existe
	 */
	public void abrirCuenta(String titular, String cuentaid) throws CuentaExisteException {
		if (listacuentas.containsKey(cuentaid)) {
			throw new CuentaExisteException("Cuenta ya existe");
		}
		else {
			//crear una nueva
			Cuenta cuenta = new Cuenta(titular, divisa);
			listacuentas.put(cuentaid, cuenta);
//			 listacuentas.get(cuentaid);
		}
	}
	
	
	/**
	 * Deposito dinero en una cuenta
	 * @param cuentaid cuenta destino del depósito
	 * @param cantidad deposito
	 * @throws CuentaNoExisteException si la cuenta ya existe
	 */
	public void deposito(String cuentaid, Money cantidad) throws CuentaNoExisteException, SaldoInsuficienteException {
		if (!listacuentas.containsKey(cuentaid)) {
			throw new CuentaNoExisteException("Cuenta no existente");
		}
		else {
//			listacuentas.get(cuentaid).reintegro(cantidad);
			listacuentas.get(cuentaid).deposito(cantidad);
		}
	}
	
	/**
	 * Reintegro de una cuenta
	 * @param cuentaid cuenta del reintegro
	 * @param cantidad reintegro
	 * @throws CuentaNoExisteException si la cuenta no existe
	 */
	public void reintegro(String cuentaid, Money cantidad) throws SaldoInsuficienteException, CuentaNoExisteException{
		if (!listacuentas.containsKey(cuentaid)) {
			throw new CuentaNoExisteException("Cuenta no existente");
		}
		else {
			listacuentas.get(cuentaid).reintegro(cantidad);
//			listacuentas.get(cuentaid).deposito(cantidad);
		}
	}
	
	/**
	 * Transferir dinero entre cuentas
	 * @param decuenta cuenta de la que se reintegra el dinero
	 * @param tobanco banco de la cuenta destino
	 * @param tocuenta cuenta en la que se deposita el dinero
	 * @param cantidad importe a transferir
	 * @throws CuentaNoExisteException si la cuenta ya existe
	 * @throws SaldoInsuficiente si el importe supera al saldo en cuenta
	 */
	public void transfer(String decuenta, Banco tobanco, String tocuenta, Money cantidad) throws CuentaNoExisteException, SaldoInsuficienteException {
		if (!listacuentas.containsKey(decuenta) ) {
			throw new CuentaNoExisteException("Cuenta no existente");
		}
		
		else {
			//Quitamos dinero de la cuenta actual
			this.reintegro(decuenta,cantidad);
		    
			//Hacemos la conversion a la divisa del otro banco
			int quantity_money = tobanco.getDivisa().valorEnEstaDivisa(cantidad.getCantidad(), this.divisa);
			Money quantity = new Money(quantity_money, tobanco.getDivisa());
		    
			//Despositamos el dinero en el otro banco
			tobanco.deposito(decuenta,quantity);
		}
	}

	/**
	 * Transferir dinero entre cuentas del mismo banco
	 * @param decuenta cuenta de la que se reintegra el dinero
	 * @param tocuenta cuenta en la que se deposita el dinero
	 * @param cantidad importe a transferir
	 * @throws CuentaNoExisteException si la cuenta ya existe
	 */
	public void transfer(String decuenta, String tocuenta, Money cantidad) throws CuentaNoExisteException, SaldoInsuficienteException {
		if (!listacuentas.containsKey(decuenta) || listacuentas.containsKey(decuenta)) {
			throw new CuentaNoExisteException("Cuenta no existente");
		}
		
		else {
			this.reintegro(decuenta,cantidad);
			this.deposito(tocuenta,cantidad);
		}		

	}

}


