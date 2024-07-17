package com.tap.dao;

import java.util.List;

import com.tap.model.User;

public interface UserDaoInterface {
	User getUserById(String email);
	List<User> getAllUsers();
	void createUser(User user);
	void updateUser(User user);
	void deleteUser(int id);

}
