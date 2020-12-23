package persistencia;

import java.util.LinkedList;

/**
 * Esta clase sirve de intermediario entre el GestorCamarero (que se encuentra en la capa de dominio), y el AgenteBD, que sera el que se comunique con
 * la BD.
 * 
 * @author Miguel Angel RodrÃ­guez Fernandez de Simon
 * @version 0.1.0
 * @see "AgenteBD"
 * @since 0.1.0
 */
public class Camarero {
	
	private String nombre;
	private int id;
	
	/**
	 * Constructor vacio para la creacion del objeto por parte de GestorCamarero.
	 */
	public Camarero() {
	}
	
	/**
	 * Constructor utilizado para la creacion de objetos camareros por parte de la propia clase, para su uso en distintas funcionalidades.
	 * @param "id" es el primer atributo del contructor, el id del camarero.
	 * @param "nombre" es el segundo atributo del constructor, el nombre del camarero.
	 */
	public Camarero(int id, String nombre) {
		set_nombre(nombre);
		set_id(id);
	}

	/**
	 * Este metodo devuelve una lista con todos los camareros del local (con su id y su nombre).
	 * @return devuelve una lista de camareros
	 * @throws en caso de no hacer bien la operacion se devuelve el fallo
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
	 * Este metodo permite cambiar el nombre de un camarero.
	 * @param "nombre" el unico parametro de este metodo es el nombre del camarero
	 */
	public void set_nombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Este metodo permite cambiar el id de un camarero.
	 * @param "id" el unico paramatreo de este metodo es el id del camarero.
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
