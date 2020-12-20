package dominio;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistencia.Comanda;
import persistencia.Reserva;

public class GestorReservasTest {

	static GestorReservas gestor;
	
	@BeforeClass
	public static void before() {
		GestorReservas gestor= new GestorReservas();
	}
	
	@Test
	public void testNuevaReserva() throws Exception{
		String pattern = "2020-12-14";
		DateTime fecha = new DateTime(pattern);
		Reserva r = new Reserva(6,2,fecha,"Mario");
		GestorReservas.nuevaReserva(8, 2, fecha, "Mario");
		assertNotNull(r);
		assertTrue(r.insert() == 1);
	}
	
	@Test
	public void testEliminarReserva()throws Exception{
		Reserva r = new Reserva(6);
		assertNotNull(r);
		assertTrue(r.delete() == 1);
	}
	
	@Test
	public void testListaReservas()throws Exception{
		LinkedList<Reserva> resultado= GestorReservas.getListaReservas();
		assertNotNull(resultado);
	}
	
	
}
