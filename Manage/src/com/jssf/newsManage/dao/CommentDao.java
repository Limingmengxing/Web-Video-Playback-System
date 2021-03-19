package com.jssf.newsManage.dao;

import java.util.List;

import com.jssf.newsManage.base.dao.BaseDao;
import com.jssf.newsManage.model.Comment;
import com.jssf.newsManage.utils.Pager;

public interface CommentDao extends BaseDao<Comment>{

	Pager<Comment> commentDao(int id);

	List<Comment> listNextComByFatherId(int id);

	List<Comment> findBySayIdList(int id);

	Pager<Comment> findComment(int otherId);

}
