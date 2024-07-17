package com.tap.daoI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.UserDaoInterface;
import com.tap.model.User;

public class UserDao implements UserDaoInterface{
	
	String url = "jdbc:mysql://localhost:3306/blog";
	String username = "root";
	String password = "root";
	Connection conn=null;
	
	public UserDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUserById(String email) {
		try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE email = ?");
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
	}

	@Override
	public List<User> getAllUsers() {
		try {
            List<User> users = new ArrayList<User>();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

	@Override
	public void createUser(User user) {
		try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (id,name, email, password, role) VALUES (?, ?, ?, ?, ?)");
            pstmt.setInt(1,user.getId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getRole());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

	@Override
	public void updateUser(User user) {
		try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE users SET name = ?, email = ?, password = ?, role = ? WHERE id = ?");
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getRole());
            pstmt.setInt(5, user.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

	@Override
	public void deleteUser(int id) {
		try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM users WHERE id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

}
