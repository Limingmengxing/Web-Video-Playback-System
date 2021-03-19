package com.jssf.newsClient.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 推广类
 * @author 
 *
 */
@Entity
@Table(name="t_extension")
public class Extension {
	private int id;
	private String name;//合作站点 或者友情站点的名称
	private String hrefs;//链接
	private int type;//1 代表合作站点 2 代表友情站点
	private Date CreateTime;//创建时间
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHrefs() {
		return hrefs;
	}
	public void setHrefs(String hrefs) {
		this.hrefs = hrefs;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
	

}
