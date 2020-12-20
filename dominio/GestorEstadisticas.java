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
	
	public long tiempoComandas() throws Exception{
		long tInicial = System.currentTimeMillis();
		Mesa mesa = new Mesa(1);
		int tFinal = mesa.consultarTiempoMedio(1);
		long tiempoFinal= tFinal- tInicial;
		return tiempoFinal;
	}
	
	public long tiempoComida() throws Exception{
		long tInicial = System.currentTimeMillis();
		Mesa mesa = new Mesa(1);
		int tFinal = mesa.consultarTiempoMedio(2);
		long tiempoFinal= tFinal- tInicial;
		return tiempoFinal;
	}
	
	public long tiempoCuenta() throws Exception{
		long tInicial = System.currentTimeMillis();
		Mesa mesa = new Mesa(1);
		int tFinal = mesa.consultarTiempoMedio(3);
		long tiempoFinal= tFinal- tInicial;
		return tiempoFinal;
	}
	
	public long tiempoMesa() throws Exception{
		long tInicial = System.currentTimeMillis();
		Mesa mesa = new Mesa(1);
		int tFinal = mesa.consultarTiempoMedio(4);
		long tiempoFinal= tFinal- tInicial;
		return tiempoFinal;
	}
	
}
