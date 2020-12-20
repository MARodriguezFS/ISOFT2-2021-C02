package dominio;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import persistencia.Comanda;
import persistencia.Mesa;

public class GestorMesaTest {

	static GestorReservas gestor;
	
	@BeforeClass
	public static void before() {
		GestorReservas gestor= new GestorReservas();
	}
	
	@Test
	public void testNuevaMesa() throws Exception{
		Mesa m = new Mesa(1);
		assertNotNull(m);
		assertTrue(m.insert() == 1);
	}
	
	@Test
	public void testEliminarMesa() throws Exception{
		Mesa m = new Mesa(8);
		assertNotNull(m);
		assertTrue(m.delete() == 1);
	}
	
	@Test
	public void testCambiarEstado() throws Exception{
		Mesa m = new Mesa(2);
		assertNotNull(m);
		assertTrue(m.cambiarEstado("LIBRE") == 1);
	}
	
	@Test
	public void testAsignarCamarero() throws Exception{
		Mesa m = new Mesa(2);
		assertNotNull(m);
		assertTrue(m.cambiarCamarero(3) == 1);
	}
	
	@Test
	public void testListaMesa() throws Exception{
		LinkedList<Mesa> resultado= GestorMesa.getListaMesas();
		assertNotNull(resultado);
	}

}
