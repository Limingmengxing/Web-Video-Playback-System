package com.jssf.newsClient.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jssf.newsClient.dao.CommentDao;
import com.jssf.newsClient.dao.UserDao;
import com.jssf.newsClient.model.Comment;
import com.jssf.newsClient.model.News;
import com.jssf.newsClient.model.User;
import com.jssf.newsClient.service.CommentService;
import com.jssf.newsClient.utils.Pager;

@Service("commentService")
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private UserDao userDao;
   
	@Override
	public Pager<Comment> findBySayId(int id) {
		// TODO Auto-generated method stub
		return commentDao.commentDao(id);
	}

	@Override
	public List<Comment> listNextComByFatherId(int id) {
		// TODO Auto-generated method stub
		return commentDao.listNextComByFatherId(id);
	}

	@Override
	public void comment(Comment comment, int userId, int sayMoodId) {
		
	}

/*	@Override
	public void save(Comment comment, int userId, int sayMoodId) {
		//当前登陆 也就是评论人
				private User sayUser;//发表人
				private User comUser;//评论人
				User u =userDao.load(userId);
				SayMood say = sayMoodDao.load(sayMoodId);
				Comment co = new Comment();
				co.setComUser(u);
				co.setCreateTime(new Date());
				co.setFatherComment(null);
				co.setSayMood(say);
				co.setSayUser(say.getSayUser());
				co.setContent(comment.getContent());
				commentDao.add(co);
		
	}
*/
	@Override
	public void savehuifu(Comment comment, int userId) {
		// TODO Auto-generated method stub
		User u =userDao.load(userId);
		//父对象
		Comment com =  commentDao.load(comment.getId());
		Comment comm = new Comment();
		comm.setComUser(u);
		comm.setCreateTime(new Date());
//		comm.setFatherComment(com);
	//	comm.setSayMood(com.getSayMood());
		//comm.setSayUser(com.getComUser());
		comm.setContent(comment.getContent());
		commentDao.add(comm);
	}

	@Override
	public List<Comment> findBySayIdList(int id) {
		return commentDao.findBySayIdList(id);
	}

	@Override
	public void save(Comment comment, int userId) {
		// TODO Auto-generated method stub
		//我把新闻id给了comment
		News n = new News();
		n.setId(comment.getId());
		comment.setNews(n);
		User u = new User();
		u.setId(userId);
		comment.setComUser(u);
		comment.setCreateTime(new Date());
		commentDao.add(comment);
		
	}

	@Override
	public Pager<Comment> findByNewsId(int id) {
		// TODO Auto-generated method stub
		return commentDao.findByNewsId(id);
	}

}
