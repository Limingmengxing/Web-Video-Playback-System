package com.jssf.newsClient.dao;

import com.jssf.newsClient.base.dao.BaseDao;
import com.jssf.newsClient.model.Manage;

public interface ManageDao extends BaseDao<Manage>{

	Manage login(Manage manage);

}
