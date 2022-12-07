package Testing;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import Agenda.DatoException;

import Agenda.Dia;
import Agenda.Cita;


//import AgendaBreak.Dia;
//import AgendaBreak.Cita;

@RunWith(JUnitParamsRunner.class)
public class TestAgendaDia {
	
	private static final Object[] getParametersGetCita() {
		return new Object[] { //Dia //hora 
				new Object[] {1, 1}, 
		};
	}
	
	@Test
	@Parameters(method = "getParametersGetCita")
	public void testMessageSend(int diaN, int hora) throws DatoException{
		Dia dia = new Dia(diaN);
		
		
		Cita cita = dia.getCita(hora);
	}
}
