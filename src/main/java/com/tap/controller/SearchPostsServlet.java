package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoI.PostDao;
import com.tap.model.Post;

@WebServlet("/searchPosts")
public class SearchPostsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String date = request.getParameter("date");

        // Validate user input
        if (title.isEmpty() && date.isEmpty()) {
            request.getSession().setAttribute("error", "Please fill at least one field.");
            response.sendRedirect(request.getContextPath()+"/viewer/dashboard.jsp");
            return;
        }

        // Search for posts
        PostDao postDao = new PostDao();
        List<Post> posts = postDao.searchPosts(title, date);

        // Set the search results in the session
        request.getSession().setAttribute("posts", posts);

        // Redirect to the search results page
        response.sendRedirect(request.getContextPath()+"/searchResults.jsp");
    }
}
