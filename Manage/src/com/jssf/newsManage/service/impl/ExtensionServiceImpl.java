package com.jssf.newsManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jssf.newsManage.dao.ExtensionDao;
import com.jssf.newsManage.model.Extension;
import com.jssf.newsManage.service.ExtensionService;
import com.jssf.newsManage.utils.Pager;
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

}
