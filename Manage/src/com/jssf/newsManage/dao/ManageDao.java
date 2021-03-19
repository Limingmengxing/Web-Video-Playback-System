package com.jssf.newsManage.dao;

import com.jssf.newsManage.base.dao.BaseDao;
import com.jssf.newsManage.model.Manage;
import com.jssf.newsManage.model.News;
import com.jssf.newsManage.utils.Pager;

public interface ManageDao extends BaseDao<Manage>{

	Manage login(Manage manage);

	Pager<Manage> list();

	Pager<Manage> listBy(String name);

}
