package Persistencia;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class IngredientesTest {

	@Test
	public void testGetListaIngredientes() throws Exception {
		LinkedList<Ingredientes> listaIngredientes = new LinkedList<Ingredientes>();
		listaIngredientes = Ingredientes.get_lista_ingredientes();
		Assert.assertNotNull(listaIngredientes);
	}
	

}
