package mateuszmidor.com;

/* Klasa singletonowa udost�pniaj�ca po��czenie z baz� danych MySQL. */

import java.sql.*;
public class MysqlDatabaseConnection implements DatabaseConnection {
	
	// instancja i pobieranie instancji singletona
	static private MysqlDatabaseConnection instance = null;
	static public MysqlDatabaseConnection grabInstance()
	{
		try {
			if (null == instance)
				instance = new MysqlDatabaseConnection();
		} catch (Exception e) {
			MessageDialog.showException("B��d podczas ��czenia z baz� danych", e);
			return null;
			
		}	
		return instance;
	}
	
	private Connection db_connection = null;
	
	private MysqlDatabaseConnection() throws Exception 
	{	
		// pobieramy dane do po��czenia z baz� danych
		String host_name = Config.valueOf("host_name");
		String database_name = Config.valueOf("database_name");
		String user_name = Config.valueOf("user_name");
		String user_password = Config.valueOf("user_password");
		
		// ��czymy si� z baz� danych
		Class.forName("com.mysql.jdbc.Driver");
		String connection_string = getConnectionString(host_name, database_name);
		db_connection = DriverManager.getConnection(connection_string, user_name, user_password);	
	}
	
	// tworzy connection-stringa
	private String getConnectionString(String host_name, String database_name)
	{
		return String.format("jdbc:mysql://%s/%s", host_name, database_name);	
	}
	
	// na zako�czenie zamyka po��czenie z baz� danych
	protected void finalize()
	{ 
		if (db_connection != null)
			try {
				db_connection.close();
			} 
			catch (SQLException e) {
				MessageDialog.showException("B��d podczas zamykania po��czenia z baz� danych", e);
			}	
	}
	
	public Connection getConnection()
	{
		return db_connection;
	}
}
