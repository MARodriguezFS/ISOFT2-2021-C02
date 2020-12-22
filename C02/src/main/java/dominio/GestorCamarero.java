package dominio;
import persistencia.Camarero;

import java.util.LinkedList;

/**
 * Esta clase utiliza la clase Camarero para poder realizar sus funcionalidades.
 * 
 * @author Miguel Ángel Rodríguez Fernández de Simón
 * @version 0.1.0
 * @see Camarero, EstadosMesas
 * @since 0.1.0
 */

public class GestorCamarero implements EstadosMesas{
	
	/**
	 * Constructor vacío para utilizar el gestor.
	 */
	public GestorCamarero() {
	}
	
	/**
	 * Este método devuelve una lista con todos los camareros.
	 * @return
	 * @throws Exception
	 */
	public static LinkedList<Camarero> get_lista_camareros() throws Exception{
		return Camarero.get_lista_camareros();
	}
}
