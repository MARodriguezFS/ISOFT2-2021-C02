package dominio;

import java.util.LinkedList;

import org.joda.time.DateTime;

import persistencia.Reserva;

public class GestorReservas {

	public GestorReservas() {

	}
	
	public static boolean nuevaReserva(int idMesa, int turno, DateTime fecha, String nombreCliente) throws Exception{
		boolean insertado = false;
		Reserva r = new Reserva(idMesa,turno,fecha,nombreCliente);
		if(r.insert() ==1)
			insertado = true;
		return insertado;        
	}
	
	public static boolean eliminarReserva(int idReserva) throws Exception{
        boolean eliminado = false;
        Reserva r = new Reserva(idReserva);
        if(r.delete() ==1)
            eliminado = true;
        return eliminado;        
    }
	
	public static LinkedList<Reserva> getListaReservas() throws Exception{
        return Reserva.getListaReservas();
    }
}
