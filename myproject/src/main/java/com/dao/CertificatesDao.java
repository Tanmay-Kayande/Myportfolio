package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.pojo.CertificatesPojo;

public class CertificatesDao implements InsertDao, ReadDao, DeleteDao, UpdateDao{

	private Connection connection;
	private String sql;
	private PreparedStatement prepareStatement;
	private int row;
	private String result;
	private ResultSet rs;
	
	@Override
	public String update(ArrayList<Object> al) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int sn) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("finally")
	@Override
	public ArrayList<Object> read() {
		
		ArrayList<Object> al = new ArrayList<>();
		
		try {
			connection = ConnectionFactory.getConnection();
			sql = "select * from certificates";
			prepareStatement = connection.prepareStatement(sql);
			rs =prepareStatement.executeQuery();
			while(rs.next()) {
				CertificatesPojo e =	new CertificatesPojo(rs.getInt("sn"), rs.getString("certificate"), rs.getString("institution"),
						rs.getString("year"), rs.getString("desc"));
				al.add(e);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			return al;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public String Insert(ArrayList<Object> al) {
		
try {
			
			connection = ConnectionFactory.getConnection();
			sql = "insert into certificates(certificate, institution, year, `desc`) values(?,?,?,?)";
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
