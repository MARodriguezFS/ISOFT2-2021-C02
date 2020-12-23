package Dominio;
/**
 * Esta interfaz se ha creado para poder almacenar los estados en los que pueden estar las mesas.
 * 
 * @author Miguel Ángel Rodríguez Fernández de Simón
 * @version 0.1.0
 * @since 0.1.0
 */

public interface EstadosMesas {
	public final static String LIBRE = "Libre";
	public final static String RESERVADA = "Reservada";
	public final static String OCUPADA = "Ocupada";
	public final static String PIDIENDO = "Pidiendo";
	public final static String ESPERANDO_COMIDA = "En espera de comida";
	public final static String SERVIDA = "Servidos";
	public final static String ESPERANDO_CUENTA = "Esperando la cuenta";
	public final static String PAGANDO = "Pagando";
	public final static String PREPARACION = "En preparación";
}
