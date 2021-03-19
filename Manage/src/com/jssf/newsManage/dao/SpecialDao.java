package com.jssf.newsManage.dao;

import java.util.List;

import com.jssf.newsManage.base.dao.BaseDao;
import com.jssf.newsManage.model.Special;
import com.jssf.newsManage.model.User;
import com.jssf.newsManage.utils.Pager;

public interface SpecialDao extends BaseDao<Special>{

	Pager<Special> list(Special special);

	List<Special> allSpecial();

}
