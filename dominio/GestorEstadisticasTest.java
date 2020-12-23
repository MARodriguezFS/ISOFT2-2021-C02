package dominio;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class GestorEstadisticasTest {
	
	private static GestorEstadisticas gestor;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gestor = new GestorEstadisticas();
	}
	
	@Test
	public void testTiempoComandas() throws Exception{
		double resultado = gestor.tiempoComandas();
		assertNotNull(resultado>=0);
	}
	
	@Test
	public void testGestorEstadisticas() {
		GestorEstadisticas gestorPrueba = new GestorEstadisticas();
		assertNotNull(gestorPrueba);
	}

	@Test
	public void testTiempoComida() throws Exception{
		double resultado = gestor.tiempoComida();
		assertNotNull(resultado>=0);
	}
	
	@Test
	public void testTiempoCuenta() throws Exception{
		double resultado = gestor.tiempoCuenta();
		assertNotNull(resultado>=0);
	}
	
	@Test
	public void testTiempoMesa() throws Exception{
		double resultado = gestor.tiempoMesa();
		assertNotNull(resultado>=0);
	}
}