package com.jssf.newsClient.service;


import java.util.List;

import com.jssf.newsClient.model.News;
import com.jssf.newsClient.utils.Pager;


public interface NewsService {

	Pager<News> list(String title);

	void add(News news);

	News load(News news);

	void update(News news);

	void del(News news);

	List<News> findAll();

	List<News> findNewAll();

	List<News> findrdAll();

	List<News> findZxAll();

	List<News> findShAll();

	Pager<News> newListByType(News news);

	Pager<News> newListByztId(int ztId);

	Pager<News> newListByKey(String key);

}
