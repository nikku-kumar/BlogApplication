<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    
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

    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 10px;
        text-align: left;
    }

    th {
        background-color: #00698f;
        color: #fff;
    }
</style>
</head>
<body>
     <h1>Admin Dashboard</h1>
    <% String error = (String) session.getAttribute("error"); %>
    <% if (error != null) { %>
        <div style="color: red;"><%= error %></div>
    <% } %>
    <form action="<%= request.getContextPath() %>/admin/createPost" method="post" enctype="multipart/form-data">
        <label for="title">Title:</label><br>
        <input type="text" id="title" name="title">
        <textarea id="content" name="content"></textarea><br>
        <label for="content">Content:</label><br>
        <textarea id="content" name="content"></textarea><br>
        <label for="image">Image:</label><br>
        <input type="file" id="image" name="image"><br>
        <label for="video">Video:</label><br>
        <input type="file" id="video" name="video"><br>
        <input type="submit" value="Create Post">
    </form>
</body>
</html>