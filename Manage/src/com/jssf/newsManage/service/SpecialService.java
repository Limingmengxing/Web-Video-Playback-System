package com.jssf.newsManage.service;

import java.util.List;

import com.jssf.newsManage.model.Special;
import com.jssf.newsManage.utils.Pager;

public interface SpecialService {

	Pager<Special> list(Special special);

	void add(Special special);

	Special getById(int id);

	void updateInfo(Special special);

	void deleteInfo(int id);

	List<Special> allSpecial();

}
