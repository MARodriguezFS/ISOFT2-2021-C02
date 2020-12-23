package Dominio;

import java.util.LinkedList;

import Persistencia.Mesa;

/**
 * Esta clase sirve como intermediaria entre GestorJefeSala y los objetos Mesa.
 * @author Fernando Rodríguez Gallego
 * @version 0.1.0
 * @see EstadosMesas, Mesa
 * @since 0.1.0
 */
public class GestorMesa implements EstadosMesas {
    public GestorMesa() {

    }

    /**
     * Esta clase crea un objeto mesa y realiza la accion de insertar mesa
     * @return
     * @throws Exception
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
     * @param id
     * @return
     * @throws Exception
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
     * @param estado
     * @param idMesa
     * @return
     * @throws Exception
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
     * @param idCamarero
     * @param idMesa
     * @return
     * @throws Exception
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
     * @return
     * @throws Exception
     */
    public static LinkedList<Mesa> getListaMesas() throws Exception{
        return Mesa.getListaMesas();
    }
}