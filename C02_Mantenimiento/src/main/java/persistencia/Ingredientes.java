package persistencia;

import java.util.LinkedList;

public class Ingredientes {

	int entrantes;
	int primeros;
	int segundos;
	int postres;
	int bebidas;
	

	public Ingredientes() {
		
	}
	

	/**
	 * Constructor utilizado para la creacion de objetos ingredientes por parte de la propia clase, para su uso en distintas funcionalidades.
	 * @param "entrantes" es el primer atributo del constructor. 
	 * @param "primeros" es el segundo atributo del constructor.
	 * @param "segundos" es el tercer atributo del constructor.
	 * @param "postres" es el cuarto atributo del constructor. 
	 * @para "bebidas" es el quinto atributo del constructor.
	 */
	public Ingredientes(int entrantes, int primeros, int segundos, int postres, int bebidas) {
		super();
		this.entrantes = entrantes;
		this.primeros = primeros;
		this.segundos = segundos;
		this.postres = postres;
		this.bebidas = bebidas;
	}

	public static LinkedList<Ingredientes> get_lista_ingredientes() throws Exception{
		AgenteBD agente = AgenteBD.getSingletonInstance();
		Ingredientes ingrediente = null;
		LinkedList<Ingredientes> lista_ingredientes = new LinkedList<Ingredientes>();
		Class.forName("com.mysql.cj.jdbc.Driver"); //.newInstance
		LinkedList<Object> vectorADevolver=new LinkedList<Object>();
		String SQL_Consulta = "SELECT * FROM Camarero;";
		vectorADevolver = agente.read(SQL_Consulta,vectorADevolver, 2);
		for(int i =0;i<vectorADevolver.size();i+=2) {
		ingrediente = new Ingredientes((Integer) vectorADevolver.get(i),(Integer) vectorADevolver.get(i),(Integer) vectorADevolver.get(i),
				(Integer) vectorADevolver.get(i),(Integer) vectorADevolver.get(i));
		lista_ingredientes.add(ingrediente);
		}
		return lista_ingredientes;
	}
	
	public int getEntrantes() {
		return entrantes;
	}

	public void setEntrantes(int entrantes) {
		this.entrantes = entrantes;
	}

	public int getPrimeros() {
		return primeros;
	}

	public void setPrimeros(int primeros) {
		this.primeros = primeros;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public int getPostres() {
		return postres;
	}

	public void setPostres(int postres) {
		this.postres = postres;
	}

	public int getBebidas() {
		return bebidas;
	}

	public void setBebidas(int bebidas) {
		this.bebidas = bebidas;
	}

	
	public String toString() {
		return String.valueOf(entrantes) + String.valueOf(primeros) +String.valueOf(segundos) +String.valueOf(postres)
		+ String.valueOf(bebidas);
	}
	
	
}
