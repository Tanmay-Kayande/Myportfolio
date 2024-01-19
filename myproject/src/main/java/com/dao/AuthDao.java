package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthDao {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private String result;
	private String sql;
	private ResultSet rs;
	
	@SuppressWarnings("finally")
	public String read(String username, String password) {
		
		try {
			
			connection = ConnectionFactory.getConnection();
			System.out.println(connection);
			sql = "select * from login where username = ? and password = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			rs = preparedStatement.executeQuery();
			if(rs.next()){
				result = "exist";
			}
			else {
				result = "not exist";
			}
			
		} catch (Exception e) {
			result = "not exist";
			e.printStackTrace();
		}
		finally {
			
			return result;
		}
		
	}

}
