package Persistencia;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;



public class Reserva {
	private DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
	private int idReserva;
	private int idMesa;
	private int turno;
	private DateTime fecha;
	private String nombreCliente;
	
	public Reserva(int idReserva) {
		setIdReserva(idReserva);
	}
	
	public Reserva(int idReserva, int idMesa, int turno, Timestamp fechaAux, String nombreCliente) {
		super();
		DateTime fecha;
		String aux = "";
		setIdReserva(idReserva);
		setIdMesa(idMesa);
		setTurno(turno);
		aux = fechaAux.toString();
		aux = aux.substring(0, aux.length()-2);
		fecha = formatter.parseDateTime(aux);
		setFecha(fecha);
		setNombreCliente(nombreCliente);
	}
	public Reserva(int idMesa, int turno, DateTime fecha, String nombreCliente) {
		super();
		setIdMesa(idMesa);
		setTurno(turno);
		setFecha(fecha);
		setNombreCliente(nombreCliente);
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	public void setTurno(int turno) {
		this.turno = turno;
	}
	public void setFecha(DateTime fecha) {
		this.fecha = fecha;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public static LinkedList<Reserva> getListaReservas() throws Exception{
		AgenteBD agente = AgenteBD.getSingletonInstance();
		Reserva reserva = null;
		LinkedList<Reserva> listaReservas = new LinkedList<Reserva>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		LinkedList<Object> vectorADevolver=new LinkedList<Object>();
		String SQL_Consulta = "SELECT * FROM Reserva;";
		vectorADevolver = agente.read(SQL_Consulta,vectorADevolver, 5);
		for(int i =0;i<vectorADevolver.size();i+=5) {
			reserva = new Reserva((Integer) vectorADevolver.get(i), (Integer) vectorADevolver.get(i+1),(Integer) vectorADevolver.get(i+2),(Timestamp) vectorADevolver.get(i+3),(String) vectorADevolver.get(i+4));
			listaReservas.add(reserva);
		}
		return listaReservas;
	}

	public int insert() throws Exception{
		AgenteBD agente = AgenteBD.getSingletonInstance();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String consulta = "INSERT INTO Reserva (idMesa,turno,fecha,nombreCliente) VALUES('"+this.idMesa+"','" +this.turno+"','"+this.fecha+"','"+this.nombreCliente+"')";
		int res=agente.insert(consulta);
		return res;
	}
	
	public int delete() throws Exception{
		AgenteBD agente = AgenteBD.getSingletonInstance();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String consulta = ("DELETE FROM Reserva WHERE ('"+this.idReserva+"'=idReserva);");
		int res=agente.delete(consulta);
		return res;
	}

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", idMesa=" + idMesa + ", turno=" + turno + ", fecha=" + fecha.toString()
				+ ", nombreCliente=" + nombreCliente + "]";
	}

	public int getIdReserva() {
		return idReserva;
	}
	
	
}
