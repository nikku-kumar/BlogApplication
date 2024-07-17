package com.tap.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.tap.daoI.PostDao;
import com.tap.model.Post;
import com.tap.model.User;

@WebServlet("/admin/createPost")
@MultipartConfig
public class CreatePostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // Retrieve the form fields
        Part titlePart = request.getPart("title");
        Part contentPart = request.getPart("content");
        Part imagePart = request.getPart("image");
        Part videoPart = request.getPart("video");

        // Validate user input
        if (titlePart == null || titlePart.getSize() == 0 || contentPart == null || contentPart.getSize() == 0) {
            request.getSession().setAttribute("error", "Please fill all fields.");
            response.sendRedirect(request.getContextPath() + "/admin/dashboard.jsp");
            return;
        }

        // Get the logged-in user from the session
        User user = (User) request.getSession().getAttribute("user");
        
        if (user == null) {
            // Handle the case where the user is not logged in
            request.getSession().setAttribute("error", "You must be logged in to create a post.");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // Create a new post
        Post post = new Post();
        post.setTitle(getPartValue(titlePart));
        post.setContent(getPartValue(contentPart));
        post.setImage(imagePart.getInputStream().readAllBytes());
        post.setVideo(videoPart.getInputStream().readAllBytes());
        post.setDate(new Date());
        post.setUserId(user.getId());

        // Save the post to the database
        PostDao postDao = new PostDao();
        postDao.createPost(post);

        // Redirect to the admin dashboard
        response.sendRedirect(request.getContextPath() + "/admin/dashboard.jsp");
    }

    private String getPartValue(Part part) throws IOException {
        return new String(part.getInputStream().readAllBytes());
    }
}