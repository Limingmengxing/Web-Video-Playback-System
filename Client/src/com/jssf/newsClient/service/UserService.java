package com.jssf.newsClient.service;

import java.util.List;

import com.jssf.newsClient.model.User;
import com.jssf.newsClient.utils.Pager;

public interface UserService {
	public List<User> listAllCanSendUser(int userId);

	public void add(User user);

	public User load(User user);

	public User getUser(int userId);

	public List<User> findFriend(String userName, int myId);

	public User loadUserById(int userId);

	public Pager<User> listAll(String userName);

	public void delUse(int userId);

	public List<User> findSYuser();

	public List<User> findBYuser();

	public User isregister(User user);

	public User loadById(int userId);

	public void update(User user);

}
