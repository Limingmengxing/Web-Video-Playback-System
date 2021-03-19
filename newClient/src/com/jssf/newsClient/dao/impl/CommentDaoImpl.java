package com.jssf.newsClient.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jssf.newsClient.base.dao.impl.BaseDaoImpl;
import com.jssf.newsClient.dao.CommentDao;
import com.jssf.newsClient.model.Comment;
import com.jssf.newsClient.model.News;
import com.jssf.newsClient.utils.Pager;

@Repository("commentDao")
@SuppressWarnings("unchecked")
public class CommentDaoImpl extends BaseDaoImpl<Comment>  implements CommentDao{

	//根据shuoshuoid查询一级评论
	@Override
	public Pager<Comment> commentDao(int id) {
		String hql = "from Comment where sayMood.id = :id and fatherComment is null order by createTime desc";
		Map<String,Object> alias = new HashMap<String,Object>();
		alias.put("id", id);
		return findByAlias(hql, alias);
	}

	@Override
	public List<Comment> listNextComByFatherId(int id) {
		String hql = "from Comment where fatherComment.id = :id order by createTime desc";
		Map<String,Object> alias = new HashMap<String,Object>();
		alias.put("id", id);
		return listByAlias(hql, alias);
	}

	@Override
	public List<Comment> findBySayIdList(int id) {
		String hql = "from Comment where sayMood.id = :id and fatherComment is null order by createTime desc";
		Map<String,Object> alias = new HashMap<String,Object>();
		alias.put("id", id);
		return listByAlias(hql, alias);
	}

	@Override
	public Pager<Comment> findByNewsId(int id) {
		String hql = "from Comment where news.id = :id order by createTime desc";
		Map<String,Object> alias = new HashMap<String,Object>();
		alias.put("id", id);
		return findByAlias(hql, alias);
	}

}
