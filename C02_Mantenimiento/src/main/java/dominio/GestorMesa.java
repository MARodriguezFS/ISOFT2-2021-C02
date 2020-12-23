package dominio;

import java.util.LinkedList;

import persistencia.Mesa;

/**
 * Esta clase sirve como intermediaria entre GestorJefeSala y los objetos Mesa.
 * @author Fernando Rodriguez Gallego
 * @version 0.1.0
 * @see "EstadosMesas, Mesa"
 * @since 0.1.0
 */
public class GestorMesa implements EstadosMesas {
    public GestorMesa() {

    }

    /**
     * Esta clase crea un objeto mesa y realiza la accion de insertar mesa
     * @return devuelve un boolean al realizar la operacion.
     * @throws en caso de dar fallo devuelve el fallo obtenido.
     */
    public static boolean nuevaMesa() throws Exception{
        boolean insertado = false;
        Mesa m = new Mesa(LIBRE);
        if(m.insert() ==1)
            insertado = true;
        return insertado;        
    }
    /**
     * Esta clase crea un objeto mesa y realiza la accion de eliminar mesa
     * @param "id" es el parametro que necesita recibir el metodo.
     * @return devuelve un boolean al realizar la operacion.
     * @throws si falla devuelve el fallo obtenido.
     */
    public static boolean eliminarMesa(int id) throws Exception{
        boolean eliminado = false;
        Mesa m = new Mesa(id);
        if(m.delete() ==1)
            eliminado = true;
        return eliminado;        
    }
    /**
     * Esta clase crea un objeto mesa y realiza la accion de actualizar el estado de la mesa
     * @param "estado" primer parametro del metodo, el estado a cambiar.
     * @param "idMesa" segundo parametro del metodo, el id de la mesa.
     * @return devuelve un boolean cuando realiza la operacion.
     * @throws al fallar devuelve el fallo obtenido.
     */
    public static boolean cambiarEstado(String estado, int idMesa) throws Exception{
        boolean cambiado = false;
        Mesa m = new Mesa(idMesa);
        if(m.cambiarEstado(estado) ==1)
            cambiado = true;
        return cambiado;        
    }
    /**
     * Esta clase crea un objeto mesa y realiza la accion de actualizar el camarero asignado a la mesa
     * @param "idCamarero" primer parametro dle metodo, el id del camarero.
     * @param "idMesa" segundo parametro del metodo, el ide de la mesa.
     * @return devuelve un boolean al realizar la operacion.
     * @throws en caso de fallar devuelve el fallo obtenido.
     */
    public static boolean asignarCamarero(int idCamarero, int idMesa) throws Exception{
        boolean cambiado = false;
        Mesa m = new Mesa(idMesa);
        if(m.cambiarCamarero(idCamarero) ==1)
            cambiado = true;
        return cambiado;
    }
    /**
     * Realiza la acción de obtener la lista de mesas y devuelve una lista con todas las mesas
     * @return devuelve una lista de mesas.
     * @throws en caso de fallar devuelve el fallo obtenido
     */
    public static LinkedList<Mesa> getListaMesas() throws Exception{
        return Mesa.getListaMesas();
    }
}