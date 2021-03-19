package com.jssf.newsManage.service;

import com.jssf.newsManage.model.Extension;
import com.jssf.newsManage.utils.Pager;

public interface ExtensionService {

	Pager<Extension> list(Extension extension);

	void add(Extension extension);

	Extension getById(int id);

	void updateInfo(Extension extension);

	void deleteInfo(int id);

}
