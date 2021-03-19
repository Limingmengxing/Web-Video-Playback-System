package com.jssf.newsManage.service;

import java.util.List;

import com.jssf.newsManage.model.Advertisement;
import com.jssf.newsManage.utils.Pager;

public interface AdvertisementService {

	Pager<Advertisement> list(Advertisement advertisement);

	void add(Advertisement advertisement);

	Advertisement getById(int id);

	void updateInfo(Advertisement advertisement);

	void deleteInfo(int id);

	List<Advertisement> allAdvertise();

}
