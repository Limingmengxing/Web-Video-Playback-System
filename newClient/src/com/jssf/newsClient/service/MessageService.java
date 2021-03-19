package com.jssf.newsClient.service;


import java.util.List;

import com.jssf.newsClient.dto.MessageDto;
import com.jssf.newsClient.model.Message;
import com.jssf.newsClient.model.UserMessage;


public interface MessageService {

	List<MessageDto> updateMessageJIluList(int userId);

	int saveMessage(int userId, Message message);

	void updatejinggao(int userId);

	List<MessageDto> updateMessage(int userId);

}
