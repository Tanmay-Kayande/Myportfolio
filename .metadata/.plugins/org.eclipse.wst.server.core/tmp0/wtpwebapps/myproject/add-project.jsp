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

        main {
            max-width: 400px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            text-align: center; /* Center the content */
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
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

        @media screen and (max-width: 600px) {
            main {
                max-width: 100%;
            }
        }
    </style>
</head>
<body>
    <header>
        <h1>Add Project</h1>
        <a href="admin.jsp" style="color: #fff; text-decoration: none;">Admin</a>
    </header>

    <main>
        <form action="Project" method="post" enctype="multipart/form-data">
            <label for="myfile">Choose a file:</label>
            <input type="file" id="myfile" name="myfile"><br>
            <button type="submit">Add Project</button>
        </form>
    </main>

    <div id="message-container">
        <%@include file="message.jsp" %>
    </div>
</body>
</html>
