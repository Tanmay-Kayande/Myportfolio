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
import com.validation.Validation;


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
		
		result = new Validation().validateproject(al);
		if(result.equals("valid")) {
			
			result = new ProjectDao().Insert(al);
			if(result.equals("inserted")) {
				
				session.setAttribute("msg", "Project uploaded Successfully");
				response.sendRedirect("project.jsp");
				
			}else {
				
				session.setAttribute("msg", "Something went wrong");
				response.sendRedirect("project.jsp");
			}
		}
		else {
			
			session.setAttribute("msg", "Size should be less than 100MB and in JPG format only");
			response.sendRedirect("project.jsp");
		}
		
		
	}

}
