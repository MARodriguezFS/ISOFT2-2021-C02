package dominio;

import java.util.LinkedList;

import persistencia.AgenteBD;
import persistencia.Mesa;

public class GestorEstadisticas {

	/**
	* Constructor vacío para utilizar el gestor.
	*/
	public GestorEstadisticas() {
	}
	
	public double tiempoComandas() throws Exception{
		Mesa mesa = new Mesa(1);
		return mesa.consultarTiempoMedio(1);
	}
	
	public double tiempoComida() throws Exception{
		Mesa mesa = new Mesa(1);
		return mesa.consultarTiempoMedio(2);
	}
	
	public double tiempoCuenta() throws Exception{
		Mesa mesa = new Mesa(1);
		return mesa.consultarTiempoMedio(3);
	}
	
	public double tiempoMesa() throws Exception{
		Mesa mesa = new Mesa(1);
		return mesa.consultarTiempoMedio(4);
	}
	
}
