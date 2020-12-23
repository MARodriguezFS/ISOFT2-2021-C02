package presentacion;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class IUConectarTest {

	static IUConectar interfaz;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		IUConectar interfaz = new IUConectar();
	}
	
	@Test
	public void testInterfaz() throws Exception{
		String[] string= {"", ""};
		interfaz.main(string);
	}

}
