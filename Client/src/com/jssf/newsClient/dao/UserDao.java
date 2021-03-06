package com.jssf.newsClient.dao;


import java.util.List;

import com.jssf.newsClient.base.dao.BaseDao;
import com.jssf.newsClient.model.User;
import com.jssf.newsClient.utils.Pager;

public interface UserDao extends BaseDao<User>{
	public List<User> listAllCanSendUser(int userId);
	@Override
	User add(User t);
	public User load(User user);
	public List<User> findFriend(String userName);
	public List<User> loadTuiJian(User you);
	public Pager<User> listAll();
	public Pager<User> finAllByName(String userName);
	public List<User> findSYuser();
	public List<User> findBYuser();
	public User isregister(User user);
	public List<User> findAll();

}
