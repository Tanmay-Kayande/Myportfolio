package com.controller;

import java.io.File;
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
	
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String check = request.getParameter("check");
		HttpSession session = request.getSession();
		ProjectDao pd = new ProjectDao();
		if(check == null) {
		
		Part part = request.getPart("myfile");
		String filename = part.getSubmittedFileName();
		
		ArrayList<Object> al = new ArrayList<>();
		al.add(filename);
		al.add(part);
		
		String result = new Validation().validateproject(al);
		
		if(result.equals("valid")) {
			
			result = pd.Insert(al);
			if(result.equals("inserted")) {
				
				session.setAttribute("msg", "Project uploaded successfully");
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
		else if(check.equals("update")) {
			
		}
		else if (check.equals("delete")) {
		    String filename = request.getParameter("filename");
		    String parameter = request.getParameter("sn");
		    int sn = Integer.parseInt(parameter);
		    String result = pd.delete(sn);

		    if (result.equals("deleted")) {
		        String path = "C:/Users/tanma/jsp_projects/myproject/src/main/webapp/images/myprojects/" + filename;

		        // Check if the file exists before attempting to delete
		        File file = new File(path);
		        if (file.exists()) {
		            boolean deleted = file.delete();
		            if (deleted) {
		                session.setAttribute("msg", "Project deleted successfully");
		                response.sendRedirect("project.jsp");
		            } else {
		                session.setAttribute("msg", "Failed to delete the file");
		                response.sendRedirect("project.jsp");
		            }
		        } else {
		            session.setAttribute("msg", "File not found");
		            response.sendRedirect("project.jsp");
		        }
		    } else {
		        session.setAttribute("msg", "Something went wrong");
		        response.sendRedirect("project.jsp");
		    }
		}
	}
	}

