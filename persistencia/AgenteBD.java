package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 * Esta clase es la encargada de comunicarse con la BD para enviar todas las sentencias SQL que necesite la aplicación.
 * 
 * @author Fernando Rodríguez Gallego y Miguel Ángel Rodríguez Fernández de Simón
 * @version 0.1.0
 * @see BDConstantes
 * @since 0.1.0
 *
 */

public class AgenteBD implements BDConstantes {

	private static AgenteBD agenteBD;
	
	/**
	 * Constructor vacío.
	 */
	private AgenteBD(){

	}
	
	/**
	 * Este método permite recuperar el String de conexión de la BD.
	 * @return
	 */
	public String getCONNECTION_STRING(){
		return BDConstantes.CONNECTION_STRING;
	}
	
	/**
	 * Este método permite recuperar el nombre de usuario de la BD.
	 * @return
	 */
	public String getDBUSER(){
		return BDConstantes.DBUSER;
	}
	
	/**
	 * Este método permite recuperar la contraseña para acceder a la BD.
	 * @return
	 */
	public String getDBPASS(){
		return BDConstantes.DBPASS;
	}
	
	/**
	 * Este método se encarga de leer datos de la BD según la consulta SQL que se le haya proporcionado, y en base al número de variables que se requieran.
	 * @param SQL_Consulta
	 * @param aux
	 * @param vectoradevolver
	 * @param numero_variables
	 * @return
	 * @throws Exception
	 */
	public static LinkedList<Object> read(String SQL_Consulta,LinkedList<Object> vectoradevolver, int numero_variables) throws Exception{
		
		Connection mBD = DriverManager.getConnection(BDConstantes.CONNECTION_STRING,BDConstantes.DBUSER,BDConstantes.DBPASS);	
		Statement stmt = mBD.createStatement();
		ResultSet res = stmt.executeQuery(SQL_Consulta);
		while (res.next()) {
			for (int i=1; i<=numero_variables; i++) {
				vectoradevolver.add(res.getObject(i));
			}
		}
		stmt.close();
		mBD.close();
		return vectoradevolver;
	}
	
	/**
	 * Este método permite insertar datos en la BD.
	 * @param accion
	 * @return
	 * @throws Exception
	 */
	public static int insert(String accion) throws Exception{
		int i;
		Connection mBD = DriverManager.getConnection(BDConstantes.CONNECTION_STRING,BDConstantes.DBUSER,BDConstantes.DBPASS);
		PreparedStatement stmt = mBD.prepareStatement(accion);
		i=stmt.executeUpdate();
		stmt.close();
		mBD.close();
		return i;
	}

	/**
	 * Este método permite borrar datos de la BD.
	 * @param accion
	 * @return
	 * @throws Exception
	 */
	public static int delete(String accion) throws Exception{
		int i;
		Connection mBD = DriverManager.getConnection(BDConstantes.CONNECTION_STRING,BDConstantes.DBUSER,BDConstantes.DBPASS);
		PreparedStatement stmt = mBD.prepareStatement(accion);
		i=stmt.executeUpdate();
		stmt.close();
		mBD.close();
		return i;
	}

	/**
	 * Este método permite actualizar la BD.
	 * @param accion
	 * @return
	 * @throws Exception
	 */
	public static int update(String accion) throws Exception{
		int i;
		Connection mBD = DriverManager.getConnection(BDConstantes.CONNECTION_STRING,BDConstantes.DBUSER,BDConstantes.DBPASS);
		PreparedStatement stmt = mBD.prepareStatement(accion);
		i=stmt.executeUpdate();
		stmt.close();
		mBD.close();
		return i;
	}
	
	/**
	 * Este método asegura que sólo hay un agente en ejecución, y será el que llamen las clases que quieran acceder al Agente.
	 * @return
	 */
	public static AgenteBD getSingletonInstance() {
		if (agenteBD == null){
			agenteBD = new AgenteBD();
		}

		return agenteBD;
	}
}