package com.jssf.newsManage.dao;

import com.jssf.newsManage.base.dao.BaseDao;
import com.jssf.newsManage.model.Comment;
import com.jssf.newsManage.model.Extension;
import com.jssf.newsManage.utils.Pager;

public interface ExtensionDao extends BaseDao<Extension>{

	Pager<Extension> load(Extension extension);

}
