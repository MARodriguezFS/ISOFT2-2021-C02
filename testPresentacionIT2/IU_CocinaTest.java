package presentacion;

import org.junit.BeforeClass;
import org.junit.Test;

public class IU_CocinaTest {
		
		static IU_Cocina interfaz;
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			IU_Cocina interfaz = new IU_Cocina();
		}
		
		@Test
		public void testInterfaz() throws Exception{
			String[] string= {"", ""};
			interfaz.main(string);
		}
}
