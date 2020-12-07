package dominio;

import persistencia.Comanda;

/**
 * Esta clase utiliza la clase Comanda para poder realizar sus funcionalidades.
 * 
 * @author Alejandro Ruiz Aranda y Jes�s Santiy�n Reviriego
 * @version 0.1.0
 * @see Comanda
 * @since 0.1.0
 */

public class GestorComanda {
	
	/**
	 * Constructor vac�o para utilizar el gestor.
	 */
	
	public GestorComanda() {
	}
	
	public static boolean crearComanda(int idComanda, int primero, int segundo, int postre, int bebida, int entrantes, int idCamarero, int idMesa) throws Exception {
		boolean creada = false;
		Comanda c = new Comanda(idComanda, primero, segundo, postre, bebida, entrantes,idCamarero,idMesa);
		if(c.insert() == 1)
			creada = true;
		return creada;
	}
	
}