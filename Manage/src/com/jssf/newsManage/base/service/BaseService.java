package com.jssf.newsManage.base.service;

import java.util.List;

public interface BaseService<T> {
	    public void save(T entity);  
	  
	    public void update(T entity);  
	  
	    public void delete(int id);  
	  
	    public T getById(int id);  
	  
	    public List<T> getByHQL(String hql, Object... params);  
}
