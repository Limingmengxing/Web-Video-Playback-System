package com.jssf.newsManage.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jssf.newsManage.base.dao.impl.BaseDaoImpl;
import com.jssf.newsManage.dao.CommentDao;
import com.jssf.newsManage.model.Comment;
import com.jssf.newsManage.utils.Pager;

@Repository("commentDao")
@SuppressWarnings("unchecked")
public class CommentDaoImpl extends BaseDaoImpl<Comment>  implements CommentDao{

	//根据shuoshuoid查询一级评论
	public Pager<Comment> commentDao(int id) {
		String hql = "from Comment where sayMood.id = :id and fatherComment is null order by createTime desc";
		Map<String,Object> alias = new HashMap<String,Object>();
		alias.put("id", id);
		return findByAlias(hql, alias);
	}

	public List<Comment> listNextComByFatherId(int id) {
		String hql = "from Comment where fatherComment.id = :id order by createTime desc";
		Map<String,Object> alias = new HashMap<String,Object>();
		alias.put("id", id);
		return listByAlias(hql, alias);
	}

	public List<Comment> findBySayIdList(int id) {
		String hql = "from Comment where sayMood.id = :id and fatherComment is null order by createTime desc";
		Map<String,Object> alias = new HashMap<String,Object>();
		alias.put("id", id);
		return listByAlias(hql, alias);
	}

	public Pager<Comment> findComment(int otherId) {
		String hql = "from Comment where news.id = :id  order by createTime desc";
		Map<String,Object> alias = new HashMap<String,Object>();
		alias.put("id", otherId);
		return findByAlias(hql, alias);
	}

}
