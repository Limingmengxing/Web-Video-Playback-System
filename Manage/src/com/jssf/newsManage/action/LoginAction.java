package com.jssf.newsManage.action;
/**
 * 和登陆有关的都在这里
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jssf.newsManage.model.User;
import com.jssf.newsManage.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport implements ModelDriven<User>{
	private User user;
	public User getModel() {
		if(user==null) user = new User();
		return user;
	}
	@Autowired
	private UserService userService;
	//首页
	public String index(){
		return "success";
	}
	//登陆页面
	public String login() {
		return "success";
	}
   //退出
	public String tuichu() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		session.remove("userName");
		session.remove("userId");
		return "login";
	}
}
