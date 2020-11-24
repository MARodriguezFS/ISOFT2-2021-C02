package dominio;
 /**
  * Esta clase se encarga de gestionar las funcionalidades que necesitan los gestores de sala, y de comunicarse con las clases necesarias.
  * @author Fernando Rodríguez Gallego y Miguel Ángel Rodríguez Fernández de Simón
  * @version 0.1.0
  * @see GestorMesa
  * @since 0.1.0
  */
public class GestorJefeSala {
	
	/**
	 * Constructor vacío.
	 */
	public GestorJefeSala() {
	}
	
	/**
	 * Este método llama al GestorMesa para poder asignar camareros y mesa.
	 * @param id_camarero
	 * @param id_mesa
	 * @throws Exception
	 */
	public static boolean asignar_camarero (int id_camarero, int id_mesa) throws Exception{
		boolean asignado = false;
		GestorMesa gm = new GestorMesa();
		if(gm.asignarCamarero(id_camarero, id_mesa)) {
			asignado = true;
		}
		return asignado;
	}
	
	/**
	 * Este método llama al GestorMesa para poder actualizar el estado de la mesa.
	 * @param id_mesa
	 * @param estado
	 */
	public static boolean cambiar_estado (int id_mesa, String estado) throws Exception{
		boolean cambiado = false;
		GestorMesa gm = new GestorMesa();
		if(gm.cambiarEstado(estado, id_mesa)) {
			cambiado = true;
		}
		return cambiado;
	}

}
