package com.jssf.newsManage.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jssf.newsManage.base.dao.impl.BaseDaoImpl;
import com.jssf.newsManage.dao.AdvertisementDao;
import com.jssf.newsManage.dao.ManageDao;
import com.jssf.newsManage.model.Advertisement;
import com.jssf.newsManage.model.Manage;
import com.jssf.newsManage.utils.Pager;
@Repository
@SuppressWarnings("unchecked")
public class AdvertisementDaoImpl extends BaseDaoImpl<Advertisement>  implements AdvertisementDao{

	public Pager<Advertisement> list(Advertisement advertisement) {
		String hql = "from Advertisement";
		if(advertisement.getTitle() != null && !"".equals(advertisement.getTitle()) ){
			hql += " where title = :title";
			Map<String,Object> alias = new HashMap<String,Object>();
			alias.put("title", advertisement.getTitle());
			return findByAlias(hql, alias);
		}else{
			return findByAlias(hql, null);
		}
	}

	public List<Advertisement> allAdvertise() {
		String hql = "from Advertisement";
		return this.getSession().createQuery(hql).list();
	}

}
