<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    
    <style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
    }

    h1 {
        color: #00698f;
        font-size: 36px;
        font-weight: bold;
        margin-bottom: 10px;
    }

    form {
        width: 50%;
        margin: 0 auto;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    label {
        display: block;
        margin-bottom: 10px;
    }

    input[type="text"], input[type="email"], input[type="password"] {
        width: 100%;
        height: 40px;
        margin-bottom: 20px;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    input[type="submit"] {
        width: 100%;
        height: 40px;
        background-color: #00698f;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #004c7f;
    }
</style>
</head>
<body>
    <h1>Register</h1>
    <% String error = (String) session.getAttribute("error"); %>
    <% if (error != null) { %>
        <div style="color: red;"><%= error %></div>
    <% } %>
    <form action="register" method="post">
        <label for="name">ID:</label><br>
        <input type="text" id="id" name="id"><br>
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name"><br>
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email"><br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password"><br>
        <label for="role">Role:</label><br>
        <select id="role" name="role">
            <option value="Admin">Admin</option>
            <option value="Viewer">Viewer</option>
        </select><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>