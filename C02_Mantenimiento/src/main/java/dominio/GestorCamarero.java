package dominio;
import persistencia.Camarero;

import java.util.LinkedList;

/**
 * Esta clase utiliza la clase Camarero para poder realizar sus funcionalidades.
 * 
 * @author Miguel Angel Rodriguez Fernandez de Simon
 * @version 0.1.0
 * @see "Camarero, EstadoMesas, CrearComanda"
 * @since 0.1.0
 */

public class GestorCamarero implements EstadosMesas{
	
	/**
	 * Constructor vacÃ­o para utilizar el gestor.
	 */
	public GestorCamarero() {
	}
	
	/**
	 * Este metodo devuelve una lista con todos los camareros.
	 * @return devuelve una lista de camareros
	 * @throws en caso de no funcinar devuelve una excepcion con el fallo
	 */
	public static LinkedList<Camarero> get_lista_camareros() throws Exception{
		return Camarero.get_lista_camareros();
	}
	
	public static boolean crearComanda(int idComanda, int primero, int segundo, int postre, int bebida, int entrantes, int idCamarero, int idMesa) throws Exception{
		boolean creada = false;
		creada = GestorComanda.crearComanda(idComanda, primero, segundo, postre, bebida, entrantes, idCamarero, idMesa);
		return creada;
	}
	
	public static boolean cambiarEstado(String estado, int idMesa) throws Exception{
		boolean cambio = false;
		cambio = GestorMesa.cambiarEstado(estado, idMesa);
		return cambio;
	}
	
	public static boolean prepararMesa(int idMesa) throws Exception{
		boolean cambio = false;
		cambio = GestorMesa.cambiarEstado("En preparacion", idMesa);
		return cambio;
	}
	
}