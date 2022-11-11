package test.Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import source.Money.Divisa;
import source.Money.Money;

public class MoneyTestTemplate {
	Divisa SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100, DKK15;
	
	@Before
	public void setUp() throws Exception {
		
		SEK = new Divisa("SEK", 0.15);
		DKK = new Divisa("DKK", 0.20);
		EUR = new Divisa("EUR", 1.5);
		
		
		DKK15 = new Money(12010, DKK);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetCantidad() {
		assertEquals("No es correcta la cantidad", 10000, SEK100.getCantidad());
		assertEquals("No es correcta la cantidad", 1000, EUR10.getCantidad());
		assertEquals("No es correcta la cantidad", 20000, SEK200.getCantidad());
		assertEquals("No es correcta la cantidad", 2000, EUR20.getCantidad());
		assertEquals("No es correcta la cantidad", 0, SEK0.getCantidad());
		assertEquals("No es correcta la cantidad", 0, EUR0.getCantidad());
		assertEquals("No es correcta la cantidad", -10000, SEKn100.getCantidad());
	}

	@Test
	public void testGetDivisa() {
		assertEquals("No es correcta la cantidad", SEK, SEK100.getDivisa());
		assertEquals("No es correcta la cantidad", EUR, EUR10.getDivisa());
		assertEquals("No es correcta la cantidad", SEK, SEK200.getDivisa());
		assertEquals("No es correcta la cantidad", EUR, EUR20.getDivisa());
		assertEquals("No es correcta la cantidad", SEK, SEK0.getDivisa());
		assertEquals("No es correcta la cantidad", EUR, EUR0.getDivisa());
		assertEquals("No es correcta la cantidad", SEK, SEKn100.getDivisa());
	}

	@Test
	public void testToString() {
		assertEquals("No es correcta la cantidad", "100,0 SEK", SEK100.toString());
		assertEquals("No es correcta la cantidad", "120,1 DKK", DKK15.toString());
	}

	@Test
	public void testGlobalValue() {
		assertEquals("No es correcta la cantidad", 1500, SEK100.valorUniversal());
		assertEquals("No es correcta la cantidad", 1500, EUR10.getDivisa());
		assertEquals("No es correcta la cantidad", 3000, SEK200.getDivisa());
		assertEquals("No es correcta la cantidad", 3000, EUR20.getDivisa());
		assertEquals("No es correcta la cantidad", 0, SEK0.getDivisa());
		assertEquals("No es correcta la cantidad", 0, EUR0.getDivisa());
		assertEquals("No es correcta la cantidad", -1500, SEKn100.getDivisa());
	}

	@Test
	public void testEqualsMoney() {
		assertTrue("Are not equal", SEK100.equals(EUR10));
	}

	@Test
	public void testAdd() {
		assertEquals("No es correcta la cantidad", 20000, (SEK100.add(EUR10)).getCantidad());
	}

	@Test
	public void testIsZero() {
		assertTrue("Is not Zero", SEK0.isZero());
		assertTrue("Is not Zero", EUR0.isZero());
		assertFalse("Is not Zero", EUR20.isZero());
	}

	@Test
	public void testNegate() {
		assertEquals("Is not negative", -10000, SEK100.negate());
		assertEquals("Is not positive", 10000, SEKn100.negate());
	}

	@Test
	public void testCompareTo() {
		assertEquals("Are not equal", 0, SEK100.compareTo(EUR10));
		assertEquals("Is not negative", -1500, SEK100.compareTo(EUR20));
	}
}
