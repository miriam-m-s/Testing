package MultiplyTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import Multiplicar.Multiply;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class TestCalc {
	
	private static final Object[] getCalculation() {
		return new Object[] {//M1 D1 M2 D2  YEAR
				new Object[] {new int[]{1,2,2}, new int[]{1,2,2}, new int[] {1,4,4}},
				new Object[] {new int[]{1,2}, new int[]{1,2,2} , new int[] {1,4,2}},
				new Object[] {new int[]{1,2,2} , new int[]{1,2}, new int[] {1,4,2}}
		};
	}
	
	private static final Object[] getNulls() {
		return new Object[] {//M1 D1 M2 D2  YEAR
				new Object[] {null, null},
				new Object[] {null, new int[]{1,2,2} },
				new Object[] {new int[]{1,2,2}, null}, 
		};
	}
	
	@Test
	@Parameters(method = "getNulls")
	public void testNulls(int[] array1, int[] array2) throws Exception {
		Multiply calc = new Multiply();
		
		NullPointerException expected;
		expected= assertThrows(NullPointerException.class,
		() -> calc.multiplica(array1, array2));
	}
	
	@Test
	@Parameters(method = "getCalculation")
	public void testArrays(int[] array1, int[] array2,int[] result) throws Exception {
		Multiply calc = new Multiply();
		int[] salida = calc.multiplica(array1, array2);
		
		assertEquals(result.length, salida.length);
		
		if(result.length == salida.length) {
			for(int i = 0; i < salida.length; i++) {
				assertEquals(result[i], salida[i]);
			}
		}
	}
}
