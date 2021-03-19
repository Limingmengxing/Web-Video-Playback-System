package com.jssf.newsClient.service;


import java.util.List;

import com.jssf.newsClient.model.Comment;
import com.jssf.newsClient.model.News;
import com.jssf.newsClient.utils.Pager;

public interface CommentService {

	Pager<Comment> findBySayId(int id);

	List<Comment> listNextComByFatherId(int id);

	void comment(Comment comment, int userId, int sayMoodId);

	void save(Comment comment, int userId);

	void savehuifu(Comment comment, int userId);

	List<Comment> findBySayIdList(int id);

	Pager<Comment> findByNewsId(int id);

}
