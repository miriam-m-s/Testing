package Testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import Agenda.DatoException;
import Agenda.Dia;
import Agenda.Cita;
import Agenda.Semana;


//import AgendaBreak.DatoException;
//import AgendaBreak.Dia;
//import AgendaBreak.Cita;
//import AgendaBreak.Semana;

@RunWith(JUnitParamsRunner.class)
public class TestAgendaSemana {
	Semana semana1, semana2;
	
	@Test
	public void testGetMostrarCita() throws DatoException {
		semana2 = new Semana(2);
		
		//A3 B3 C1
		int diaSemana = 2;
		Dia dia = semana2.getDia(diaSemana);
		dia.asignarCita(10, new Cita("Desayunar", 1));
		
		String citaS = semana2.mostrarCita(10, diaSemana);
		String result = "10:00 Desayunar";
		assertEquals(citaS, result);
		
		//A3 B3 C2
		diaSemana = 5;
		dia = semana2.getDia(diaSemana);
		
		citaS = semana2.mostrarCita(10, diaSemana);
		result = "No existe";
		assertEquals(citaS, result);
		
		//A1 B3 C1
		diaSemana = 0;
		citaS = semana2.mostrarCita(10, diaSemana);
		result = "Dia no valido";
		assertEquals(citaS, result);
		
		//A2 B3 C1
		diaSemana = 1;
		
		dia = semana2.getDia(diaSemana);
		dia.asignarCita(10, new Cita("Desayunar", 1));
		
		citaS = semana2.mostrarCita(10, diaSemana);
		result = "10:00 Desayunar";
		assertEquals(citaS, result);
		
		//A4 B3 C1
		diaSemana = 5;
		
		dia = semana2.getDia(diaSemana);
		dia.asignarCita(10, new Cita("Desayunar", 1));
		
		citaS = semana2.mostrarCita(10, diaSemana);
		result = "10:00 Desayunar";
		assertEquals(citaS, result);
		
		//A5 B3 C1
		diaSemana = 6;
		
		citaS = semana2.mostrarCita(10, diaSemana);
		result = "Dia no valido";
		assertEquals(citaS, result);
		
		//A3 B1 C1
		diaSemana = 2;
		citaS = semana2.mostrarCita(8, diaSemana);
		result = "Hora no valida";
		assertEquals(citaS, result);
		
		//A3 B2 C1
		diaSemana = 2;
		
		dia = semana2.getDia(diaSemana);
		dia.asignarCita(9, new Cita("Deporte", 1));
		
		citaS = semana2.mostrarCita(9, diaSemana);
		result = "9:00 Deporte";
		assertEquals(citaS, result);
		
		//A3 B2 C1
		diaSemana = 2;
		
		dia = semana2.getDia(diaSemana);
		dia.asignarCita(17, new Cita("Merendar", 1));
		
		citaS = semana2.mostrarCita(17, diaSemana);
		result = "17:00 Merendar";
		assertEquals(citaS, result);
		
		//A3 B2 C1
		diaSemana = 2;
		citaS = semana2.mostrarCita(18, diaSemana);
		result = "Hora no valida";
		assertEquals(citaS, result);
	}

	@Test
	public void testGetDia() throws DatoException {
		semana1 = new Semana(1);
		semana2 = new Semana(2);
		
		//A3 B1
		Dia dia = semana2.getDia(2);
		assertEquals(dia.getDiaNumero(), 5);
		
		//A3 B2
		dia = semana1.getDia(1);
		assertNull(dia);
		
		//A1 B1
		dia = semana1.getDia(0);
		assertNull(dia);
		
		//A2 B1
		dia = semana2.getDia(1);
		assertEquals(dia.getDiaNumero(), 4);
		
		//A4 B1
		dia = semana1.getDia(5);
		assertEquals(dia.getDiaNumero(), 1);
		
		//A5 B1
		dia = semana1.getDia(6);
		assertNull(dia);
	}
}
