package com.tap.dao;

import java.util.List;

import com.tap.model.Post;

public interface PostDaoInterface {
	Post getPostById(int id);
	List<Post> getAllPosts();
	void createPost(Post post);
	void updatePost(Post post);
	void deletePost(int id);

}
