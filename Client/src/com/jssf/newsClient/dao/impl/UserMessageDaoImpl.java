package com.jssf.newsClient.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jssf.newsClient.base.dao.impl.BaseDaoImpl;
import com.jssf.newsClient.dao.UserMessageDao;
import com.jssf.newsClient.model.Advertisement;
import com.jssf.newsClient.model.UserMessage;
@Repository
@SuppressWarnings("unchecked")
public class UserMessageDaoImpl extends BaseDaoImpl<UserMessage> implements UserMessageDao{

	@Override
	public List<UserMessage> findMessageJIluList(int userId) {
		String hql ="from UserMessage where resivrUser.id = :userId";
		Map<String,Object> alias = new HashMap<String,Object>();
		alias.put("userId", userId);
		return listByAlias(hql, alias);
	}

	@Override
	public List<UserMessage> findMessage(int userId) {
		String hql ="from UserMessage where resivrUser.id = :userId and isRead = 2";
		Map<String,Object> alias = new HashMap<String,Object>();
		alias.put("userId", userId);
		return listByAlias(hql, alias);
	}

}
