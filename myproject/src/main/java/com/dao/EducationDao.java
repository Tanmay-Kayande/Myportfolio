package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.pojo.EducationPojo;

public class EducationDao implements InsertDao, ReadDao, DeleteDao, UpdateDao{

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

	@SuppressWarnings("finally")
	@Override
	public ArrayList<Object> read() {
		
		ArrayList<Object> al = new ArrayList<>();
		
		try {
			connection = ConnectionFactory.getConnection();
			sql = "select * from education";
			prepareStatement = connection.prepareStatement(sql);
			rs =prepareStatement.executeQuery();
			while(rs.next()) {
				EducationPojo e =	new EducationPojo(rs.getInt("sn"), rs.getString("institution"), rs.getString("degree"),
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
public int countEdu() {
		
		int edu = 0;
		try {
			connection = ConnectionFactory.getConnection();
			sql = "select count(*) as count from education";
			prepareStatement = connection.prepareStatement(sql);
			rs = prepareStatement.executeQuery();
			rs.next();
			edu = rs.getInt("count");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			return edu;
		}
	
}

@SuppressWarnings("finally")
@Override
public String delete(int sn) {
	
	try {
		connection = ConnectionFactory.getConnection();
		sql = "delete from education where sn =?";
		prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setInt(1, sn);
		row = prepareStatement.executeUpdate();
		if(row == 1) {
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

@SuppressWarnings("finally")
@Override
public String update(ArrayList<Object> al) {
    int sn = (int) al.get(0);
    String institution = (String) al.get(1);
    String degree = (String) al.get(2);
    String year =  (String) al.get(3);  // Retrieve year as int
    String desc = (String) al.get(4);
    try {
        connection = ConnectionFactory.getConnection();
        sql = "update education set institution =?, degree =?, year =?, `desc` =? where sn =?";
        prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, institution);
        prepareStatement.setString(2, degree);
        prepareStatement.setInt(3, Integer.parseInt(year));  // Set year as int
        prepareStatement.setString(4, desc);
        prepareStatement.setInt(5, sn);
        row = prepareStatement.executeUpdate();
        if(row == 1) {
            result = "updated";
        }
    } catch (Exception e) {
        result = "failed";
        e.printStackTrace();
    } finally {
        return result;
    }
}


	
}
