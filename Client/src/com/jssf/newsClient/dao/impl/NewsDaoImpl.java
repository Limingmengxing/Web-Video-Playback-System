package com.jssf.newsClient.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jssf.newsClient.base.dao.impl.BaseDaoImpl;
import com.jssf.newsClient.dao.NewsDao;
import com.jssf.newsClient.model.News;
import com.jssf.newsClient.utils.Pager;

@Repository("newsDao")
@SuppressWarnings("unchecked")
public class NewsDaoImpl extends BaseDaoImpl<News>  implements NewsDao{

	@Override
	public Pager<News> list() {
		String hql = "from News order by createTime desc";
		return findByAlias(hql, null);
	}

	@Override
	public Pager<News> listByTitle(String title) {
		// TODO Auto-generated method stub
		String hql = "from News where title like :title order by createTime desc";
		Map<String,Object> alias = new HashMap<String,Object>();
		alias.put("title", "%" + title + "%");
		return findByAlias(hql, alias);
	}

	@Override
	public List<News> findAll() {
		String hql = "from News order by createTime desc";
		return list(hql);
	}

	@Override
	public List<News> findNewAll() {
		// TODO Auto-generated method stub
		String hql = "from News order by createTime desc";
		
		return this.getSession().createQuery(hql).setFirstResult(0).setMaxResults(5).list();
	}

	@Override
	public List<News> findrdAll() {
	String hql = "from News order by djs desc";
		return this.getSession().createQuery(hql).setFirstResult(0).setMaxResults(5).list();
	}

	@Override
	public List<News> findZxAll() {
		String hql = "from News where type = 2 order by createTime desc";
		return this.getSession().createQuery(hql).setFirstResult(0).setMaxResults(5).list();
	}

	@Override
	public List<News> findShAll() {
		String hql = "from News where type = 3 order by createTime desc";
		return this.getSession().createQuery(hql).setFirstResult(0).setMaxResults(5).list();
	}

	@Override
	public Pager<News> newListByType(News news) {
		String hql = "from News where  type = :type order by createTime desc";
		Map<String,Object> alias = new HashMap<String,Object>();
		alias.put("type", news.getType());
		return findByAlias(hql, alias);
	}

	@Override
	public Pager<News> newListByztId(int ztId) {
		String hql = "from News n where  n.type = 0 and n.special.id = :ztId  order by createTime desc";
		Map<String,Object> alias = new HashMap<String,Object>();
		alias.put("ztId", ztId);
		return findByAlias(hql, alias);
	}

	@Override
	public Pager<News> newListByKey(String key) {
		String hql = "from News where title like :title or content like :key2 order by createTime desc";
		Map<String,Object> alias = new HashMap<String,Object>();
		alias.put("title", "%" + key + "%");
		alias.put("key2", "%" + key + "%");
		return findByAlias(hql, alias);
	}

}
