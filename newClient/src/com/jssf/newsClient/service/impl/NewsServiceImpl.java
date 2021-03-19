package com.jssf.newsClient.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jssf.newsClient.dao.NewsDao;
import com.jssf.newsClient.model.News;
import com.jssf.newsClient.service.NewsService;
import com.jssf.newsClient.utils.Pager;


@Service
public class NewsServiceImpl implements NewsService{
	@Autowired
	private NewsDao newsDao;

	@Override
	public Pager<News> list(String title) {
		if(title == null || "".equals(title)){
			return newsDao.list();
		}else{
			return newsDao.listByTitle(title);
		}
		
	}

	@Override
	public void add(News news) {
		news.setCreateTime(new Date());
		newsDao.add(news);
	}

	@Override
	public News load(News news) {
		return newsDao.load(news.getId());
	}

	@Override
	public void update(News news) {
		News nn = newsDao.load(news.getId());
		nn.setContent(news.getContent());
		nn.setTitle(news.getTitle());
		newsDao.update(nn);
	}

	@Override
	public void del(News news) {
		newsDao.delete(news.getId());
	}

	@Override
	public List<News> findAll() {
		// TODO Auto-generated method stub
		return newsDao.findAll();
	}

	@Override
	public List<News> findNewAll() {
		// TODO Auto-generated method stub
		return newsDao.findNewAll();
	}

	@Override
	public List<News> findrdAll() {
		// TODO Auto-generated method stub
		return newsDao.findrdAll();
	}

	@Override
	public List<News> findZxAll() {
		// TODO Auto-generated method stub
		return newsDao.findZxAll();
	}

	@Override
	public List<News> findShAll() {
		// TODO Auto-generated method stub
		return newsDao.findShAll();
	}

	@Override
	public Pager<News> newListByType(News news) {
		// TODO Auto-generated method stub
		return newsDao.newListByType(news);
	}

	@Override
	public Pager<News> newListByztId(int ztId) {
		// TODO Auto-generated method stub
		return newsDao.newListByztId(ztId);
	}

	@Override
	public Pager<News> newListByKey(String key) {
		// TODO Auto-generated method stub
		return newsDao.newListByKey(key);
	}

}
