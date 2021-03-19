package com.jssf.newsClient.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jssf.newsClient.dao.SpecialDao;
import com.jssf.newsClient.model.Special;
import com.jssf.newsClient.service.SpecialService;
import com.jssf.newsClient.utils.Pager;

@Service
public class SpecialServiceImpl implements SpecialService{
	@Autowired
	private SpecialDao specialDao;

	public Pager<Special> list(Special special) {
		return specialDao.list(special);
	}

	public void add(Special special) {
		specialDao.add(special);
	}

	public Special getById(int id) {
		return specialDao.load(id);
	}

	public void updateInfo(Special special) {
		specialDao.update(special);
	}

	public void deleteInfo(int id) {
		specialDao.delete(id);
	}

	public List<Special> allSpecial() {
		// TODO Auto-generated method stub
		return specialDao.allSpecial();
	}

	@Override
	public List<Special> findAll() {
		// TODO Auto-generated method stub
		return specialDao.findAll();
	}

}
