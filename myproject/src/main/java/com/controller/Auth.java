package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AuthDao;
import com.validation.Validation;

@SuppressWarnings("serial")
public class Auth extends HttpServlet {
	
	private String result; 
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String check = request.getParameter("check");
		HttpSession session = request.getSession();
		AuthDao authDao = new AuthDao();
		
		if(check==null) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		result = new Validation().validateLoginData(username, password);
		
		if(result.equals("valid")) {
			result = authDao.read(username, password);
			if(result.equals("exist")) {
				session.setAttribute("login", "exist");
				response.sendRedirect("admin.jsp");
			}
			else {
				session.setAttribute("msg", "invalid username or password");
				response.sendRedirect("login.jsp");
			}
		}
		else {
			session.setAttribute("msg", result);
			response.sendRedirect("login.jsp");
		}
	}
		else if(check.equals("Logout")) {
			session.removeAttribute("login");
			session.setAttribute("msg", "Logout Successfully");
			response.sendRedirect("login.jsp");
		}
		else if(check.equals("change")) {
			
			String opass = request.getParameter("opass");
			String npass = request.getParameter("npass");
			String cpass = request.getParameter("cpass");
			
			if(npass.equals(cpass)) {
				
				ArrayList<Object> al = new ArrayList<>();
				al.add(opass);
				al.add(npass);
				result = authDao.update(al);
				if(result.equals("updated")) {
					session.setAttribute("msg", "New password updated");
					response.sendRedirect("admin.jsp");
				}
				else if(result.equals("incorrect")) {
					session.setAttribute("msg", "Invalid old password");
					response.sendRedirect("admin.jsp");
				}
				else {
					session.setAttribute("msg", "Something went wrong");
					response.sendRedirect("admin.jsp");
				}
			}
			else {
				session.setAttribute("msg", "New password and Confirm password does not mstch");
				response.sendRedirect("admin.jsp");
			}
		}

}
	}
