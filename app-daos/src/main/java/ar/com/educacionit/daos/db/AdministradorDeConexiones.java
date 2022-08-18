package ar.com.educacionit.daos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ar.com.educacionit.daos.db.exceptions.GenericException;

public class AdministradorDeConexiones {

	public static Connection obtenerConexion() throws GenericException {
		/*String host = "localhost";
		String user = "root";
		String password = "root";
		String dbName = "bootcamp-java-educacionit";
		String driverName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://"+host+"/"+dbName+"?serverTimeZone=UTC&userSSL=false";
		*/
//		String host = System.getenv("HOSTS");
		String user = System.getenv("USER");
		String password = System.getenv("PASSWORD");
//		String dbName = System.getenv("DB_NAME");
		String driverName = System.getenv("DRIVER_NAME");
		String url = System.getenv("URL");
		
		//crecion de la clase que pertenece al "jar" mysql-connector
		//no puedo hacer un new Driver, cargar dinamicamente una clase
		//usando:
		
		try {
			Class.forName(driverName);
			
			Connection connection = DriverManager.getConnection(url, user, password);
			
			return connection;
		}catch (SQLException sqe) {
			throw new GenericException("No se ha podido conectar a: " + url, sqe);
		}catch(ClassNotFoundException cnfe) {
			throw new GenericException("No se ha encontrado el driver:" + driverName,cnfe);
		}
	}
	
	public static void main(String[] args) throws GenericException {
		obtenerConexion();
	}
}
