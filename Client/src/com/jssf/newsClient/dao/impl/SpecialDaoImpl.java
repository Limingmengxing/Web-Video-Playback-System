package com.jssf.newsClient.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jssf.newsClient.base.dao.impl.BaseDaoImpl;
import com.jssf.newsClient.dao.SpecialDao;
import com.jssf.newsClient.model.Special;
import com.jssf.newsClient.utils.Pager;

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

	@Override
	public List<Special> findAll() {
		String hql = "from Special";
		return this.getSession().createQuery(hql).list();
	}

}
