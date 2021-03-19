package com.jssf.newsClient.dao;

import java.util.List;

import com.jssf.newsClient.base.dao.BaseDao;
import com.jssf.newsClient.model.Extension;
import com.jssf.newsClient.utils.Pager;

public interface ExtensionDao extends BaseDao<Extension>{

	Pager<Extension> load(Extension extension);

	List<Extension> findAll();

}
