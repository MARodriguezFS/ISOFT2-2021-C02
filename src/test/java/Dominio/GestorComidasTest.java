package Dominio;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import Persistencia.Camarero;
import Persistencia.Comanda;
import Persistencia.Ingredientes;

public class GestorComidasTest {

	static GestorComidas gestor;
	
	@BeforeClass
	public static void before() {
		GestorComidas gestor= new GestorComidas();
	}
	
	@Test
	public void testListaCamareros() throws Exception{
		LinkedList<Ingredientes> resultado= GestorComidas.getListaComidas();
		assertNotNull(resultado);
	}
	
	@Test
	public void testComprobarIngredientes() throws Exception{
		Comanda c= new Comanda(1,4,6,2,6,1,3,1);
		boolean valido = GestorComidas.comprobarIngredientes(c);
		assertTrue(valido);
	}

}
