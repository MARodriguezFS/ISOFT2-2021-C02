package presentacion;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class IU_CamareroTest {

	static IU_Camarero interfaz;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		IU_Camarero interfaz = new IU_Camarero();
	}
	
	@Test
	public void testInterfaz() throws Exception{
		String[] string= {"", ""};
		interfaz.main(string);
	}

}
