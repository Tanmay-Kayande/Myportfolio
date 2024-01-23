package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.ProjectDao;


@SuppressWarnings("serial")
@MultipartConfig
public class Project extends HttpServlet {
	
		private String result;
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Part part = request.getPart("myfile");
		String filename = part.getSubmittedFileName();
		
		ArrayList<Object> al = new ArrayList<>();
		al.add(filename);
		al.add(part);
		
		result = new ProjectDao().Insert(al);
		if(result.equals("inserted")) {
			
			session.setAttribute("msg", "Project uploaded Successfully");
			response.sendRedirect("add-project.jsp");
			
		}else {
			
			session.setAttribute("msg", "Something went wrong");
			response.sendRedirect("add-project.jsp");
		}
	}

}
