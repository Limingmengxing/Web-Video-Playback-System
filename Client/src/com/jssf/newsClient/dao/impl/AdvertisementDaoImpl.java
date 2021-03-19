package com.jssf.newsClient.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jssf.newsClient.base.dao.impl.BaseDaoImpl;
import com.jssf.newsClient.dao.AdvertisementDao;
import com.jssf.newsClient.model.Advertisement;
import com.jssf.newsClient.utils.Pager;

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
