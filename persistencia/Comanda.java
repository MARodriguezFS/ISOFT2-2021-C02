package persistencia;

import java.sql.Timestamp;
import java.util.LinkedList;

/**
 * Esta clase sería la clase DAO y sirve como intermediario entre el agente y la clase GestorComanda
 * @author Alejandro Ruiz Aranda y Jesús Santiyán Reviriego
 * @version 0.1.0
 * @see Comanda
 * @since 0.1.0
 */

public class Comanda {
	private int primero;
	private int segundo;
	private int postre;
	private int bebida;
	private int entrantes;
	private int idComanda;
	private int idCamarero;
	private int idMesa;
	
	public Comanda(int idComanda, int primero, int segundo, int postre, int bebida, int entrantes, int idCamarero, int idMesa) {
		setIdComanda(idComanda);
		setPrimero(primero);
		setSegundo(segundo);
		setPostre(postre);
		setBebida(bebida);
		setEntrantes(entrantes);
		setIdCamarero(idCamarero);
		setIdMesa(idMesa);
	}
	
	public Comanda(int primero, int segundo, int postre, int bebida, int entrantes, int idCamarero, int idMesa) {
		setPrimero(primero);
		setSegundo(segundo);
		setPostre(postre);
		setBebida(bebida);
		setEntrantes(entrantes);
		setIdCamarero(idCamarero);
		setIdMesa(idMesa);
	}
	
	public Comanda(int idComanda) {
		setIdComanda(idComanda);
	}
	
	/**
	 * Inserta una comanda en la base de datos
	 * @return
	 * @throws Exception
	 */

	public int insert() throws Exception {
		AgenteBD agente = AgenteBD.getSingletonInstance();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String consulta = "INSERT INTO Comanda (primero,segundo,postre,bebida,entrante,idCamarero,idMesa) VALUES('" +this.primero+"','"+this.segundo+"','"+this.postre+"','"+this.bebida+"','"+this.entrantes+"','"+this.idCamarero+"','"+this.idMesa+"')";
		int res = agente.insert(consulta);
		return res;
	}
	
	public static LinkedList<Comanda> getListaComandas() throws Exception{
		AgenteBD agente = AgenteBD.getSingletonInstance();
		Comanda comanda = null;
		LinkedList<Comanda> listaComandas = new LinkedList<Comanda>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		LinkedList<Object> vectorADevolver=new LinkedList<Object>();
		String SQL_Consulta = "SELECT * FROM Comanda;";
		vectorADevolver = agente.read(SQL_Consulta,vectorADevolver, 8);
		for(int i =0;i<vectorADevolver.size();i+=8) {
			comanda = new Comanda((Integer) vectorADevolver.get(i), (Integer) vectorADevolver.get(i+1),(Integer) vectorADevolver.get(i+2),
					(Integer) vectorADevolver.get(i+3),(Integer) vectorADevolver.get(i+4),(Integer) vectorADevolver.get(i+5),(Integer) vectorADevolver.get(i+6), (Integer) vectorADevolver.get(i+7));
			listaComandas.add(comanda);
		}
		return listaComandas;
	}
	
	public double cuenta() throws Exception{
		double cuenta = 0;
		AgenteBD agente = AgenteBD.getSingletonInstance();
		Class.forName("com.mysql.cj.jdbc.Driver");
		LinkedList<Object> vectorADevolver = new LinkedList<Object>();
		String precioBebida = "SELECT precio FROM Bebida WHERE idBebida=(SELECT bebida FROM Comanda WHERE idComanda="+this.idComanda+");";
		vectorADevolver = agente.read(precioBebida,vectorADevolver,1);
		String precioPrimero = "SELECT precio FROM Comida WHERE idComida=(SELECT primero FROM Comanda WHERE idComanda="+this.idComanda+");";
		vectorADevolver = agente.read(precioPrimero,vectorADevolver,1);
		String precioSegundo = "SELECT precio FROM Comida WHERE idComida=(SELECT segundo FROM Comanda WHERE idComanda="+this.idComanda+");";
		vectorADevolver = agente.read(precioSegundo,vectorADevolver,1);
		for(int i = 0; i < vectorADevolver.size(); i+=3) {
			cuenta = (Double) vectorADevolver.get(i) + (Double) vectorADevolver.get(i+1) + (Double) vectorADevolver.get(i+2);
		}
		return cuenta;
	}
	
	public int getIdCamarero() {
		return idCamarero;
	}

	public void setIdCamarero(int idCamarero) {
		this.idCamarero = idCamarero;
	}

	public int getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}

	public int getPrimero() {
		return primero;
	}

	public void setPrimero(int primero) {
		this.primero = primero;
	}

	public int getSegundo() {
		return segundo;
	}

	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}

	public int getPostre() {
		return postre;
	}

	public void setPostre(int postre) {
		this.postre = postre;
	}

	public int getBebida() {
		return bebida;
	}

	public void setBebida(int bebida) {
		this.bebida = bebida;
	}

	public int getEntrantes() {
		return entrantes;
	}

	public void setEntrantes(int entrantes) {
		this.entrantes = entrantes;
	}

	public int getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}
	
	@Override
	public String toString() {
		return "Comanda: " + idComanda + ", primero: " + primero + ", segundo: " + segundo + ", postre: " + postre + " bebida: " + bebida 
				+ " entrantes: " + entrantes + " camarero: " + idCamarero + " mesa: " + idMesa;
	}
	
}
