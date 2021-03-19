package com.jssf.newsManage.action;



import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jssf.newsManage.model.Comment;
import com.jssf.newsManage.service.CommentService;
import com.jssf.newsManage.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("commentAction")
@Scope("prototype")
public class CommentAction extends ActionSupport implements ModelDriven<Comment>{
private Comment comment;
private int sayMoodId;
private int otherId;
@Autowired
private CommentService CommentService;
public int getOtherId() {
	return otherId;
}

public void setOtherId(int otherId) {
	this.otherId = otherId;
}

public int getSayMoodId() {
	return sayMoodId;
}

public void setSayMoodId(int sayMoodId) {
	this.sayMoodId = sayMoodId;
}


	public Comment getModel() {
		if(comment==null) comment = new Comment();
		return comment;
	}
	
	/**
	 * 评论
	 * @return
	 */
	/*public String comment() {
		HttpSession session =	ServletActionContext.getRequest().getSession();
		if(session.getAttribute("userId") != null){
			int userId = Integer.parseInt( session.getAttribute("userId").toString());
			CommentService.save(comment,userId,sayMoodId);
		}else{
			return "login";
		}
		ActionContext.getContext().put("url", "/sayMood_photoDetail.do?id="+sayMoodId+"&otherId="+otherId);
		return "redirect";
	}*/
	
	//评论说说 文字
	public String huifutext() {
		HttpSession session =	ServletActionContext.getRequest().getSession();
		if(session.getAttribute("userId") != null){
			int userId = Integer.parseInt( session.getAttribute("userId").toString());
			CommentService.save(comment,userId,sayMoodId);
		}else{
			return "login";
		}
		ActionContext.getContext().put("url", "/sayMood_shuoshuoList.do");
		return "redirect";
	}
	/**
	 * 回复
	 * @return
	 */
	public String huifu() {
		HttpSession session =	ServletActionContext.getRequest().getSession();
		if(session.getAttribute("userId") != null){
			int userId = Integer.parseInt( session.getAttribute("userId").toString());
			CommentService.savehuifu(comment,userId);
		}else{
			return "login";
		}
		ActionContext.getContext().put("url", "/sayMood_photoDetail.do?id="+sayMoodId+"&otherId="+otherId);
		return "redirect";
	}

	//说说文字回复
	public String huifuhft() {
		HttpSession session =	ServletActionContext.getRequest().getSession();
		if(session.getAttribute("userId") != null){
			int userId = Integer.parseInt( session.getAttribute("userId").toString());
			CommentService.savehuifu(comment,userId);
		}else{
			return "login";
		}
		ActionContext.getContext().put("url", "/sayMood_shuoshuoList.do");
		return "redirect";
	}
	
	public String comment(){
		Pager<Comment> pager = CommentService.findComment(otherId);
		ActionContext.getContext().put("pagers", pager);
		ActionContext.getContext().put("otherId", otherId);
		return  SUCCESS;
	}
	
	public String delComment(){
		//Pager<Comment> pager = CommentService.findComment(otherId);
		Comment c =	CommentService.getById(comment.getId());
		CommentService.deleteInfo(comment.getId());
		int otherId = c.getNews().getId();
		ActionContext.getContext().put("url", "/comment_comment.do?otherId="+otherId);
		return "redirect";
	}
}
