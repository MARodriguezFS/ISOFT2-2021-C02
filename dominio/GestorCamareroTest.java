package dominio;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistencia.Camarero;
import persistencia.Comanda;

public class GestorCamareroTest {
	static GestorCamarero gestor;
	
	@BeforeClass
	public static void before() {
		GestorCamarero gestor= new GestorCamarero();
	}
	@Test
	public void testListaCamareros() throws Exception{
		LinkedList<Camarero> resultado= GestorCamarero.get_lista_camareros();
		assertNotNull(resultado);
	}

	@Test
	public void testCrearComanda() throws Exception{
		boolean resultado= GestorCamarero.crearComanda(2, 2, 4, 3, 2, 5, 6);
		assertEquals(true, resultado);
	}
	
	@Test
	public void testEstado() throws Exception {
		boolean resultado = GestorCamarero.cambiarEstado("RESERVADA", 2);
		assertEquals(true, resultado); 
	}
	
	@Test
	public void testMesa() throws Exception{
		boolean resultado= GestorCamarero.prepararMesa(1);
		assertEquals(true, resultado);
	}
}
