package com.jssf.newsClient.dao;
import java.util.List;
import java.util.Set;

import com.jssf.newsClient.base.dao.BaseDao;
import com.jssf.newsClient.model.Message;

public interface MessageDao extends BaseDao<Message>{

	List<Message> findMessageJIluList(Set<Integer> sets);

	Message findJGByUserId(int userId);

}
