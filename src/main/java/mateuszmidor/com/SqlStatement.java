package mateuszmidor.com;

/* Klasa preparuj¹ca zapytania SQL odporne na ataki SQL Injection 
 * (pod warunkiem w³aœciwego u¿ycia) */

import java.sql.*;

public class SqlStatement {
	static private Connection getConnection()
	{
		return MysqlDatabaseConnection.grabInstance().getConnection();
	}
	
	static private PreparedStatement newStatement(String sql_statement) throws SQLException
	{
		Connection db_connection = getConnection();
		return db_connection.prepareStatement(sql_statement);
	}
	
	// zwraca obiekt PreparedStatement wygenerowany na podstawie zapytania SQL
	static public PreparedStatement newPreparedStatement(String sql_statement) throws SQLException
	{
		return newStatement(sql_statement);
	}
	
	// wstawia do zapytania SQL zmienne[fields] w miejsca pytajników i zwraca obiekt PreparedStatement
	static public PreparedStatement newPreparedStatement(String sql_statement, String...fields) throws SQLException
	{
		PreparedStatement statement = newStatement(sql_statement);
		for (int i = 0; i < fields.length; i++)
		        statement.setString(i + 1, fields[i]);
		
		return statement;
	}
}