package com.jssf.newsClient.dao;
import java.util.List;

import com.jssf.newsClient.base.dao.BaseDao;
import com.jssf.newsClient.model.Special;
import com.jssf.newsClient.utils.Pager;

public interface SpecialDao extends BaseDao<Special>{

	Pager<Special> list(Special special);

	List<Special> allSpecial();

	List<Special> findAll();

}
