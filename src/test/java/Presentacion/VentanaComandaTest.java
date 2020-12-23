package Presentacion;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class VentanaComandaTest {

	static VentanaComanda interfaz;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		VentanaComanda interfaz = new VentanaComanda();
	}
	
	@Test
	public void testInterfaz() throws Exception{
		String[] string= {"", ""};
		interfaz.main(string);
	}
}
