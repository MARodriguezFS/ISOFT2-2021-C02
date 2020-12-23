package Dominio;
import Persistencia.Camarero;

import java.util.LinkedList;

/**
 * Esta clase utiliza la clase Camarero para poder realizar sus funcionalidades.
 * 
 * @author Miguel Ã�ngel RodrÃ­guez FernÃ¡ndez de SimÃ³n
 * @version 0.1.0
 * @see Camarero, EstadosMesas, CrearComanda
 * @since 0.1.0
 */

public class GestorCamarero implements EstadosMesas{
	
	/**
	 * Constructor vacÃ­o para utilizar el gestor.
	 */
	public GestorCamarero() {
	}
	
	/**
	 * Este mÃ©todo devuelve una lista con todos los camareros.
	 * @return
	 * @throws Exception
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
