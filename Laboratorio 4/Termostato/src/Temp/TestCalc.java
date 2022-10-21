package Calc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class TestCalc {
	
	private static final Object[] getCalculation() {
		return new Object[] {//M1 D1 M2 D2  YEAR
				new Object[] {1 , 1, 1, 3, 2005}, 
				new Object[] {1 , 1, 1, 3, 2005}, 
		};
	}
	
	@Before
	public void setUp() throws Exception {
	
	}
	
	@Test
	@Parameters(method = "getCalculation")
	public void testCalculation(int month1, int day1, int month2, int day2, int year) {
		Calculate calc = new Calculate();
		assertEquals(2, calc.cal(month1, day1, month2, day2, year));
	}
}
