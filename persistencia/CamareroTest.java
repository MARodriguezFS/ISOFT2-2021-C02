package persistencia;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class CamareroTest {
	
	@Test
	public void testListaCamarero() throws Exception{
		LinkedList<Camarero> lista_camareros = new LinkedList<Camarero>();
		Camarero c= new Camarero(1,"Carlos");
		lista_camareros.add(c);
	}
	
	

}
