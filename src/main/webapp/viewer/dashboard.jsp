<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Viewer Dashboard</title>
    
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
    <h1>Viewer Dashboard</h1>
    <form action="searchPosts" method="post">
        <label for="title">Search by Title:</label><br>
        <input type="text" id="title" name="title"><br>
        <label for="date">Search by Date:</label><br>
        <input type="date" id="date" name="date"><br>
        <input type="submit" value="Search">
    </form>
</body>
</html>