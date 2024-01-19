package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MessageDao;
import com.validation.Validation;

/**
 * Servlet implementation class Message
 */
@SuppressWarnings("serial")
public class Message extends HttpServlet {
	
		private String result;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String check = request.getParameter("check");
		HttpSession session = request.getSession();
		if(check==null) {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		
		result = new Validation().validateMessage(name, email, message);
		
		if(result.equals("valid")) {
			
			ArrayList<Object> ar = new ArrayList<>();
			ar.add(name);
			ar.add(email);
			ar.add(message);
			
			result = new MessageDao().Insert(ar);
			if(result.equals("saved")) {
				response.sendRedirect("index.jsp");
				session.setAttribute("msg", "Message sent successfully");
			}
			else {
				response.sendRedirect("index.jsp");
				session.setAttribute("msg", "Something went worng");
			}
			System.out.println(result);
		}
		else {
			response.sendRedirect("index.jsp");
			session.setAttribute("msg", result);
		}
	}
		else if(check.equals("delete")){
			
			String sn =request.getParameter("sn");
			result = new MessageDao().delete(Integer.parseInt(sn));
			if(result.equals("deleted")) {
				session.setAttribute("msg", "Message deleted successfully");
				response.sendRedirect("read-message.jsp");
			}
			else {
				session.setAttribute("msg", "Something went wrong");
				response.sendRedirect("read-message.jsp");
			}
		}
		
	}
}