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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        // Validate user input
        if (idParam ==null || idParam.isEmpty() ||name.isEmpty() || email.isEmpty() || password.isEmpty() || role.isEmpty()) {
            request.getSession().setAttribute("error", "Please fill all fields.");
            response.sendRedirect(request.getContextPath()+ "/register.jsp");
            return;
        }
        
        int id = Integer.parseInt(idParam);

        // Hash the password
        String hashedPassword = PasswordUtils.hashPassword(password);

        // Create a new user
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(hashedPassword);
        user.setRole(role);

        // Save the user to the database
        UserDao userDao = new UserDao();
        userDao.createUser(user);

        // Set the user in the session
        request.getSession().setAttribute("user", user);

        // Redirect to the login page
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }

    
}
