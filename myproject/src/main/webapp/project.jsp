<%@page import="com.pojo.Projectpojo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.ProjectDao"%>
<%
String value = (String) session.getAttribute("login");
if (value == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Project</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            text-align: center;
        }

        header {
            background-color: #6dc77a;
            color: #fff;
            padding: 10px;
        }

        .add-project {
            max-width: 200px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            text-align: center;
        }

        .read-projects {
            max-width: 800px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            text-align: center;
        }

        .project-list {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }

        .project-item {
            width: 48%; /* Adjust the width as needed */
            margin-bottom: 20px;
        }

        .project-item img {
            max-width: 100%;
            height: auto;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        }

        .project-item form {
            display: flex;
            justify-content: space-between;
            margin-top: 10px;
        }

        button {
            background-color: #6dc77a;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        #message-container {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <header>
        <h1>Add Project</h1>
        <a href="admin.jsp" style="color: #fff; text-decoration: none;">Admin</a>
    </header>

    <!-- Add Project Section -->
    <div class="add-project">
        <form action="Project" method="post" enctype="multipart/form-data">
            <label for="myfile">Choose a file:</label>
            <input type="file" id="myfile" name="myfile"><br>
            <button type="submit">Add Project</button>
        </form>
    </div>

    <!-- Read Project Section -->
    <div class="read-projects">
        <div class="project-list">
            <%
                ArrayList<Object> al = new ProjectDao().read();
                for(Object o:al){
                    Projectpojo p = (Projectpojo)o;
            %>
                <div class="project-item">
                    <img src="images/myprojects/<%=p.getFilename()%>" class="img-fluid" alt="project image">
                    <form action="Project" method="post">
                        <button>Update</button> <button>Delete</button>
                    </form>
                </div>
            <%
                }
            %>
        </div>
    </div>

    <div id="message-container">
        <%@include file="message.jsp" %>
    </div>
</body>
</html>
