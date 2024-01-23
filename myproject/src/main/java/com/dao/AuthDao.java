package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AuthDao implements UpdateDao{

	private Connection connection;
	private PreparedStatement preparedStatement;
	private String result;
	private String sql;
	private ResultSet rs;
	private int row;
	
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

	@SuppressWarnings("finally")
	@Override
	public String update(ArrayList<Object> al) {
		try {
			String opass = (String)al.get(0);
			String npass = (String)al.get(1);
					
			String checkOldPass = checkOldPass(opass);
			if(checkOldPass.equals("correct")) {
				connection = ConnectionFactory.getConnection();
				sql = "update login set password = ? where sn = 1";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, npass);
				row = preparedStatement.executeUpdate();
				if(row==1) {
					result = "updated";
				}
				
				
			}else {
				result = "incorrect";
			}
			
		} catch (Exception e) {
			result = "failed";
			e.printStackTrace();
		}
		finally {
			return result ;
			
		}
	}

	@SuppressWarnings("finally")
	private String checkOldPass(String opass) {
		
		try {
			
			connection = ConnectionFactory.getConnection();
			sql = "select * from login where password =?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, opass);
			rs = preparedStatement.executeQuery();
			if(rs.next() == true) {
				
				result = "correct";
			}
			else
				result = "incorrect";
			
		} catch (Exception e) {
			
			result = "incorrect";
		}
		finally {
			return result;
		}
		
	}

}
