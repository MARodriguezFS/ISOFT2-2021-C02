package persistencia;

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
	private int cId;
	private int idCamarero;
	private int idMesa;
	
	public Comanda(int cId, int primero, int segundo, int postre, int bebida, int entrantes, int idCamarero, int idMesa) {
		setcId(cId);
		setPrimero(primero);
		setSegundo(segundo);
		setPostre(postre);
		setBebida(bebida);
		setEntrantes(entrantes);
		setIdCamarero(idCamarero);
		setIdMesa(idMesa);
	}
	
	/**
	 * Inserta una comanda en la base de datos
	 * @return
	 * @throws Exception
	 */

	public int insert() throws Exception {
		AgenteBD agente = AgenteBD.getSingletonInstance();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String consulta = "INSERT INTO Comanda (cId,primero,segundo,postre,bebida,entrantes) VALUES('"+this.cId+"','" +this.primero+"','"+this.segundo+"','"+this.postre+"','"+this.bebida+"','"+this.entrantes+"','"+this.idCamarero+"','"+this.idMesa+"')";
		int res = agente.insert(consulta);
		return res;
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

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}
	
	@Override
	public String toString() {
		return "Comanda: " + cId + ", primero: " + primero + ", segundo: " + segundo + ", postre: " + postre + " bebida: " + bebida + " entrantes: " + entrantes;
	}
	
}
