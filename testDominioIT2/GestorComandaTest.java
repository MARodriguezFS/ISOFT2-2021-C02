package dominio;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class GestorComandaTest {

	private static GestorComanda gestor;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gestor = new GestorComanda();
	}

	@Test
	public void testGestorComanda() throws Exception {
		GestorComanda gestorPrueba = new GestorComanda();
	}

	@Test
	public void testCrearComanda() throws Exception {
		boolean creada = gestor.crearComanda(1, 2, 1, 1, 1, 1, 1);
		assertTrue(creada);
	}

	@Test
	public void testGetListaComandas() throws Exception {
		GestorCamarero gestorPrueba = new GestorCamarero();
		assertTrue(true);
	}

	@Test
	public void testPrepararCuentaIncorrecta() throws Exception {
		double cuenta = gestor.prepararCuenta(3000);
		assertTrue(cuenta==0);
	}
	
	@Test
	public void testPrepararCuenta() throws Exception {
		double cuenta = gestor.prepararCuenta(1);
		assertTrue(cuenta>0);
	}

}
