package Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Money.Divisa;
import Money.Money;

public class MoneyTestTemplate {
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
		fail("No implementado");
	}

	@Test
	public void testGetDivisa() {
		fail("No implementado");
	}

	@Test
	public void testToString() {
		fail("No implementado");
	}

	@Test
	public void testGlobalValue() {
		fail("No implementado");
	}

	@Test
	public void testEqualsMoney() {
		fail("No implementado");
	}

	@Test
	public void testAdd() {
		fail("No implementado");
	}

	@Test
	public void testSub() {
		fail("No implementado");
	}

	@Test
	public void testIsZero() {
		fail("No implementado");
	}

	@Test
	public void testNegate() {
		fail("No implementado");
	}

	@Test
	public void testCompareTo() {
		fail("No implementado");		
	}
}
