package dominio;

import java.util.LinkedList;

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

public class GestorComidas {

	/**
	 * Constructor vacío para utilizar el gestor.
	 */
	public GestorComidas() {
	}
	
	public static boolean comprobarIngredientes(Comanda c) throws Exception{
		Ingredientes ing = new Ingredientes();
		boolean disponible= true;
		if(c.getBebida() < ing.getBebidas()) disponible= false;
		if(c.getPrimero() < ing.getPrimeros()) disponible= false;
		if(c.getSegundo() < ing.getSegundos()) disponible= false;
		if(c.getPostre() < ing.getPostres()) disponible= false;
		if(c.getEntrantes() < ing.getEntrantes()) disponible= false;
		return disponible;
	}
	
	public static LinkedList<Ingredientes > getListaComidas() throws Exception{
        return Ingredientes.get_lista_ingredientes();
    }
	
	
	
}
