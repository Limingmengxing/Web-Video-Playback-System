package com.jssf.newsClient.dao;


import java.util.List;

import com.jssf.newsClient.base.dao.BaseDao;
import com.jssf.newsClient.model.Comment;
import com.jssf.newsClient.model.News;
import com.jssf.newsClient.utils.Pager;

public interface CommentDao extends BaseDao<Comment>{

	Pager<Comment> commentDao(int id);

	List<Comment> listNextComByFatherId(int id);

	List<Comment> findBySayIdList(int id);

	Pager<Comment> findByNewsId(int id);

}
