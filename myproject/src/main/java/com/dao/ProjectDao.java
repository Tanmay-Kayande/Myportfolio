package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.Part;

import com.fileIO.ProjectIO;

public class ProjectDao implements InsertDao {

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

			String filename = (String) al.get(0);
			String formatname = format(filename);
			
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			sql = "insert into project(filename) value (?)";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, formatname);
			row = prepareStatement.executeUpdate();
			if(row == 1) {
				boolean write = new ProjectIO().write(formatname,(Part) al.get(1));
				if(write==true) {
					
					connection.commit();
					result = "inserted";
				}
				else {
					connection.rollback();
					result = "failed";
				}
			}

		} catch (Exception e) {
			result = "failed";
			e.printStackTrace();
		} finally {

			return result;
		}
	}

	private String format(String filename) {

		String formatfilename = LocalDateTime.now().toString() + filename;
		String[] split = formatfilename.split(":");
		return split[0] + split[1] + split[2];

	}

}
