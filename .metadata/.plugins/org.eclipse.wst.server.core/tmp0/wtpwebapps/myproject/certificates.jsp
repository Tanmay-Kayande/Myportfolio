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
</body>
</html>