package dominio;
 /**
  * Esta clase se encarga de gestionar las funcionalidades que necesitan los gestores de sala, y de comunicarse con las clases necesarias.
  * @version 0.1.0
  * @see "GestorMesa"
  * @since 0.1.0
  */
public class GestorJefeSala {
	
	/**
	 * Constructor vacío.
	 */
	public GestorJefeSala() {
	}
	
	/**
	 * Este metodo llama al GestorMesa para poder asignar camareros y mesa.
	 * @Param "id_camarero" el primer parametro del metodo es el id del camarero.
	 * @Param "id_mesa" el segundo parametro del metodo es el id de la mesa.
	 * @return devuelve un boolean al realizar la operacion.
	 * @throws en caso de dar fallo se devuelve el fallo obtenido.
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
	 * Este metodo llama al GestorMesa para poder actualizar el estado de la mesa.
	 * @param "id_mesa" el primer parametro del metodo es el id de la mesa.
	 * @param "estado" el segundo parametro del metodo es el estado a cambiar.
	 * @return devuelve un boolean al realizar la operacion.
	 * @throws en caso de fallo se devuelve el fallo obtenido.
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
