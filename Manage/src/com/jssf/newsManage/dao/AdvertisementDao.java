package com.jssf.newsManage.dao;

import java.util.List;

import com.jssf.newsManage.base.dao.BaseDao;
import com.jssf.newsManage.model.Advertisement;
import com.jssf.newsManage.utils.Pager;

public interface AdvertisementDao extends BaseDao<Advertisement> {

	Pager<Advertisement> list(Advertisement advertisement);

	List<Advertisement> allAdvertise();

}
