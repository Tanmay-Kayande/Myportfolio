package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.pojo.MessagePojo;

public class MessageDao implements InsertDao, ReadDao, DeleteDao {
	
	
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
			sql = "insert into message(name, email, message, date) values(?,?,?,?)";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, (String)al.get(0));
			prepareStatement.setString(2, (String)al.get(1));
			prepareStatement.setString(3, (String)al.get(2));
			prepareStatement.setString(4, LocalDateTime.now().toString());
			
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

	@SuppressWarnings("finally")
	@Override
	public ArrayList<Object> read() {
		
		ArrayList<Object> ar = new ArrayList<>();
		
		try {
			connection = ConnectionFactory.getConnection();
			sql = "select * from message";
			prepareStatement = connection.prepareStatement(sql);
			rs = prepareStatement.executeQuery();
			while(rs.next()) {
				MessagePojo m = new MessagePojo(rs.getInt("sn"), rs.getString("name"), rs.getString("email"), rs.getString("message"),
						rs.getString("date"));
				ar.add(m);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			
			return ar;
		}
	}
	
	@SuppressWarnings("finally")
	public int count() {
		
		int no_of_message = 0;
		try {
			connection = ConnectionFactory.getConnection();
			sql = "select count(*) as count from message";
			prepareStatement = connection.prepareStatement(sql);
			rs = prepareStatement.executeQuery();
			rs.next();
			no_of_message = rs.getInt("count");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			return no_of_message;
		}
		
		
	}

	@SuppressWarnings("finally")
	@Override
	public String delete(int sn) {
		
		try {
			
			connection = ConnectionFactory.getConnection();
			sql = "delete from message where sn = ?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, sn);
			row = prepareStatement.executeUpdate();
			if(row==1) {
				result = "deleted";
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
