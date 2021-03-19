package com.jssf.newsManage.model;



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
 * 评论
 * @author 
 *
 */
@Entity
@Table(name="t_comment")
public class Comment {
	private int id;
	private String content;//内容
	private User comUser;//评论人
	private Date createTime;
	private News news;//对应的新闻
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="news_id")
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="comuser_id")
	public User getComUser() {
		return comUser;
	}
	public void setComUser(User comUser) {
		this.comUser = comUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
