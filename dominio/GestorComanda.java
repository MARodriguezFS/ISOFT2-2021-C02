package dominio;

import java.util.LinkedList;

import persistencia.Comanda;
import persistencia.Mesa;

/**
 * Esta clase utiliza la clase Comanda para poder realizar sus funcionalidades.
 * 
 * @author Alejandro Ruiz Aranda y Jesús Santiyán Reviriego
 * @version 0.1.0
 * @see Comanda
 * @since 0.1.0
 */

public class GestorComanda {
	
	/**
	 * Constructor vacío para utilizar el gestor.
	 */
	
	public GestorComanda() {
	}
	
	public static boolean crearComanda(int primero, int segundo, int postre, int bebida, int entrantes, int idCamarero, int idMesa) throws Exception {
		boolean creada = false;
		Comanda c = new Comanda(primero, segundo, postre, bebida, entrantes,idCamarero,idMesa);
		if(c.insert() == 1)
			creada = true;
		return creada;
	}
	
	public static LinkedList<Comanda> getListaComandas() throws Exception{
        return Comanda.getListaComandas();
    }
	
	public double prepararCuenta(int idComanda) throws Exception{
		double cuenta = 0;
		Comanda c = new Comanda(idComanda);
		cuenta = c.cuenta();
		return cuenta;
	}
	
}
