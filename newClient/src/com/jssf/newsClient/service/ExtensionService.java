package com.jssf.newsClient.service;

import java.util.List;

import com.jssf.newsClient.model.Extension;
import com.jssf.newsClient.utils.Pager;

public interface ExtensionService {

	Pager<Extension> list(Extension extension);

	void add(Extension extension);

	Extension getById(int id);

	void updateInfo(Extension extension);

	void deleteInfo(int id);

	List<Extension> findAll();

}
