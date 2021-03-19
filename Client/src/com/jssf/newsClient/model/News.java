package com.jssf.newsClient.model;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * 新闻
 * @author
 *   <li class="dy-active"><a href="index.html">首页</a></li>
          <li><a href="list.html">体育</a></li>
          <li><a href="content.html">娱乐</a></li>
          <li><a href="#">文章</a></li>
          <li><a href="#">汽车</a></li>
          <li><a href="#">科技</a></li>
          <li><a href="#">健康</a></li>
          <li><a href="#">房产</a></li>
          <li><a href="http://www.5imoban.net/cssmoban/" target="_blank">家居</a></li>
           <li><a href="#">旅游</a></li>
           <li><a href="#">公益</a></li>
           <li><a href="#">交友天地</a></li>
          <li><a href="http://www.5imoban.net/texiao/" target="_blank">个人信息</a></li>
 *
 */
@Entity
@Table(name="t_news")
public class News {
	private int id;
	private String content;
	private Date createTime;
	private String title;//标题
	private String introduction;//简介
	private int type;//代表新闻类型 0.专题 1.热点要闻  2.新闻资讯 3体育 4娱乐 5文章 6汽车 7科技 8 健康9房产 10 家居11科技 12 旅游 13公益
	//0专题  1.热点要闻 2.新闻资讯 3社会新闻 4.最新资讯
	//5 体育 6 娱乐 7文章 8汽车 9科技 10 健康 11 房产 12 家居 13旅游 14 公益
	private Advertisement advertisement;//广告
	private int djs;//点击多少次
	private String titlePhoto;//缩略图
    private int isSY;//是否放置首页轮播图 1是 2否
	public int getIsSY() {
		return isSY;
	}
	public void setIsSY(int isSY) {
		this.isSY = isSY;
	}
	private Special special;//专题
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="special_id")
	public Special getSpecial() {
		return special;
	}
	public void setSpecial(Special special) {
		this.special = special;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="advertisement_id")
	public Advertisement getAdvertisement() {
		return advertisement;
	}
	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
	}
	public int getDjs() {
		return djs;
	}
	public void setDjs(int djs) {
		this.djs = djs;
	}
	public String getTitlePhoto() {
		return titlePhoto;
	}
	public void setTitlePhoto(String titlePhoto) {
		this.titlePhoto = titlePhoto;
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
	@Column(name ="content",nullable=true,length=6000)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
