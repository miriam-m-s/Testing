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
		fail("No implementado");
	}
	
	@Test
	public void testGlobalValue() {
		fail("No implementado");
	}
	
	@Test
	public void testValueEnEstaDivisa() {
		fail("No implementado");
	}

}
