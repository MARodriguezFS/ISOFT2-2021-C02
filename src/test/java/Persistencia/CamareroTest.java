package Persistencia;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class CamareroTest {
	
	@Test
	public void testListaCamarero() throws Exception{
		LinkedList<Camarero> listaCamareros = new LinkedList<Camarero>();
		listaCamareros = Camarero.get_lista_camareros();
		Assert.assertNotNull(listaCamareros);
	}
	
	
	

}
