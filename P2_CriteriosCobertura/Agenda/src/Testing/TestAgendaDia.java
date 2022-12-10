package Testing;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import Agenda.DatoException;
import Agenda.Dia;
import Agenda.Cita;

import static org.junit.Assert.*;

//import AgendaBreak.DatoException;
//import AgendaBreak.Dia;
//import AgendaBreak.Cita;

@RunWith(JUnitParamsRunner.class)
public class TestAgendaDia {
	
	private static final Object[] getParametersGetCita() throws DatoException{
		int dia1_N = 10;
		Dia dia1 = new Dia(dia1_N);
		//Citas
		//11 am
		Cita citaHora11 = new Cita("Ir al gym", 2);
		dia1.asignarCita(11, citaHora11);
		//17 PM
		Cita citaHora17 = new Cita("Ir al dormir", 1);
		dia1.asignarCita(17, citaHora17);
		//9 am
		Cita citaHora9 = new Cita("Ir al cenar", 1);
		dia1.asignarCita(9, citaHora9);
		
		return new Object[] { //Dia //hora //Result
				new Object[] { dia1, 11, citaHora11},  //A3 //B1
				new Object[] { dia1, 10, null}, 	   //A3 //B2
				new Object[] { dia1, 8, null},	 	   //A1 //B1
				new Object[] { dia1, 9, citaHora9},	   //A2 //B1
				new Object[] { dia1, 17, citaHora17},  //A4 //B1
				new Object[] { dia1, 19, null},	       //A5 //B1
		};
	}
	
	private static final Object[] getParametersMuestraCita() throws DatoException{
		int dia1_N = 10;
		Dia dia1 = new Dia(dia1_N);
		//Citas
		//11 am
		Cita citaHora11 = new Cita("Ir al gym", 2);
		dia1.asignarCita(11, citaHora11);
		//17 PM
		Cita citaHora17 = new Cita("Ir a dormir", 1);
		dia1.asignarCita(17, citaHora17);
		//9 am
		Cita citaHora9 = new Cita("Ir a cenar", 1);
		dia1.asignarCita(9, citaHora9);
		
		return new Object[] { //Dia //hora //Result
				new Object[] { dia1, 11, "11:00 Ir al gym"},  //A3 //B1
				new Object[] { dia1, 10, "No existe"}, 	   //A3 //B2
				new Object[] { dia1, 8, "Hora no valida"},	 	   //A1 //B1
				new Object[] { dia1, 9, "9:00 Ir a cenar"},	   				//A2 //B1
				new Object[] { dia1, 17, "17:00 Ir a dormir"},  			//A4 //B1
				new Object[] { dia1, 19, "Hora no valida"},	       //A5 //B1
		};
	}
	
	private static final Object[] getParametersValidaHora() throws DatoException{
		int dia1_N = 10;
		Dia dia1 = new Dia(dia1_N);
		
		return new Object[] { //Dia //hora //Result
				new Object[] { dia1,6,false},  //A1
				new Object[] { dia1, 9,true},  //A2 
				new Object[] { dia1, 11,true}, //A3
				new Object[] { dia1, 17, true},//A4
				new Object[] { dia1, 19, false}//A5
				
		};
	}
	
	@Test
	@Parameters(method = "getParametersGetCita")
	public void testGetCita(Dia dia, int hora, Cita citaResult) throws DatoException{
		Cita cita = dia.getCita(hora);
		assertEquals((Cita)cita, (Cita)citaResult);
	}
	
	@Test
	@Parameters(method = "getParametersMuestraCita")
	public void testMuestraCita(Dia dia, int hora, String citaResult) throws DatoException{
		String cita = dia.muestraCita(hora);
		assertEquals(cita, citaResult);
	}
	@Test
	@Parameters(method = "getParametersValidaHora")
	public void testvalidaHora(Dia dia, int hora, boolean citaResult) throws DatoException{
		assertEquals(dia.validaHora(hora), citaResult);
	}	
}
