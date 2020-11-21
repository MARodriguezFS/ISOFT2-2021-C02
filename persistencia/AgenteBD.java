package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class AgenteBD implements BDConstantes {

	private static AgenteBD agenteBD;

	private AgenteBD(){

	}
	public String getCONNECTION_STRING(){
		return BDConstantes.CONNECTION_STRING;
	}
	public String getDBUSER(){
		return BDConstantes.DBUSER;
	}
	public String getDBPASS(){
		return BDConstantes.DBPASS;
	}
	public static Vector<Object> read(String SQL_Consulta,Vector<Object> aux,Vector<Object> vectoradevolver) throws Exception{
		
		Connection mBD = DriverManager.getConnection(BDConstantes.CONNECTION_STRING+"?user="+BDConstantes.DBUSER+"&password="+BDConstantes.DBPASS);	
		Statement stmt = mBD.createStatement();
		ResultSet res = stmt.executeQuery(SQL_Consulta);
		while (res.next()) {
			aux=new Vector<Object>();
			aux.add(res.getObject(1));
			aux.add(res.getObject(2));
			vectoradevolver.add(aux);
		}
		stmt.close();
		mBD.close();
		return vectoradevolver;
	}
	public static int insert(String accion) throws Exception{
		int i;
		Connection mBD = DriverManager.getConnection(BDConstantes.CONNECTION_STRING+"?user="+BDConstantes.DBUSER+"&password="+BDConstantes.DBPASS);
		PreparedStatement stmt = mBD.prepareStatement(accion);
		i=stmt.executeUpdate();
		stmt.close();
		mBD.close();
		return i;
	}

	public static int delete(String accion) throws Exception{
		int i;
		Connection mBD = DriverManager.getConnection(BDConstantes.CONNECTION_STRING+"?user="+BDConstantes.DBUSER+"&password="+BDConstantes.DBPASS);
		PreparedStatement stmt = mBD.prepareStatement(accion);
		i=stmt.executeUpdate();
		stmt.close();
		mBD.close();
		return i;
	}

	public static int cambiarPass(String accion) throws Exception{
		int i;
		Connection mBD = DriverManager.getConnection(BDConstantes.CONNECTION_STRING+"?user="+BDConstantes.DBUSER+"&password="+BDConstantes.DBPASS);
		PreparedStatement stmt = mBD.prepareStatement(accion);
		i=stmt.executeUpdate();
		stmt.close();
		mBD.close();
		return i;
	}
	
	public static AgenteBD getSingletonInstance() {
		if (agenteBD == null){
			agenteBD = new AgenteBD();
		}

		return agenteBD;
	}
}