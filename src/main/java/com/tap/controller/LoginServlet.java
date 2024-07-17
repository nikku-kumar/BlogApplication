package com.tap.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoI.UserDao;
import com.tap.model.User;
import com.tap.units.PasswordUtils;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate user input
        if (email.isEmpty() || password.isEmpty()) {
            request.getSession().setAttribute("error", "Please fill all fields.");
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        }

        // Authenticate the user
        UserDao userDao = new UserDao();
        User user = userDao.getUserById(email);

        if (user == null || !PasswordUtils.hashPassword(password).equals(user.getPassword())) {
            request.getSession().setAttribute("error", "Invalid email or password.");
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        }

        // Set the user in the session
        request.getSession().setAttribute("user", user);

        // Redirect to the appropriate dashboard based on the user's role
        if (user.getRole().equals("Admin")) {
            response.sendRedirect(request.getContextPath() +"/admin/dashboard.jsp");
        } else {
            response.sendRedirect(request.getContextPath() +"/viewer/dashboard.jsp");
        }
    }
}
