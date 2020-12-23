package dominio;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistencia.Camarero;

public class GestorCamareroTest {
	
	static GestorCamarero gestor;
	private String estado;
	static GestorMesa gestorMesa;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		GestorCamarero gestor = new GestorCamarero();
		gestorMesa = new GestorMesa();
	}
	
	@AfterClass
	public static void afterClass() throws Exception{
		gestorMesa.cambiarEstado("Libre", 1);
	}
	
	@Test
	public void testCrearComandaCorrecto() throws Exception{
		boolean creada = gestor.crearComanda(1, 2, 1, 1, 1, 1, 1);
		assertTrue(creada);
	}
	
	@Test
	public void testGestorCamarero() {
		GestorCamarero gestorPrueba = new GestorCamarero();
		assertNotNull(gestorPrueba);
	}

	@Test
	public void testGetListaCamareros() throws Exception{
		LinkedList<Camarero> lista = gestor.get_lista_camareros();
		assertNotNull(lista);
	}
	
	@Test
	public void testPrepararMesaIncorrecta() throws Exception{
		boolean exito = gestor.prepararMesa(3000);
		assertFalse(exito);
	}
	
	@Test
	public void testPrepararMesa() throws Exception{
		boolean exito = gestor.prepararMesa(1);
		assertTrue(exito);
	}
}
