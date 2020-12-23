package Persistencia;

/**
 * Esta interfaz almacena las constantes que se utilizan para poder conectar con la BD.
 * 
 * @author Fernando Rodríguez Gallego y Miguel Ángel Rodríguez Fernández de Simón
 * @version 0.1.0
 * @since 0.1.0
 *
 */

public interface BDConstantes {
	final static String CONNECTION_STRING ="jdbc:mysql://172.20.48.70:3306/C02dbservice?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	final static String DBUSER ="C02";
	final static String DBPASS ="@ISoft2.2020#";
}