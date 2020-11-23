package persistencia;

import java.util.LinkedList;

/**
 * Esta clase sirve de intermediario entre el GestorCamarero (que se encuentra en la capa de dominio), y el AgenteBD, que será el que se comunique con
 * la BD.
 * 
 * @author Miguel Ángel Rodríguez Fernández de Simón
 * @version 0.1.0
 * @see AgenteBD
 * @since 0.1.0
 */
public class Camarero {
	
	private String nombre;
	private int id;
	
	/**
	 * Constructor vacío para la creación del objeto por parte de GestorCamarero.
	 */
	public Camarero() {
	}
	
	/**
	 * Constructor utilizado para la creación de objetos camareros por parte de la propia clase, para su uso en distintas funcionalidades.
	 * @param id
	 * @param nombre
	 */
	public Camarero(int id, String nombre) {
		set_nombre(nombre);
		set_id(id);
	}
	
	/**
	 * Este método devuelve una lista con todos los camareros del local (con su id y su nombre).
	 * @return
	 * @throws Exception
	 */
	public static LinkedList<Camarero> get_lista_camareros() throws Exception{
		AgenteBD agente = AgenteBD.getSingletonInstance();
		String l,g;
		Camarero camarero = null;
		LinkedList<Object> aux = null;
		LinkedList<Camarero> lista_camareros = new LinkedList<Camarero>();
		Class.forName("com.mysql.cj.jdbc.Driver"); //.newInstance
		LinkedList<Object> vectoradevolver=new LinkedList<Object>();
		String SQL_Consulta = "SELECT idCamarero, Nombre FROM Camarero;";
		vectoradevolver = agente.read(SQL_Consulta,aux,vectoradevolver, 2);
		aux = new LinkedList<Object>();
		while (vectoradevolver.size() >= 1){
			aux = (LinkedList<Object>) vectoradevolver.poll();
			camarero = new Camarero((int) aux.get(0), (String) aux.get(1));
			lista_camareros.add(camarero);
		}
		return lista_camareros;
	}
	
	/**
	 * Este método permite cambiar el nombre de un camarero.
	 * @param nombre
	 */
	public void set_nombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Este método permite cambiar el id de un camarero.
	 * @param id
	 */
	public void set_id(int id) {
		this.id = id;
	}
	
	public int get_id() {
		return id;
	}
	public String toString() {
		return id + " " + nombre;
	}
}
