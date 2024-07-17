<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.tap.model.Post" %>
<%@ page import="java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Results</title>
    
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

    img {
        width: 100px;
        height: 100px;
        margin: 10px;
    }

    video {
        width: 100%;
        height: 200px;
        margin: 10px;
    }
</style>
</head>
<body>
    <h1>Search Results</h1>
    <% List<Post> posts = (List<Post>) session.getAttribute("posts"); %>
    <% if (posts != null) { %>
    <table>
        <tr>
            <th>Title</th>
            <th>Content</th>
            <th>Image</th>
            <th>Video</th>
        </tr>
        <% for (Post post : posts) { %>
        <tr>
            <td><%= post.getTitle() %></td>
            <td><%= post.getContent() %></td>
            <td><img src="data:image/jpeg;base64,<%= Base64.getEncoder().encodeToString(post.getImage()) %>" alt="Image"></td>
            <td><video src="data:video/mp4;base64,<%= Base64.getEncoder().encodeToString(post.getVideo()) %>" controls></video></td>
        </tr>
        <% } %>
    </table>
    <% } else { %>
    <p>No search results found.</p>
    <% } %>
</body>
</html>