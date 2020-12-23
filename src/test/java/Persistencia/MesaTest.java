package Persistencia;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;



public class MesaTest {

	@Test
	public void testConstrucGettersSetters() {
		int exp1 = 1,exp2 = 1;
		Mesa m = new Mesa(1,1,"LIBRE");
		Mesa m1 = new Mesa(1);
		Mesa m2 = new Mesa("LIBRE");
		Assert.assertNotNull(m);
		Assert.assertNotNull(m1);
		Assert.assertNotNull(m2);
		assertEquals(exp1, m.getmId());
		assertEquals(exp2, m.getmCamarero());
	}
	
	@Test
	public void testInsert() throws Exception {
		Mesa m = new Mesa(1,1,"LIBRE");
		assertEquals(1, m.insert());
	}
	
	@Test
	public void testDelete() throws Exception {
		Mesa m = new Mesa(1,1,"LIBRE");
		assertEquals(1, m.delete());
	}
	
	@Test
	public void testCambiarEstado() throws Exception {
		Mesa m = new Mesa(1,1,"LIBRE");
		assertEquals(1, m.cambiarEstado("RESERVADA"));
	
	}
	
	@Test
	public void testCambiarCamarero() throws Exception {
		Mesa m = new Mesa(1,1,"LIBRE");
		assertEquals(1, m.cambiarCamarero(2));
	}
	
	@Test
	public void testGetListaMesas() throws Exception {
		LinkedList<Mesa> listaMesas = new LinkedList<Mesa>();
		listaMesas = Mesa.getListaMesas();
		Assert.assertNotNull(listaMesas);
	}
}
