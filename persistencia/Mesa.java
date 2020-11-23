package persistencia;

import java.util.LinkedList;
/**
 * Esta clase sería la clase DAO y sirve como intermediario entre el agente y la clase GestorMesa
 * @author Fernando Rodríguez Gallego
 * @version 0.1.0
 * @see Mesa
 * @since 0.1.0
 */
public class Mesa {
	private int mId;
	private String mEstado;
	private int mIdCamarero;

	public Mesa(int id) {
		setmId(id);
	}

	public Mesa(String estado) {
		setmEstado(estado);
	}

	public Mesa(int id, int camarero, String estado) {
		super();
		setmId(id);
		setmEstado(estado);
		setmCamarero(camarero);
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public void setmEstado(String mEstado) {
		this.mEstado = mEstado;
	}

	public void setmCamarero(int mCamarero) {
		this.mIdCamarero = mCamarero;
	}
	
	/**
	 * Metodo para devolver una lista de todas las mesas en la base de datos
	 * @return
	 * @throws Exception
	 */
	public static LinkedList<Mesa> getListaMesas() throws Exception{
		AgenteBD agente = AgenteBD.getSingletonInstance();
		String l,g;
		Mesa mesa = null;
		LinkedList<Object> aux = null;
		LinkedList<Mesa> listaMesas = new LinkedList<Mesa>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		LinkedList<Object> vectoradevolver=new LinkedList<Object>();
		String SQL_Consulta = "SELECT * FROM Mesa;";
		vectoradevolver = agente.read(SQL_Consulta,aux,vectoradevolver, 3);
		aux = new LinkedList<Object>();
		while (vectoradevolver.size() >= 1){
			aux = (LinkedList<Object>) vectoradevolver.poll();
			mesa = new Mesa((int) aux.get(0), (int) aux.get(1),(String) aux.get(2));
			listaMesas.add(mesa);
		}
		return listaMesas;
	}

	/**
	 * Inserta una mesa en la base de datos
	 * @return
	 * @throws Exception
	 */
	public int insert() throws Exception{
		AgenteBD agente = AgenteBD.getSingletonInstance();
		Class.forName("com.mysql.jdbc.Driver");
		String consulta = "INSERT INTO Mesa VALUES('"+this.mEstado+"')";
		int res=agente.insert(consulta);
		return res;
	}
	/**
	 * Borra una mesa de la base de datos
	 * @return
	 * @throws Exception
	 */
	public int delete() throws Exception{
		AgenteBD agente = AgenteBD.getSingletonInstance();
		Class.forName("com.mysql.jdbc.Driver");
		String consulta = ("DELETE FROM Mesa WHERE ('"+this.mId+"'=id);");
		int res=agente.delete(consulta);
		return res;
	}
	/**
	 * Cambia el estado de la mesa por otro nuevo
	 * @param estado
	 * @return
	 * @throws Exception
	 */
	public int cambiarEstado(String estado) throws Exception{
		AgenteBD agente = AgenteBD.getSingletonInstance();
		Class.forName("com.mysql.jdbc.Driver");
		String consulta = ("UPDATE Mesa SET estado='"+estado+"' WHERE id='"+this.mId+"';");
		int res=AgenteBD.update(consulta);
		return res;
	}
	/**
	 * Actualiza el camarero asignado a una mesa
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int cambiarCamarero(int idCamarero) throws Exception{
		AgenteBD agente = AgenteBD.getSingletonInstance();
		Class.forName("com.mysql.jdbc.Driver");
		String consulta = ("UPDATE Mesa SET camarero='"+idCamarero+"' WHERE id='"+this.mId+"';");
		int res=AgenteBD.update(consulta);
		return res;
	}

	@Override
	public String toString() {
		return "Mesa " + mId + " || " + mEstado + " || " + mIdCamarero;
	}	
}
