package com.jssf.newsClient.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jssf.newsClient.model.Advertisement;
import com.jssf.newsClient.model.Extension;
import com.jssf.newsClient.model.News;
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

import net.sf.json.JSONObject;


@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
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
	public int getOtherId() {
		return otherId;
	}
	public void setOtherId(int otherId) {
		this.otherId = otherId;
	}

	private int groupId;
	private int friendId;

	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	private static final long serialVersionUID = 1L;

	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private User user;
	//========================图片上传
    private File file;
    
    public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	//提交过来的file的名字
    private String fileFileName;
    
    //提交过来的file的MIME类型
    private String fileContentType;

	//========================图片上传
	@Override
	public User getModel() {
		if(user==null) user = new User();
		return user;
	}
	/**
	 * 跳转到index页面
	 * @return
	 */
	public String index(){
		//1查询合作站点以及友情链接
		List<Extension> es = extensionService.findAll();
		ActionContext.getContext().put("es", es);
		//2专题
		List<Special> ss = specialService.findAll();
		ActionContext.getContext().put("ss", ss);
		//新闻列表展示 包括 首页轮播 以及新闻资讯 社会新闻
		List<News> ns =newsService.findAll();
		ActionContext.getContext().put("ns", ns);
		//最新新闻
		List<News> ns2 =newsService.findNewAll();
		ActionContext.getContext().put("ns2", ns2);
		//热点新闻
		List<News> ns3 =newsService.findrdAll();
		ActionContext.getContext().put("ns3", ns3);
		//新闻资讯
		List<News> ns4 =newsService.findZxAll();
		ActionContext.getContext().put("ns4", ns4);
		//社会新闻
		List<News> ns5 =newsService.findShAll();
		ActionContext.getContext().put("ns5", ns5);
		//广告
		List<Advertisement> allAdvertise = advertisementService.allAdvertise();
		ActionContext.getContext().put("allAdvertise", allAdvertise);
		return "index";
	}
	//登陆
	public void login() throws IOException{
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.setContentType("application/json;charset=UTF-8");
			PrintWriter out = null;
			JSONObject js = new JSONObject();
		User u =userService.load(user);
		if(u == null){
			js.put("message", 1);
		}else{
		HttpSession session =	ServletActionContext.getRequest().getSession();
		session.setAttribute("userName", u.getUserName());
		session.setAttribute("userId", u.getId());
		js.put("message", 2);
		}
		out = resp.getWriter();
		 out.write(js.toString());
		
	}
	public String list() throws IllegalAccessException, InvocationTargetException {
		User tu = (User)ActionContext.getContext().getSession().get("loginUser");
		ActionContext.getContext().put("list", userService.listAllCanSendUser(1));
		return SUCCESS;
	}
	public String add() {
		userService.add(user);
		return "success";
	}
	public String info() {
		//1查询合作站点以及友情链接
				List<Extension> es = extensionService.findAll();
				ActionContext.getContext().put("es", es);
				//2专题
				List<Special> ss = specialService.findAll();
				ActionContext.getContext().put("ss", ss);
		   HttpSession session =	ServletActionContext.getRequest().getSession();
		   if(session.getAttribute("userId") != null){
			   int userId = Integer.parseInt( session.getAttribute("userId").toString());
			  User u = userService.loadById(userId);
			  System.out.println(u.getId());
			  System.out.println(u.getPassWord());
			  System.out.println(u.getPhone());
			  System.out.println(u.getUserName());
			   ActionContext.getContext().put("user2", u);
			   return SUCCESS;
		   }else{
			   return "login";
		   }
		
	}
	
	public String updateUser(){
		//User u  =userService.loadUserById(user.getId());
		userService.update(user);
		return "login";
	}
	
}  
