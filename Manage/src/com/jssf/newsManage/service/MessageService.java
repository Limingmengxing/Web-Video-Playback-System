package com.jssf.newsManage.service;



import java.util.List;

import com.jssf.newsManage.base.service.BaseService;
import com.jssf.newsManage.model.Message;
import com.jssf.newsManage.model.User;



public interface MessageService extends BaseService<Message>{

	List<Message> findMessageJIluList(int userId);

	int saveMessage(int userId, Message message);

	void updatejinggao(int userId);

}
