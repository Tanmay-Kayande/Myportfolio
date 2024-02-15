<%@page import="com.pojo.CertificatesPojo"%>
<%@page import="com.dao.CertificatesDao"%>
<%@page import="java.util.ArrayList"%>
<%
String value = (String) session.getAttribute("login");
if (value == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%@include file="message.jsp"%>

		<form action="Certificates" method="post">
		Certificate name <input type="text" name="certificate"
			placeholder="Certificate name"><br> Institution <input
			type="text" name="institution" placeholder="Add Institution"><br>
		Year of completion <input type="text" name="year" placeholder="Year"><br>
		Description <input type="text" name="desc"
			placeholder="Add Description"><br>
		<button>Submit</button>
		</form>
		<%
	ArrayList<Object> al = new CertificatesDao().read();
	for (int in = al.size() - 1; in >= 0; in--) {
		CertificatesPojo e = (CertificatesPojo) al.get(in);
	%>

		<form action="Certificates" method="post">
			<input type="hidden" name="check" value="update"> <input
				type="hidden" name="sn" value="<%=e.getSn()%>">
			<div>
				Certificate name: <input type="text" name="certificate"
					value="<%=e.getCertificate()%>">
			</div>
			<div>
				Institution: <input type="text" name="institution" value="<%=e.getInstitution()%>">
			</div>
			<div>
				Year of completion: <input type="text" name="year"
					value="<%=e.getYear()%>">
			</div>
			<div>
				Description: <input type="text" name="desc" value="<%=e.getDesc()%>">
			</div>
			<button>Update</button>	
		</form>
		
		<form action="Certificates" method="post">
		<input type="hidden" name="check" value="delete">
		<input type="hidden" name="sn" value="<%=e.getSn()%>">
		<button>Delete</button>
	
	</form>
	
	<%
	}
	%>
	
	
</body>
</html>