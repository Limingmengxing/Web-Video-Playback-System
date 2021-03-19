package com.jssf.newsManage.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jssf.newsManage.base.dao.BaseDao;
import com.jssf.newsManage.base.service.BaseService;

public class  BaseServiceImpl<T> implements BaseService<T>{
	/** 
     * 注入BaseDao 
     */  
	@Autowired
    private BaseDao<T> dao;  

	public BaseDao<T> getDao() {
		return dao;
	}

	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}

	public void save(T entity) {
		dao.add(entity);
	}

	public void update(T entity) {
		dao.update(entity);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public T getById(int id) {
		return dao.load(id);
	}

	public List<T> getByHQL(String hql, Object... params) {
		return null;
	}

}
