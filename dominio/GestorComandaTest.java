package dominio;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

import persistencia.Comanda;

public class GestorComandaTest {

	static GestorReservas gestor;
	
	@BeforeClass
	public static void before() {
		GestorReservas gestor= new GestorReservas();
	}
	@Test
	public void testComanda() throws Exception{
		boolean resultado = GestorComanda.crearComanda(3, 2, 4, 3, 5, 6, 2);
		Comanda c= new Comanda(3, 2, 4, 3, 5, 6, 2);
		assertEquals(true, resultado);
		assertTrue(c.insert() == 1);
	}

	@Test
	public void testListaComandas() throws Exception{
		LinkedList<Comanda> resultado= GestorComanda.getListaComandas();
		assertNotNull(resultado);
	}

	@Test
	public void testPrepararCuenta() throws Exception{
		double cuenta=0;
		Comanda c = new Comanda(1);
		assertNotNull(c);
		assertTrue(c.cuenta() > 0);
	}
	
	
	
	
}
