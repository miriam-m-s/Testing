package Money;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.*;
import org.junit.rules.*;

public class BancoTestTemplate {
	Divisa SEK, DKK;
    Banco Nordea, DanskeBanco;
	Money importe;
	
	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testGetNombre() {

	}

	@Test
	public void testGetDivisa() {
	}
	
	@Test
	public void testGetCuentas() {

	}
	//Abrir cuenta Inexistente
	@Test
	public void testAbrirNuevaCuenta()  {
		
	}
	//Abrir cuenta Existente
	@Test
	public void testAbrirCuentaExistenteException() {

	}
	
	
	//Recuperar Saldo cuenta Existente
	@Test
	public void testGetSaldoCuentaExistente() {
		
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();  
	
	//Recuperar Saldo cuenta Inexistente
	@Test
	public void testGetSaldoCuentaNoExistente()  {
		
	}
	
	//Deposito cuenta Existente
	@Test
	public void testDeposito() {
		
	}
	//Deposito cuenta Inexistente
	@Test
	public void testDepositoCuentaNoExisteException() throws CuentaNoExisteException, SaldoInsuficienteException {

	}

	//Reintegro cuenta Existente con saldo suficiente
	@Test
	public void testReintegro() {
		
	}
	
	//Reintegro cuenta Inexistente
	@Test
	public void testReintegroCuentaNoExisteException() {
		
	}
	
	//Reintegro cuenta Existente con saldo Insuficiente
	@Test
	public void testReintegroSaldoInsuficienteException()  {
	
	}
	
	//Transfer a otro Banco a una cuenta existente con Saldo Suficiente
	@Test
	public void testTransferOtroBanco() {
	
	}
	//Transfer a otro Banco a cuenta inexistente 
	@Test
	public void testTransferOtroBancoCuentaNoExisteException() {
		
	}
	
	//Transfer a otro Banco a una cuenta existente con Saldo Insuficiente
	@Test
	public void testTransferOtroBancoSaldoInsuficienteException() {
		
	}
	//Transfer a mismo Banco a una cuenta existente con Saldo Suficiente
	@Test
	public void testTransferMismoBanco() {
		
	}
	//Transfer mismo Banco a cuenta inexistente	
	@Test
	public void testTransferMismoBancoCuentaNoExisteException()  {
		
	}
	//Transfer a mismo banco a una cuenta existente con Saldo Insuficiente
	@Test
	public void testTransferMismoBancoSaldoInsuficienteException()  {
		
	}
	
}
