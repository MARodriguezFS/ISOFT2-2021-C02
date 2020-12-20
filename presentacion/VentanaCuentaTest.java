package presentacion;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class VentanaCuentaTest {

static VentanaCuenta interfaz;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		VentanaCuenta interfaz = new VentanaCuenta();
	}
	
	@Test
	public void testInterfaz() throws Exception{
		String[] string= {"", ""};
		interfaz.main(string);
	}
}
