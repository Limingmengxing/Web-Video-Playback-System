package com.jssf.newsManage.service;

import com.jssf.newsManage.base.service.BaseService;
import com.jssf.newsManage.model.Manage;
import com.jssf.newsManage.model.News;
import com.jssf.newsManage.model.User;
import com.jssf.newsManage.utils.Pager;

public interface ManageService  extends BaseService<Manage>{

	Manage login(Manage manage);

	Pager<Manage> list(Manage manage);

	void updateInfo(Manage manage);

	void deleteInfo(int id);

}
