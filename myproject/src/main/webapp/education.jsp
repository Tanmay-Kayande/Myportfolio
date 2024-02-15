<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.EducationDao"%>
<%@page import="com.pojo.EducationPojo"%>
<%
String value = (String) session.getAttribute("login");
if (value == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Education Details</title>
</head>
<body>
	<div id="message-container">
		<%@include file="message.jsp"%>
	</div>
	<form action="Education" method="post">
		Institution name <input type="text" name="institution"
			placeholder="School/College name"><br> Degree <input
			type="text" name="degree" placeholder="Add Degree"><br>
		Year of completion <input type="text" name="year" placeholder="Year"><br>
		Description <input type="text" name="desc"
			placeholder="Add Description"><br>
		<button>Submit</button>
	</form>

	<%
	ArrayList<Object> al = new EducationDao().read();
	for (int in = al.size() - 1; in >= 0; in--) {
		EducationPojo e = (EducationPojo) al.get(in);
	%>

	<div class="education-item">
		<form action="Education" method="post">
			<input type="hidden" name="check" value="update"> <input
				type="hidden" name="sn" value="<%=e.getSn()%>">
			<div>
				Institution name: <input type="text" name="institution"
					value="<%=e.getInstitution()%>">
			</div>
			<div>
				Degree: <input type="text" name="degree" value="<%=e.getDegree()%>">
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
	</div>
	<form action="Education" method="post">
		<input type="hidden" name="check" value="delete">
		<input type="hidden" name="sn" value="<%=e.getSn()%>">
		<button>Delete</button>
	
	</form>

	<%
	}
	%>

</body>
</html>