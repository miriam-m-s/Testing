package Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Money.Divisa;

public class DivisaTest {
	Divisa SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Divisa("SEK", 0.15);
		DKK = new Divisa("DKK", 0.20);
		EUR = new Divisa("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		assertEquals(SEK.getName(), "SEK");
		assertEquals(DKK.getName(), "DKK");
		assertEquals(EUR.getName(), "EUR");
	}
	
	@Test
	public void testGetRate() {
		assertEquals(SEK.getRate(), (Double)(0.15));
		assertEquals(DKK.getRate(), (Double)(0.20));
		assertEquals(EUR.getRate(), (Double)(1.5));
	}
	
	@Test
	public void testSetRate() {
		EUR.setRate(1.2);
		assertEquals(EUR.getRate(), (Double)(1.2));
	}
	
	@Test
	public void testGlobalValue() {
		assertTrue(SEK.valorUniversal(1055)==(int)158);
		assertTrue(SEK.valorUniversal(1000)==(int)150);
		assertTrue(DKK.valorUniversal(1000)==(int)200);
		assertTrue(EUR.valorUniversal(1000)==(int)1500);
	}
	
	@Test
	public void testValueEnEstaDivisa() {
		assertEquals(1000, SEK.valorEnEstaDivisa(100,EUR));
		assertEquals(34266, SEK.valorEnEstaDivisa(25700,DKK));
		assertEquals(257250, SEK.valorEnEstaDivisa(25725,EUR));
	}

}
