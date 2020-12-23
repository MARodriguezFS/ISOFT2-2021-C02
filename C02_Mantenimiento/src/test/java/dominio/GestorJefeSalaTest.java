package dominio;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class GestorJefeSalaTest {

	static GestorReservas gestor;
	
	@BeforeClass
	public static void before() {
		GestorReservas gestor= new GestorReservas();
	}
	@Test
	public void testAsignarCamarero() throws Exception{
		boolean resultado = GestorJefeSala.asignar_camarero(1, 4);
		assertTrue(resultado);
	}
	
	@Test
	public void testCambiarEstado() throws Exception{
		boolean resultado = GestorJefeSala.cambiar_estado(1, "LIBRE");
		assertTrue(resultado);
	}
	
	
}
