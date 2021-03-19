package com.jssf.newsClient.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jssf.newsClient.dao.ExtensionDao;
import com.jssf.newsClient.model.Extension;
import com.jssf.newsClient.service.ExtensionService;
import com.jssf.newsClient.utils.Pager;
@Service("extensionService")
public class ExtensionServiceImpl implements ExtensionService{
     @Autowired
	private ExtensionDao extensionDao;
	public Pager<Extension> list(Extension extension) {
		return extensionDao.load(extension);
	}

	public void add(Extension extension) {
		// TODO Auto-generated method stub
		extensionDao.add(extension);
	}

	public Extension getById(int id) {
		// TODO Auto-generated method stub
		return extensionDao.load(id);
	}

	public void updateInfo(Extension extension) {
		// TODO Auto-generated method stub
		extensionDao.update(extension);
	}

	public void deleteInfo(int id) {
		// TODO Auto-generated method stub
		extensionDao.delete(id);
	}

	@Override
	public List<Extension> findAll() {
		// TODO Auto-generated method stub
		return extensionDao.findAll();
	}

}
