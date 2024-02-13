package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EducationDao implements InsertDao{

	private Connection connection;
	private String sql;
	private PreparedStatement prepareStatement;
	private int row;
	private String result;
	private ResultSet rs;
	
	@SuppressWarnings("finally")
	@Override
	public String Insert(ArrayList<Object> al) {
		
		try {
			
			connection = ConnectionFactory.getConnection();
			sql = "insert into education(institution, degree, year, `desc`) values(?,?,?,?)";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, (String)al.get(0));
			prepareStatement.setString(2, (String)al.get(1));
			prepareStatement.setInt(3, Integer.parseInt((String) al.get(2)));
			prepareStatement.setString(4, (String)al.get(3));
			row = prepareStatement.executeUpdate();
			if(row==1) {
				result = "saved";
			}
			
		} catch (Exception e) {
			result = "failed";
			e.printStackTrace();
		}
		finally {
			return result;
		}
		
		
	}

	
}
