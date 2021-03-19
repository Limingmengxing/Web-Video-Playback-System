package com.jssf.newsManage.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jssf.newsManage.base.dao.impl.BaseDaoImpl;
import com.jssf.newsManage.dao.ManageDao;
import com.jssf.newsManage.model.Manage;
import com.jssf.newsManage.model.News;
import com.jssf.newsManage.utils.Pager;


@Repository("manageDao")
@SuppressWarnings("unchecked")
public class ManageDaoImpl extends BaseDaoImpl<Manage>  implements ManageDao{

	public Manage login(Manage manage) {
		String hql = "from Manage bean where bean.name =:userName and bean.passWord= :passWord";
		Query q =this.getSession().createQuery(hql);
		q.setParameter("userName", manage.getName());
		q.setParameter("passWord", manage.getPassWord());
		return (Manage)q.uniqueResult();
	}
//======================================================================================================
	public Pager<Manage> list() {
		String hql = "from Manage where type = 2 ";
		return findByAlias(hql, null);
	}
	public Pager<Manage> listBy(String name) {
		String hql = "from Manage  where  type = 2 and realName = :name ";
		Map<String,Object> alias = new HashMap<String,Object>();
		alias.put("name", name);
		return findByAlias(hql, alias);
	}

}
