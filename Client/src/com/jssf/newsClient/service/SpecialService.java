package com.jssf.newsClient.service;


import java.util.List;

import com.jssf.newsClient.model.Special;
import com.jssf.newsClient.utils.Pager;


public interface SpecialService {

	Pager<Special> list(Special special);

	void add(Special special);

	Special getById(int id);

	void updateInfo(Special special);

	void deleteInfo(int id);

	List<Special> allSpecial();

	List<Special> findAll();

}
