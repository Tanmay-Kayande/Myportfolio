<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%@include file = "message.jsp" %>
	<form action="Project" method="post" enctype="multipart/form-data">
		<input type = "file" name="myfile"><br>
		<button>Add Project</button>
	</form>

</body>
</html>