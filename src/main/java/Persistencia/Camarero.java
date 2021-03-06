package Persistencia;

import java.util.LinkedList;

/**
 * Esta clase sirve de intermediario entre el GestorCamarero (que se encuentra en la capa de dominio), y el AgenteBD, que serÃ¡ el que se comunique con
 * la BD.
 * 
 * @author Miguel Ã�ngel RodrÃ­guez FernÃ¡ndez de SimÃ³n
 * @version 0.1.0
 * @see AgenteBD
 * @since 0.1.0
 */
public class Camarero {
	
	private String nombre;
	private int id;
	
	/**
	 * Constructor vacÃ­o para la creaciÃ³n del objeto por parte de GestorCamarero.
	 */
	public Camarero() {
	}
	
	/**
	 * Constructor utilizado para la creaciÃ³n de objetos camareros por parte de la propia clase, para su uso en distintas funcionalidades.
	 * @param id
	 * @param nombre
	 */
	public Camarero(int id, String nombre) {
		set_nombre(nombre);
		set_id(id);
	}

	/**
	 * Este mÃ©todo devuelve una lista con todos los camareros del local (con su id y su nombre).
	 * @return
	 * @throws Exception
	 */
	public static LinkedList<Camarero> get_lista_camareros() throws Exception{
		AgenteBD agente = AgenteBD.getSingletonInstance();
		Camarero camarero = null;
		//LinkedList<Object> aux = null;
		LinkedList<Camarero> lista_camareros = new LinkedList<Camarero>();
		Class.forName("com.mysql.cj.jdbc.Driver"); //.newInstance
		LinkedList<Object> vectorADevolver=new LinkedList<Object>();
		String SQL_Consulta = "SELECT * FROM Camarero;";
		vectorADevolver = agente.read(SQL_Consulta,vectorADevolver, 2);
		for(int i =0;i<vectorADevolver.size();i+=2) {
		camarero = new Camarero((Integer) vectorADevolver.get(i), (String)vectorADevolver.get(i+1));
		lista_camareros.add(camarero);
		}
		return lista_camareros;
		}
	
	/**
	 * Este mÃ©todo permite cambiar el nombre de un camarero.
	 * @param nombre
	 */
	public void set_nombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Este mÃ©todo permite cambiar el id de un camarero.
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
