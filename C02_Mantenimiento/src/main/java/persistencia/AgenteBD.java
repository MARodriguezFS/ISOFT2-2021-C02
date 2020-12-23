package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 * Esta clase es la encargada de comunicarse con la BD para enviar todas las sentencias SQL que necesite la aplicacion.
 * 
 * @version 0.1.0
 * @see "BDConstantes"
 * @since 0.1.0
 *
 */

public class AgenteBD implements BDConstantes {

	private static AgenteBD agenteBD;
	
	/**
	 * Constructor vacio.
	 */
	private AgenteBD(){

	}
	
	/**
	 * Este metodo permite recuperar el String de conexion de la BD.
	 * @return devuelve el string de la conexion
	 */
	public String getCONNECTION_STRING(){
		return BDConstantes.CONNECTION_STRING;
	}
	
	/**
	 * Este metodo permite recuperar el nombre de usuario de la BD.
	 * @return devuelve el nombre de usuario
	 */
	public String getDBUSER(){
		return BDConstantes.DBUSER;
	}
	
	/**
	 * Este metodo permite recuperar la contrasenya para acceder a la BD.
	 * @return devuelve la contraseña 
	 */
	public String getDBPASS(){
		return BDConstantes.DBPASS;
	}
	
	/**
	 * Este metodo se encarga de leer datos de la BD segun la consulta SQL que se le haya proporcionado, y en base al numero de variables que se requieran.
	 * @param "SQL_Consulta" el primer parametro del metodo es la consulta sql.
	 * @param "vectoradevolver" el segundo parametro del metodo es una lista de objetos.
	 * @param "numero_variables" el tercer parametro del metodo es el numero de variables a resolver.
	 * @return devuelve la lista de los objetos recogidos en la base de datos.
	 * @throws en caso de dar fallo devuelve el fallo obtenido.
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
	 * Este metodo permite insertar datos en la BD.
	 * @param "accion" es el prametro que necesita el metodo
	 * @return devuelve un int 0 o 1 segun realice la operacion
	 * @throws devuelve el fallo obtenido si falla la isercion.
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
	 * Este metodo permite borrar datos de la BD.
	 * @param "accion" es el unico parametro que necesita el metodo
	 * @return devuelve un int 0 o 1 segun realice la operacion
	 * @throws devuelve el fallo obtenido si falla la isercion.
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
	 * Este metodo permite actualizar la BD.
	 * @param "accion" es el unico parametro que necesita el metodo
	 * @return devuelve un int 0 o 1 segun realice la operacion.
	 * @throws devuelve el fallo obtenido si falla la isercion.
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
	 * Este metodo asegura que solo hay un agente en ejecucion, y sera el que llamen las clases que quieran acceder al Agente.
	 * @return devuelve una instancia del agente.
	 */
	public static AgenteBD getSingletonInstance() {
		if (agenteBD == null){
			agenteBD = new AgenteBD();
		}

		return agenteBD;
	}
}