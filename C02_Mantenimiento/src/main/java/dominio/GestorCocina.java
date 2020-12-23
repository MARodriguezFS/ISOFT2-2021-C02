package dominio;

import persistencia.Comanda;
import persistencia.Comanda;
import persistencia.Ingredientes;
/**
 * Esta clase utiliza la clase Ingredientes para poder realizar sus funcionalidades.
 * 
 * @author Mario Perez Galan y Mario Ramos Esquinas
 * @version 0.1.0
 * @see Comanda
 * @since 0.1.0
 */
public class GestorCocina {

	/**
	 * Constructor vacío para utilizar el gestor.
	 */
	public GestorCocina() {	
	}
	
	public static int calcularIngredientes(Comanda c) {
		int ingredientes = c.getBebida() + c.getEntrantes() + c.getPostre() + c.getPrimero() + c.getSegundo();
		return ingredientes;
	}
	
	
	
}

