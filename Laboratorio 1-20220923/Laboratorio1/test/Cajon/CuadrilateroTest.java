package Cajon;



import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CuadrilateroTest {
	Cuadrilatero square1, square2, rectangle1, rectangle2, quad;
	
	@Before
	public void setUp() throws Exception {
		/* Set up two squares,
		 * two rectangles that are not squares,
		 * and a quad that is neither a rectangle nor a square. */
		square1 = new Cuadrilatero(new Point(2, 3), new Point(4, 7), new Point(8, 5), new Point(6, 1));
		square2 = new Cuadrilatero(new Point(-1, -1), new Point(-1, 1), new Point(1, 1), new Point(1, -1));
		rectangle1 = new Cuadrilatero(new Point(4, 2), new Point(3, 4), new Point(9, 7), new Point(10, 5));
		rectangle2 = new Cuadrilatero(new Point(-2, -1), new Point(-2, 1), new Point(2, 1), new Point(2, -1));
		quad = new Cuadrilatero(new Point(-2, -2), new Point(-1, 1), new Point(1, 1), new Point(1, -1));
	}
	
	@Test
	public void testRectangle() {
		String msg = "Should be a rectangle";
		assertTrue(msg, square1.isRectangulo());
		assertTrue(msg, square2.isRectangulo());
		assertTrue(msg, rectangle1.isRectangulo());
		assertTrue(msg, rectangle2.isRectangulo());
		assertFalse("Should not be a rectangle", quad.isRectangulo());
	}
	
	@Test
	public void testSquare() {
		String tmsg = "Should be a square";
		String fmsg = "Should not be a square";
		assertTrue(tmsg, square1.isSquare());
		assertTrue(tmsg, square2.isSquare());
		assertFalse(fmsg, rectangle1.isSquare());
		assertFalse(fmsg, rectangle2.isSquare());
		assertFalse(fmsg, quad.isSquare());
	}
}
