package com.jssf.newsManage.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jssf.newsManage.base.service.impl.BaseServiceImpl;
import com.jssf.newsManage.dao.NewsDao;
import com.jssf.newsManage.model.News;
import com.jssf.newsManage.model.User;
import com.jssf.newsManage.service.NewsService;
import com.jssf.newsManage.utils.Pager;


@Service
public class NewsServiceImpl extends BaseServiceImpl<News> implements NewsService{
	@Autowired
	private NewsDao newsDao;

	public Pager<News> list(String title) {
		if(title == null || "".equals(title)){
			return newsDao.list();
		}else{
			return newsDao.listByTitle(title);
		}
		
	}

	public void add(News news) {
		news.setCreateTime(new Date());
		newsDao.add(news);
	}

	public News load(News news) {
		return newsDao.load(news.getId());
	}

	public void update(News news) {
		News nn = newsDao.load(news.getId());
		nn.setContent(news.getContent());
		nn.setTitle(news.getTitle());
		newsDao.update(nn);
	}

	public void del(News news) {
		newsDao.delete(news.getId());
	}

	public void addInfo(News news) {
		// TODO Auto-generated method stub
		newsDao.add(news);
	}

}
