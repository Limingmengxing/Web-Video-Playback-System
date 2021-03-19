package com.jssf.newsManage.model;




import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 骞垮憡
 * 
 *
 */
@Entity
@Table(name="t_advertisement")
public class Advertisement {
	private int id;
	private int address;//所在位置 1 2 3 
	private String hrefs;//广告地址
	private Date createTime;//创建时间
	private String title;//广告名称
	private double price;//价格
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	public String getHrefs() {
		return hrefs;
	}
	public void setHrefs(String hrefs) {
		this.hrefs = hrefs;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
