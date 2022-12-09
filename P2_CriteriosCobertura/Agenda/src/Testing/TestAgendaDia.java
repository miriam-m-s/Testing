package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

//import Agenda.DatoException;
//import Agenda.Dia;
//import Agenda.Cita;

import AgendaBreak.DatoException;
import AgendaBreak.Dia;
import AgendaBreak.Cita;

@RunWith(JUnitParamsRunner.class)
public class TestAgendaDia {
	
//	Dia dia1, dia2, dia3, dia4;
	
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
				new Object[] { dia1, 19, null},	       //A4 //B1
		};
	}
	
	@Test
	@Parameters(method = "getParametersGetCita")
	public void testGetCita(Dia dia, int hora, Cita citaResult) throws DatoException{
		Cita cita = dia.getCita(hora);
		assertEquals(cita, citaResult);
	}
	
	@Test
	@Parameters(method = "getParametersGetCita")
	public void testMuestraCita(Dia dia, int hora, Cita citaResult) throws DatoException{
		Cita cita = dia.getCita(hora);
		assertEquals(cita, citaResult);
	}
	
	
}
