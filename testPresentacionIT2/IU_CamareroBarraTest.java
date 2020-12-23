package presentacion;

import org.junit.BeforeClass;
import org.junit.Test;

public class IU_CamareroBarraTest {
		
		static IU_CamareroBarra interfaz;
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			IU_CamareroBarra interfaz = new IU_CamareroBarra();
		}
		
		@Test
		public void testInterfaz() throws Exception{
			String[] string= {"", ""};
			interfaz.main(string);
		}
}
