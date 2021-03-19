package com.jssf.newsManage.service;

import java.util.List;

import com.jssf.newsManage.base.service.BaseService;
import com.jssf.newsManage.model.News;
import com.jssf.newsManage.model.User;
import com.jssf.newsManage.utils.Pager;



public interface NewsService  extends BaseService<News>{

	Pager<News> list(String title);

	void add(News news);

	News load(News news);

	void update(News news);

	void del(News news);

	void addInfo(News news);

}
