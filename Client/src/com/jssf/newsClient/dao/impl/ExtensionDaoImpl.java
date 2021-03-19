package com.jssf.newsClient.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jssf.newsClient.base.dao.impl.BaseDaoImpl;
import com.jssf.newsClient.dao.ExtensionDao;
import com.jssf.newsClient.model.Extension;
import com.jssf.newsClient.utils.Pager;
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

	@Override
	public List<Extension> findAll() {
		String hql = "from Extension";
		return list(hql);
	}

}
