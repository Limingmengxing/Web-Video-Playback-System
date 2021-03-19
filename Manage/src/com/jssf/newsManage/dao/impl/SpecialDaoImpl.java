package com.jssf.newsManage.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jssf.newsManage.base.dao.impl.BaseDaoImpl;
import com.jssf.newsManage.dao.NewsDao;
import com.jssf.newsManage.dao.SpecialDao;
import com.jssf.newsManage.model.News;
import com.jssf.newsManage.model.Special;
import com.jssf.newsManage.utils.Pager;
@Repository("specialDao")
@SuppressWarnings("unchecked")
public class SpecialDaoImpl extends BaseDaoImpl<Special>  implements SpecialDao{

	public Pager<Special> list(Special special) {
		String hql = "from Special";
		if(special.getName() != null && !"".equals(special.getName()) ){
			hql += " where name = :name";
			Map<String,Object> alias = new HashMap<String,Object>();
			alias.put("name", special.getName());
			return findByAlias(hql, alias);
		}else{
			return findByAlias(hql, null);
		}
		
	}

	public List<Special> allSpecial() {
		String hql = "from Special";
		return this.getSession().createQuery(hql).list();
	}

}
