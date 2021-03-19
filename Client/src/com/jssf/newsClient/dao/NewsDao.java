package com.jssf.newsClient.dao;


import java.util.List;

import com.jssf.newsClient.base.dao.BaseDao;
import com.jssf.newsClient.model.News;
import com.jssf.newsClient.utils.Pager;

public interface NewsDao extends BaseDao<News>{

	Pager<News> list();

	Pager<News> listByTitle(String title);

	List<News> findAll();

	List<News> findNewAll();

	List<News> findrdAll();

	List<News> findZxAll();

	List<News> findShAll();

	Pager<News> newListByType(News news);

	Pager<News> newListByztId(int ztId);

	Pager<News> newListByKey(String key);

}
