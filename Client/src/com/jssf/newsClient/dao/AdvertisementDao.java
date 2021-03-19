package com.jssf.newsClient.dao;


import java.util.List;

import com.jssf.newsClient.base.dao.BaseDao;
import com.jssf.newsClient.model.Advertisement;
import com.jssf.newsClient.utils.Pager;


public interface AdvertisementDao extends BaseDao<Advertisement> {

	Pager<Advertisement> list(Advertisement advertisement);

	List<Advertisement> allAdvertise();

}
