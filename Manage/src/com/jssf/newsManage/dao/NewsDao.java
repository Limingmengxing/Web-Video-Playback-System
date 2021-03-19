package com.jssf.newsManage.dao;


import java.util.List;

import com.jssf.newsManage.base.dao.BaseDao;
import com.jssf.newsManage.model.News;
import com.jssf.newsManage.utils.Pager;

public interface NewsDao extends BaseDao<News>{

	Pager<News> list();

	Pager<News> listByTitle(String title);

}
