package com.jssf.newsManage.action;


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

import com.jssf.newsManage.model.User;
import com.jssf.newsManage.service.UserService;
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
	//========================????????????
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

	//???????????????file?????????
    private String fileFileName;
    
    //???????????????file???MIME??????
    private String fileContentType;

	//========================????????????
	public User getModel() {
		if(user==null) user = new User();
		return user;
	}
	public String index(){
		return "index";
	}
	//??????
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
	
	/**
	 * ????????????
	 * @return
	 */
	/*public String homePage() {
		HttpSession session =	ServletActionContext.getRequest().getSession();
		if(session.getAttribute("userId") != null){
			int userId = Integer.parseInt( session.getAttribute("userId").toString());
			//????????????????????????????????????
			//1.???????????? 
			 //  1)url
			Pager<SayMood> sayMoods = sayMoodService.loadPhoto(userId);
			ActionContext.getContext().put("sayMoods", sayMoods);
			//2.?????? ?????????????????????????????????
			List<Friend> friends = friendService.loadFriends(userId);
			//?????????????????????
			List<Friend> f1 = new ArrayList<Friend>();
			List<Friend> f2 = new ArrayList<Friend>();
			List<Friend> f3 = new ArrayList<Friend>();
			List<Friend> f4 = new ArrayList<Friend>();
			for(Friend fr : friends){
				if(fr.getUser().getId() == userId){
					fr.setName(fr.getFriendUser().getUserName());
				}
				if(fr.getFriendUser().getId() == userId){
					fr.setName(fr.getUser().getUserName());
				}
				//????????????????????????????????????
				if(fr.getGroups() == 1){
					
					f1.add(fr);
				}
				if(fr.getGroups() == 2){
					f2.add(fr);
				}
				if(fr.getGroups() == 3){
					f3.add(fr);
				}
				if(fr.getGroups() == 4){
					f4.add(fr);
				}
			}
			ActionContext.getContext().put("f1", f1);
			ActionContext.getContext().put("f2", f2);
			ActionContext.getContext().put("f3", f3);
			ActionContext.getContext().put("f4", f4);
			//3???????????? ???????????? ?????? ??????????????? 
			List<User> friendtus = friendService.loadTuiJian(userId);
			User u = userService.loadUserById(userId);
			ActionContext.getContext().put("js", u);
			ActionContext.getContext().put("tjs", friendtus);
			return SUCCESS;
		}else{
			return "login";
		}
	}*/
	
	/**
	 * ???????????????
	 * @return
	 */
	
	/*public String otherHomePage() {
		HttpSession session =	ServletActionContext.getRequest().getSession();
		if(session.getAttribute("userId") != null){
			int userId = Integer.parseInt( session.getAttribute("userId").toString());
			//????????????????????????????????????
			//1.???????????? 
			 //  1)url

			
			 * otherId??????????????????????????????id
			 * ???????????????????????????id??????
			 
			Friend frd =friendService.loadByid(otherId);
			int relId = 0;
			if(frd.getUser().getId() == userId){
				relId = frd.getFriendUser().getId();
			}else{
				relId = frd.getUser().getId();
			}
			Pager<SayMood> sayMoods = sayMoodService.loadPhoto(relId);
			ActionContext.getContext().put("sayMoods", sayMoods);
			
			
			//2.?????? ?????????????????????????????????
			List<Friend> friends = friendService.loadFriends(relId);
			//?????????????????????
			List<Friend> f1 = new ArrayList<Friend>();
			List<Friend> f2 = new ArrayList<Friend>();
			List<Friend> f3 = new ArrayList<Friend>();
			List<Friend> f4 = new ArrayList<Friend>();
			for(Friend fr : friends){
				if(fr.getUser().getId() == userId){
					fr.setName(fr.getFriendUser().getUserName());
				}
				if(fr.getFriendUser().getId() == userId){
					fr.setName(fr.getUser().getUserName());
				}
				//????????????????????????????????????
				if(fr.getGroups() == 1){
					
					f1.add(fr);
				}
				if(fr.getGroups() == 2){
					f2.add(fr);
				}
				if(fr.getGroups() == 3){
					f3.add(fr);
				}
				if(fr.getGroups() == 4){
					f4.add(fr);
				}
			}
			ActionContext.getContext().put("f1", f1);
			ActionContext.getContext().put("f2", f2);
			ActionContext.getContext().put("f3", f3);
			ActionContext.getContext().put("f4", f4);
			//3???????????? ???????????? ?????? ??????????????? 
		//	List<User> friendtus = friendService.loadTuiJian(otherId);
			User u = userService.loadUserById(relId);
			ActionContext.getContext().put("js", u);
			ActionContext.getContext().put("tjs", null);
			return "otherHomePage";
		}else{
			return "login";
		}
	}
	*//**
	 * ????????????
	 * @return
	 * @throws Exception
	 *//*
	public String fileUpload() throws Exception{
		HttpSession session =	ServletActionContext.getRequest().getSession();
		if(session.getAttribute("userId") != null){
			int userId = Integer.parseInt( session.getAttribute("userId").toString());
			
			 String root = ServletActionContext.getServletContext().getRealPath("/")+"upload";
			//String root = ServletActionContext.getServletContext().getRealPath("upload"); 
			//String root = ServletActionContext.getRequest().getContextPath()+"/"+"upload";
		        InputStream is = new FileInputStream(file);
		        fileFileName = UUIDUtils.create()+fileFileName;
		        OutputStream os = new FileOutputStream(new File(root, fileFileName));
		        System.out.println("fileFileName: " + fileFileName);
		        System.out.println("file: " + file.getName());
		        System.out.println("file: " + file.getPath());
		        byte[] buffer = new byte[500];
		        int length = 0;
		        
		        while(-1 != (length = is.read(buffer, 0, buffer.length)))
		        {
		            os.write(buffer);
		        }
		        os.close();
		        is.close();
		        //???????????????????????????
		        SayMood sayMood = new SayMood();
		        sayMood.setContent("\\upload\\"+fileFileName);
		        sayMood.setCreateTime(new Date());
		        sayMood.setDzs(0);
		        sayMood.setIsDelete(2);
		        sayMood.setType(2);
		        User u = userService.getUser(userId);
		        sayMood.setSayUser(u);
		        sayMoodService.save(sayMood);
		        *//**
		         * ??????????????????????????????????????????????????????
		         *//*
		        //???????????????????????????action
		        ActionContext.getContext().put("url", "/user_homePage.do");
		        return "redirect";
		}else{
			return "login";
		}
	}*/

	
       //================================================
		//???????????????????????????
		//================================================
		
	/**
	 * ????????????
	 * @return
	 */
		
		public String findFriend(){
			HttpSession session =	ServletActionContext.getRequest().getSession();
			if(session.getAttribute("userId") != null){
				int myId = Integer.parseInt( session.getAttribute("userId").toString());
				List<User> users= userService.findFriend(user.getUserName(),myId);
			 ActionContext.getContext().put("findName", user.getUserName());
			 ActionContext.getContext().put("findFriends", users);
			  ActionContext.getContext().put("url", "user_homePage");
			}
			return "chain";
		}
		
	/*	*//**
		 * ??????
		 * @return
		 *//*
		public String addFriend(){
			    //????????????id ???????????????????????????????????????
			HttpSession session =	ServletActionContext.getRequest().getSession();
			if(session.getAttribute("userId") != null){
				
				int myId = Integer.parseInt( session.getAttribute("userId").toString());
			//	HttpServletRequest request = ServletActionContext.getRequest();
			//int groupId= Integer.parseInt(request.getParameter("groupId").toString());
				 friendService.addFriend(myId,user.getId(),groupId);
			}
			
			 ActionContext.getContext().put("url", "user_homePage");
				return "chain";
		}*/
		
		/**
		 * ????????????
		 * @return
		 */
		/*public String deleteFriend(){
			friendService.deleteFriend(friendId);
			 ActionContext.getContext().put("url", "/user_homePage.do");
		        return "redirect";
		}*/
}  
