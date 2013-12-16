package mateuszmidor.com;

/* Klasa odpowiedzialna za operacje na tabeli User w bazie danych u¿ytkownikó */

import java.sql.*;
import java.util.ArrayList;

public class UserModel {
	
	public void addUser(User user) throws SQLException
	{
		String sql_statement = "insert into " +
				"User(FirstName, LastName, Address, NickName, Password) values(?, ?, ?, ?, ?)";
		
		PreparedStatement prepared_sql_statement = SqlStatement.newPreparedStatement(sql_statement,
				user.first_name, user.last_name, user.address, user.nick_name, user.password);
		
		prepared_sql_statement.execute();	
	}
	
	public void updateUser(User user) throws SQLException
	{
		String sql_statement = "update User set " +
				"FirstName = ?, LastName = ?, Address = ?, NickName = ?, Password = ? where id = ?";
		
		PreparedStatement prepared_sql_statement = SqlStatement.newPreparedStatement(sql_statement,
				user.first_name, user.last_name, user.address, 
				user.nick_name, user.password, user.id);
		
		prepared_sql_statement.execute();			
	}
	
	public void deleteUser(String id) throws SQLException
	{
		String sql_statement = "delete from User where id = ?";
		PreparedStatement prepared_sql_statement = SqlStatement.newPreparedStatement(sql_statement, id);
		
		prepared_sql_statement.execute();	
	}
	
	public ArrayList<User> getAllUsers() throws SQLException
	{
		ArrayList<User> users = new ArrayList<User>();
		String sql_statement = "select * from User order by id";
		PreparedStatement prepared_sql_statement = SqlStatement.newPreparedStatement(sql_statement);	
		ResultSet rs = prepared_sql_statement.executeQuery();
		
		while (rs.next())
			users.add(fetchUserFromResultSer(rs));
			
		return users;
	}
	
	private User fetchUserFromResultSer(ResultSet rs) throws SQLException
	{
		User user = new User();
		user.id = rs.getString("id");
		user.first_name = rs.getString("FirstName");	
		user.last_name = rs.getString("LastName");
		user.address = rs.getString("Address");	
		user.nick_name = rs.getString("NickName");	
		user.password = rs.getString("Password");	
		return user;
	}
	
}
