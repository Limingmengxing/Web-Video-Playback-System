package com.jssf.newsClient.action;
/**
 * 和登陆有关的都在这里
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jssf.newsClient.model.Extension;
import com.jssf.newsClient.model.Special;
import com.jssf.newsClient.model.User;
import com.jssf.newsClient.service.AdvertisementService;
import com.jssf.newsClient.service.ExtensionService;
import com.jssf.newsClient.service.NewsService;
import com.jssf.newsClient.service.SpecialService;
import com.jssf.newsClient.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport implements ModelDriven<User>{
	private User user;
	@Autowired
	private UserService userService;
	private int otherId;
	@Autowired
    private ExtensionService extensionService;
	@Autowired
    private SpecialService specialService;
	@Autowired
    private NewsService newsService;
	@Autowired
	private AdvertisementService advertisementService;
	@Override
	public User getModel() {
		if(user==null) user = new User();
		return user;
	}
	//首页
	public String index(){
		return "success";
	}
	//登陆页面
	public String login() {
		//1查询合作站点以及友情链接
				List<Extension> es = extensionService.findAll();
				ActionContext.getContext().put("es", es);
				//2专题
				List<Special> ss = specialService.findAll();
				ActionContext.getContext().put("ss", ss);
		return "success";
	}
   //注册页面
	public void register() throws IOException {
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = null;
		JSONObject js = new JSONObject();
		user.setCreateTime(new Date());
		User u = userService.isregister(user);
		if(u != null){
			js.put("message", "用户名已存在！");
		}else{
			userService.add(user);
			js.put("message", "注册成功！");
		}
		out = resp.getWriter();
		 out.write(js.toString());
	}
   //退出
	public String tuichu() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		session.remove("userName");
		session.remove("userId");
		//1查询合作站点以及友情链接
		List<Extension> es = extensionService.findAll();
		ActionContext.getContext().put("es", es);
		//2专题
		List<Special> ss = specialService.findAll();
		ActionContext.getContext().put("ss", ss);
		return "login";
	}
}
