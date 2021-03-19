package com.jssf.newsManage.service.impl;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jssf.newsManage.base.service.impl.BaseServiceImpl;
import com.jssf.newsManage.dao.MessageDao;
import com.jssf.newsManage.dao.UserDao;
import com.jssf.newsManage.model.Message;
import com.jssf.newsManage.model.User;
import com.jssf.newsManage.service.MessageService;

import freemarker.template.SimpleDate;

@Service("messageService")
public class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageService{
    @Autowired
	private MessageDao messageDao;
    @Autowired
	private UserDao userdao;
	/*@Override
	public List<Message> findMessageJIluList(int userId) {
		// TODO Auto-generated method stub
		List<Message> mes = null;
		SimpleDateFormat  sip = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		//首先查询我有多少好友
		List<Friend> loadFriends = friendDao.loadFriends(userId);
		Set<Integer> sets = new HashSet<Integer>();
		for(Friend f:loadFriends){
			sets.add(f.getUser().getId());
			sets.add(f.getFriendUser().getId());
		}
		if(sets !=null && sets.size()>0){
			 mes =MessageDao.findMessageJIluList(sets);
		}
		for(Message m :mes){
			m.setCreateTimeStr(sip.format(m.getCreateTime()));
		}
		return mes;
	}*/
	public int saveMessage(int userId, Message message) {
		// TODO Auto-generated method stub
		 User u = userdao.load(userId);
//		 if(u.getJifen() == 0){
//			return -1; 
//		 }
		 Message me = new Message();
		 me.setContent(message.getContent());
		 me.setCreateTime(new Date());
		 me.setSendUser(u);
//		 me.setType(1);
		 messageDao.add(me);
		 //发送消息，一个几分  还需要 几分规则计算
		 
		 return 1;
	}
	public void updatejinggao(int userId) {
		// TODO Auto-generated method stub
		User u =userdao.load(userId);
		//查看这个用户还有没有警告，如果有就不加了，如果美誉。。。
		Message me = messageDao.findJGByUserId(userId);
		if(me == null){
			Message mes = new Message();
			mes.setCreateTime(new Date());
			mes.setContent("警告");
			mes.setSendUser(u);
//			mes.setType(3);
			messageDao.add(mes);
		}
	}
	public List<Message> findMessageJIluList(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
