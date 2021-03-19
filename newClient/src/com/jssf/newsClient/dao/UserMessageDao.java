package com.jssf.newsClient.dao;

import java.util.List;

import com.jssf.newsClient.base.dao.BaseDao;
import com.jssf.newsClient.model.Special;
import com.jssf.newsClient.model.UserMessage;

public interface UserMessageDao extends BaseDao<UserMessage>{

	List<UserMessage> findMessageJIluList(int userId);

	List<UserMessage> findMessage(int userId);

}
