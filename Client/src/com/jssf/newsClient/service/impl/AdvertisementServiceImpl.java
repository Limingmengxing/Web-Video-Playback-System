package com.jssf.newsClient.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jssf.newsClient.dao.AdvertisementDao;
import com.jssf.newsClient.model.Advertisement;
import com.jssf.newsClient.service.AdvertisementService;
import com.jssf.newsClient.utils.Pager;

@Service
public class AdvertisementServiceImpl implements AdvertisementService{
	@Autowired 
  private AdvertisementDao advertisementDao;
	public Pager<Advertisement> list(Advertisement advertisement) {
		// TODO Auto-generated method stub
		return advertisementDao.list(advertisement);
	}

	public void add(Advertisement advertisement) {
		advertisementDao.add(advertisement);
	}

	public Advertisement getById(int id) {
		return advertisementDao.load(id);
	}

	public void updateInfo(Advertisement advertisement) {
		advertisementDao.update(advertisement);
	}

	public void deleteInfo(int id) {
		advertisementDao.delete(id);
	}

	public List<Advertisement> allAdvertise() {
		// TODO Auto-generated method stub
		return advertisementDao.allAdvertise();
	}

}
