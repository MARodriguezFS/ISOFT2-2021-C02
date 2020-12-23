package Dominio;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import Persistencia.Comanda;
import Persistencia.Ingredientes;

public class GestorCocinaTest {

	static GestorCocina gestor;
	
	@BeforeClass
	public static void before() {
		GestorCocina gestor= new GestorCocina();
	}
	
	@Test
	public void testComprobarIngredientes() throws Exception{
		Comanda c= new Comanda(1,4,6,2,6,1,3,1);
		int ingredientes = GestorCocina.calcularIngredientes(c);
		assertTrue(ingredientes<0);
	}
}
