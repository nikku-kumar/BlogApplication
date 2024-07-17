package com.tap.daoI;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.PostDaoInterface;
import com.tap.model.Post;

public class PostDao implements PostDaoInterface{
	String url = "jdbc:mysql://localhost:3306/blog";
	String username = "root";
	String password = "root";
	Connection conn=null;
	
	public PostDao() {
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
	public Post getPostById(int id) {
		 try {
	            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM posts WHERE id = ?");
	            pstmt.setInt(1, id);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                Post post = new Post();
	                post.setId(rs.getInt("id"));
	                post.setTitle(rs.getString("title"));
	                post.setContent(rs.getString("content"));
	                post.setImage(rs.getBytes("image"));
	                post.setVideo(rs.getBytes("video"));
	                post.setDate(rs.getDate("date"));
	                post.setUserId(rs.getInt("userId"));
	                return post;
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return null;
	}

	@Override
	public List<Post> getAllPosts() {
		 try {
	            List<Post> posts = new ArrayList<Post>();
	            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM posts");
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                Post post = new Post();
	                post.setId(rs.getInt("id"));
	                post.setTitle(rs.getString("title"));
	                post.setContent(rs.getString("content"));
	                post.setImage(rs.getBytes("image"));
	                post.setVideo(rs.getBytes("video"));
	                post.setDate(rs.getDate("date"));
	                post.setUserId(rs.getInt("userId"));
	                posts.add(post);
	            }
	            return posts;
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	}

	@Override
	public void createPost(Post post) {
		try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO posts (title, content, image, video, date, userId) VALUES (?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setBytes(3, post.getImage());
            pstmt.setBytes(4, post.getVideo());
            pstmt.setDate(5, (Date) post.getDate());
            pstmt.setInt(6, post.getUserId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		
	}

	@Override
	public void updatePost(Post post) {
		try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE posts SET title = ?, content = ?, image = ?, video = ?, date = ?, userId = ? WHERE id = ?");
            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setBytes(3, post.getImage());
            pstmt.setBytes(4, post.getVideo());
            pstmt.setDate(5, (Date)post.getDate());
            pstmt.setInt(6, post.getUserId());
            pstmt.setInt(7, post.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

	@Override
	public void deletePost(int id) {
		try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM posts WHERE id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	
	public List<Post> searchPosts(String title, String date) {
        try {
            List<Post> posts = new ArrayList<>();
            String sql = "SELECT * FROM posts WHERE title LIKE ? OR date LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + title + "%");
            pstmt.setString(2, "%" + date + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setImage(rs.getBytes("image"));
                post.setVideo(rs.getBytes("video"));
                post.setDate(rs.getDate("date"));
                post.setUserId(rs.getInt("userId"));
                posts.add(post);
            }
            return posts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
