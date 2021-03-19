package com.jssf.newsManage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jssf.newsManage.dao.SpecialDao;
import com.jssf.newsManage.model.Special;
import com.jssf.newsManage.service.SpecialService;
import com.jssf.newsManage.utils.Pager;
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

}
