package com.jssf.newsManage.dao;

import java.util.List;
import java.util.Set;

import com.jssf.newsManage.base.dao.BaseDao;
import com.jssf.newsManage.model.Message;

public interface MessageDao extends BaseDao<Message>{

	List<Message> findMessageJIluList(Set<Integer> sets);

	Message findJGByUserId(int userId);

}
