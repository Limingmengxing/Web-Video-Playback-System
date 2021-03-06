package com.jssf.newsClient.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jssf.newsClient.dao.UserDao;
import com.jssf.newsClient.model.User;
import com.jssf.newsClient.service.UserService;
import com.jssf.newsClient.utils.Pager;


@Service("userService")
public class UserServiceImpl implements UserService {
	
    @Autowired
	private UserDao userdao;
	@Override
	public List<User> listAllCanSendUser(int userId) {
		return userdao.listAllCanSendUser(userId);
	}
	@Override
	public void add(User user) {
		userdao.add(user);
	}
	@Override
	public User load(User user) {
		return userdao.load(user);
	}
	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return userdao.load(userId);
	}
	/*@Override
	public List<User> findFriend(String userName,int myId) {
		// TODO Auto-generated method stub
		List<User> us = new ArrayList<User>();
		List<User> users=  userdao.findFriend(userName);
		//排除已经添加过得
		for(User u : users){
			Friend ch =friendDao.checkIsFriend(u.getId(),myId);
			if(ch==null){
				us.add(u);
			}
		}
		
		return us;
	}*/
	@Override
	public User loadUserById(int userId) {
		// TODO Auto-generated method stub
		return userdao.load(userId);
	}
	@Override
	public Pager<User> listAll(String userName) {
		// TODO Auto-generated method stub
		if(userName == null || "".equals(userName)){
			return userdao.listAll();
		}else{
			return userdao.finAllByName(userName);
		}
		
	}
	@Override
	public void delUse(int userId) {
		// TODO Auto-generated method stub
		User u =userdao.load(userId);
//		u.setIsDelete(1);
		userdao.update(u);
	}
	@Override
	public List<User> findSYuser() {
		// TODO Auto-generated method stub
		return userdao.findSYuser();
	}
	@Override
	public List<User> findBYuser() {
		// TODO Auto-generated method stub
		return userdao.findBYuser();
	}
	@Override
	public List<User> findFriend(String userName, int myId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User isregister(User user) {
		// TODO Auto-generated method stub
		return userdao.isregister(user);
	}
	@Override
	public User loadById(int userId) {
		// TODO Auto-generated method stub
		return userdao.load(userId);
	}
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userdao.update(user);
	}

}
