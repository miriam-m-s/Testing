package Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Money.Divisa;

public class DivisaTestTemplate {
	Divisa SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Divisa("SEK", 0.15);
		DKK = new Divisa("DKK", 0.20);
		EUR = new Divisa("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		assertEquals((String)"SEK", SEK.getName());
		assertEquals((String)"DKK", DKK.getName());	
		assertEquals((String)"EUR", EUR.getName());

	}
	
	@Test
	public void testGetRate() {
		assertEquals((Double)0.15, SEK.getRate());
		assertEquals((Double)0.20, DKK.getRate());
		assertEquals((Double)1.5, EUR.getRate());
	}
	
	@Test
	public void testSetRate() {
		SEK.setRate(0.7);
		DKK.setRate(1.34);
		EUR.setRate(2.4);
		
		assertEquals((Double)0.7, SEK.getRate());
		assertEquals((Double)1.34, DKK.getRate());
		assertEquals((Double)2.4, EUR.getRate());
	}
	
	@Test
	public void testGlobalValue() {
		int cant=1000;
		int result=SEK.valorUniversal(cant);
		assertEquals("No es correcto el cambio de SEK a global", 150, result);
		 result=DKK.valorUniversal(cant);
		assertEquals("No es correcto el cambio de DKK a global", 200, result);
		 result=EUR.valorUniversal(cant);
		 assertEquals("No es correcto el cambio de EUR a global", 1500, result);
	}
	
	@Test
	public void testValueEnEstaDivisa() {
		int cantidad = 12010;
		int result;
		//SEK ===============================
		result = SEK.valorEnEstaDivisa(cantidad, DKK);
		assertEquals("No es correcto el cambio de SEK a DKK", 16013, result);
		result = SEK.valorEnEstaDivisa(cantidad, EUR);
		assertEquals("No es correcto el cambio de SEK a DKK", 120100, result);
		//DKK ===============================
		result = DKK.valorEnEstaDivisa(cantidad, SEK);
		assertEquals("No es correcto el cambio de SEK a DKK", 9005, result);
		result = DKK.valorEnEstaDivisa(cantidad, EUR);
		assertEquals("No es correcto el cambio de DKK a EUR", 90075, result);
		
	}

}
