package com.jssf.newsManage.service;

import java.util.List;

import com.jssf.newsManage.base.service.BaseService;
import com.jssf.newsManage.model.Comment;
import com.jssf.newsManage.model.User;
import com.jssf.newsManage.utils.Pager;


public interface CommentService extends BaseService<Comment>{

	Pager<Comment> findBySayId(int id);

	List<Comment> listNextComByFatherId(int id);

	void comment(Comment comment, int userId, int sayMoodId);

	void save(Comment comment, int userId, int sayMoodId);

	void savehuifu(Comment comment, int userId);

	List<Comment> findBySayIdList(int id);

	Pager<Comment> findComment(int otherId);

	void deleteInfo(int id);

}
