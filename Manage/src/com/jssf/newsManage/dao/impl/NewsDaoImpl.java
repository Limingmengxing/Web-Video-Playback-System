package com.jssf.newsManage.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jssf.newsManage.base.dao.impl.BaseDaoImpl;
import com.jssf.newsManage.dao.NewsDao;
import com.jssf.newsManage.model.News;
import com.jssf.newsManage.utils.Pager;


@Repository("newsDao")
@SuppressWarnings("unchecked")
public class NewsDaoImpl extends BaseDaoImpl<News>  implements NewsDao{

	public Pager<News> list() {
		String hql = "from News order by createTime desc";
		return findByAlias(hql, null);
	}

	public Pager<News> listByTitle(String title) {
		// TODO Auto-generated method stub
		String hql = "from News where title like :title order by createTime desc";
		Map<String,Object> alias = new HashMap<String,Object>();
		alias.put("title", "%" + title + "%");
		return findByAlias(hql, alias);
	}

}
