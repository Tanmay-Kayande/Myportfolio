package com.controller;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dao.EducationDao;
import com.validation.Validation;

/**
 * Servlet implementation class Education
 */
@SuppressWarnings("serial")
public class Education extends HttpServlet {
	
	private String result;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String check = request.getParameter("check");
		HttpSession session = request.getSession();
		if(check==null) {
		
		String institution = request.getParameter("institution");
		String degree = request.getParameter("degree");
		String year = request.getParameter("year");
		String desc = request.getParameter("desc");
		
		ArrayList<Object> al = new ArrayList<>();
		al.add(institution);
		al.add(degree);
		al.add(year);
		al.add(desc);
		result = new Validation().validateEdu(al);
		
		if(result.equals("valid")) {
			
			EducationDao eduDao = new EducationDao();
			result = eduDao.Insert(al);
			if(result.equals("saved")) {
				response.sendRedirect("education.jsp");
				session.setAttribute("msg", "Education added successfully");
			}else {
				response.sendRedirect("education.jsp");
				session.setAttribute("msg", "Something went worng");
			}
		}
		else {
			response.sendRedirect("education.jsp");
			session.setAttribute("msg", result);
		}
		}
		
	}

}
