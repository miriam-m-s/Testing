package Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Money.Divisa;
import Money.Money;

public class MoneyTest {
	Divisa SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		
		SEK = new Divisa("SEK", 0.15);
		DKK = new Divisa("DKK", 0.20);
		EUR = new Divisa("EUR", 1.5);
		
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
		
		assertEquals(EUR10.getCantidad(),1000);
		assertEquals(SEK100.getCantidad(),10000);
		assertEquals(SEK200.getCantidad(),20000);
		assertEquals(EUR20.getCantidad(),2000);
		assertEquals(SEK0.getCantidad(),0);
		assertEquals(EUR0.getCantidad(),0);
		assertEquals(SEKn100.getCantidad(),-10000);

	}

	@Test
	public void testGetDivisa() {
		
		assertEquals(SEK100.getDivisa(), SEK);
		assertEquals(EUR10.getDivisa(), EUR);
		assertEquals(SEK200.getDivisa(), SEK);
		assertEquals(EUR20.getDivisa(), EUR);
		assertEquals(SEK0.getDivisa(), SEK);
		assertEquals(EUR0.getDivisa(), EUR);
		assertEquals(SEKn100.getDivisa(), SEK);
	}

	@Test
	public void testToString() {
		
		assertEquals("100.0 SEK", SEK100.toString());
		assertEquals("200.0 SEK", SEK200.toString());
		assertEquals("0.0 SEK", SEK0.toString());
		assertEquals("-100.0 SEK", SEKn100.toString());
		assertEquals("10.0 EUR", EUR10.toString());
		assertEquals("20.0 EUR", EUR20.toString());
		assertEquals( "0.0 EUR", EUR0.toString());
	}

	@Test
	public void testGlobalValue() {
		
		assertEquals(1500, SEK100.valorUniversal());
		assertEquals(3000, SEK200.valorUniversal());
		assertEquals(0, SEK0.valorUniversal());
		assertEquals(-1500, SEKn100.valorUniversal());
		assertEquals(1500, EUR10.valorUniversal());
		assertEquals(3000, EUR20.valorUniversal());
	}

	@Test
	public void testEqualsMoney() {
		assertTrue(SEK0.equals(EUR0));
		assertTrue(EUR10.equals(SEK100));
		assertTrue(EUR20.equals(SEK200));
	}

	@Test
	public void testAdd() {
		
		Money EUR30=EUR10.add(EUR20);
		Money SEKN0=EUR10.add(SEKn100);
		
		assertTrue(EUR30.getCantidad()==3000);
		assertTrue(EUR30.getDivisa().getName()=="EUR");
		assertTrue(SEKN0.getCantidad()==0);
		assertTrue(SEKN0.getDivisa().getName()=="EUR");
	}

	@Test
	public void testSub() {
		
		Money EURn10=EUR10.sub(EUR20);
		Money SEKN0=EUR10.sub(SEKn100);
		
		assertEquals(-1000, EURn10.getCantidad());
		assertTrue(EURn10.getDivisa().getName()=="EUR");
		assertEquals(2000, SEKN0.getCantidad());
		assertTrue(SEKN0.getDivisa().getName()=="EUR");
	}

	@Test
	public void testIsZero() {
		assertTrue(EUR0.isZero());
		assertTrue(SEK0.isZero());
	}

	@Test
	public void testNegate() {
		
		Money EURneg = EUR10.negate();
		assertEquals(-1000, EURneg.getCantidad());
		assertTrue(EURneg.getDivisa().getName()=="EUR");
		
	}

	@Test
	public void testCompareTo() {
		
		assertTrue(EUR20.compareTo(EUR10) > 0);
		assertTrue(EUR10.compareTo(SEK100) == 0);
		assertTrue(EUR10.compareTo(EUR20) < 0);
		
	}
}
