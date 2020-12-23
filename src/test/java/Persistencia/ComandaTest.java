package esi.ISOFT20_2021.C02;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import Persistencia.Comanda;
public class ComandaTest {

	
	@Test
	public void insert() throws Exception{
		Comanda comanda = new Comanda(1,3,5,2,3,5,2,7);
		int valido = comanda.insert();
		assertFalse(valido == 0);
	}
	
	@Test
	public void testGetListaComandas() throws Exception {
		LinkedList<Comanda> listaComanda = new LinkedList<Comanda>();
		listaComanda = Comanda.getListaComandas();
		Assert.assertNotNull(listaComanda);
	}	
	
	@Test
	public void testCuenta() throws Exception{
		double cuenta = 0;
		Comanda comanda = new Comanda(1,3,5,2,3,5,2,7);
		double valido = comanda.cuenta();
		assertNotNull(valido);
	}
	
	@Test
	public void testInsert() throws Exception{
		Comanda comanda = new Comanda(1,3,5,2,3,5,2,7);
		assertEquals(1,comanda.insert());
	}


}
