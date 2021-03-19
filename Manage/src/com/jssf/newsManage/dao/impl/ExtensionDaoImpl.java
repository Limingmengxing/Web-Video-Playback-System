package com.jssf.newsManage.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jssf.newsManage.base.dao.impl.BaseDaoImpl;
import com.jssf.newsManage.dao.ExtensionDao;
import com.jssf.newsManage.model.Extension;
import com.jssf.newsManage.utils.Pager;
@Repository("extensionDao")
@SuppressWarnings("unchecked")
public class ExtensionDaoImpl extends BaseDaoImpl<Extension>  implements ExtensionDao{

	public Pager<Extension> load(Extension extension) {
		String hql = "from Extension";
		if(extension.getName() != null && !"".equals(extension.getName()) ){
			hql += " where name = :name";
			Map<String,Object> alias = new HashMap<String,Object>();
			alias.put("name", extension.getName());
			return findByAlias(hql, alias);
		}else{
			return findByAlias(hql, null);
		}
	}

}
