package presentacion;

import org.junit.BeforeClass;
import org.junit.Test;

public class IU_SupervisorTest {
	
	static IU_Supervisor interfaz;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		interfaz = new IU_Supervisor();
	}
	
	@Test
	public void testInterfaz() throws Exception{
		String[] string= {"", ""};
		interfaz.main(string);
	}

}
