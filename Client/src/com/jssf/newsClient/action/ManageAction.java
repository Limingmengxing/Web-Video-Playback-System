package com.jssf.newsClient.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Pie;
import com.jssf.newsClient.model.Manage;
import com.jssf.newsClient.model.User;
import com.jssf.newsClient.service.ManageService;
import com.jssf.newsClient.service.MessageService;
import com.jssf.newsClient.service.UserService;
import com.jssf.newsClient.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
@Controller("manageAction")
@Scope("prototype")
public class ManageAction extends ActionSupport implements ModelDriven<Manage>{
   private Manage manage;
   @Autowired
	private UserService userService;
    @Autowired
   private ManageService manageService;
    @Autowired
	private MessageService messageService;
    private int userId;
    private String userName;
    private int sayId;
    
    
    public int getSayId() {
		return sayId;
	}
	public void setSayId(int sayId) {
		this.sayId = sayId;
	}

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
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public Manage getModel() {
		if(manage==null) manage = new Manage();
		return manage;
	}
   
	/**
	 * ????????????????????????
	 * @return
	 */
	public String index(){
		Manage ma =	manageService.login(manage);
		if(ma == null){
			return "login";
		}
		HttpSession session =	ServletActionContext.getRequest().getSession();
		session.setAttribute("userName", ma.getName());
		session.setAttribute("userId", ma.getId());
	    return SUCCESS;
	}
	
	/**
	 * ??????????????????
	 * @return
	 */
	public String userList(){
	Pager<User>	pagers = userService.listAll(userName);
	//?????????????????????????????????
	/*List<Grade> list = gradeService.list();
	if(pagers != null && pagers.getDatas() != null && pagers.getDatas().size()>0){
		for(User u : pagers.getDatas()){
			//??????????????? ????????????
			for(Grade g: list){
				if(u.getJifen()>=g.getStartMin() && u.getJifen() <=g.getEndMax()){
					u.setDengji(g.getName());
				}
			}
		}
	}*/
	ActionContext.getContext().put("pagers", pagers);
	ActionContext.getContext().put("userName1", userName);
	return SUCCESS;
	}
	
	/**
	 * ????????????id??????????????????
	 * @return
	 */
	/*public String userPhotos(){
		Pager<SayMood>	pagers = sayMoodService.findAllphotosById(userId);
		ActionContext.getContext().put("pagers", pagers);
		return SUCCESS;
	}
	*/
	/**
	 * ????????????
	 * @return
	 */
	/*public String delsay(){
		 sayMoodService.del(sayId);
		ActionContext.getContext().put("url", "/manage_userPhotos.do");
		return "redirect";
	}*/
	//????????????
	public String delUse(){
		userService.delUse(userId);
		ActionContext.getContext().put("url", "/manage_userList.do");
		return "redirect";
	}
	
	//???????????????
	
	public String jinggao(){
		messageService.updatejinggao(userId);
		ActionContext.getContext().put("url", "/manage_userList.do");
		return "redirect";
	}
	/**
	 * ????????????
	 * @return
	 * @throws Exception
	 */
	/*public String fileUpload() throws Exception{
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
	
	public String report(){
		return SUCCESS;
	}
	//??????????????????
	/**
	 * ??????????????????????????? ????????????
	 * @throws IOException 
	 */
	public void reportUser() throws IOException{
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = null;
		//?????????????????????????????????????????????
		List<User>	users = userService.findSYuser();
		List<User>	users2 = userService.findBYuser();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("NAME", getsy());
		if(users != null && users.size()>0){
			map1.put("TOTAL", users.size());
		}else{
			map1.put("TOTAL", 0);
		}
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("NAME", getBy());
		if(users2 != null && users2.size()>0){
			map2.put("TOTAL", users2.size());
		}else{
			map2.put("TOTAL", 0);
		}
		list.add(map1);
		list.add(map2);
		
		 //??????Option
	    GsonOption option = new GsonOption();
	    option.title("????????????").tooltip(Trigger.axis).legend("???????????????");
	    //???????????????
	    option.xAxis(new ValueAxis().boundaryGap(0d, 0.01));
	    //???????????????
	    CategoryAxis category = new CategoryAxis();
	    //????????????
	    Bar bar = new Bar("??????");
	    //????????????
	    Pie pie = new Pie("??????");
	    //????????????
	    for (Map<String, Object> objectMap : list) {
	        //????????????
	        category.data(objectMap.get("NAME"));
	        //????????????????????????
	        bar.data(objectMap.get("TOTAL"));
	        //????????????
	        pie.data(new PieData(objectMap.get("NAME").toString(), objectMap.get("TOTAL")));
	    }
	    //???????????????
	    option.yAxis(category);
	    //????????????????????????
	    pie.center(900,380).radius(100);
	    //????????????
	    option.series(bar, pie);
	    //?????????????????????????????????????????????????????????180?????????grid?????????ECharts???????????????
	    option.grid().x(180);
	    //??????Option
	    out = resp.getWriter();
		 out.write(option.toString());
	}
	
	
	  public String getBy(){
		  Calendar c = Calendar.getInstance();
		   c.add(Calendar.MONTH, -0);
		  SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM");
		  String time = format.format(c.getTime());
		  System.out.println(time);
		  return time;
	}
	  
	  public String getsy(){
		  Calendar c = Calendar.getInstance();
		   c.add(Calendar.MONTH, -1);
		  SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM");
		  String time = format.format(c.getTime());
		  System.out.println(time);
		  return time;
	}
	  
	  
	  public void reportSay() throws IOException{/*
		  HttpServletResponse resp = ServletActionContext.getResponse();
			resp.setContentType("application/json;charset=UTF-8");
			PrintWriter out = null;
			//?????????????????????????????????????????????
			List<SayMood>	users = sayMoodService.findSYusay();
			List<SayMood>	users2 = sayMoodService.findBYsay();
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("NAME", getsy());
			if(users != null && users.size()>0){
				map1.put("TOTAL", users.size());
			}else{
				map1.put("TOTAL", 0);
			}
			
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("NAME", getBy());
			if(users2 != null && users2.size()>0){
				map2.put("TOTAL", users2.size());
			}else{
				map2.put("TOTAL", 0);
			}
			list.add(map1);
			list.add(map2);
			
			 //??????Option
		    GsonOption option = new GsonOption();
		    option.title("???????????????").tooltip(Trigger.axis).legend("???????????????");
		    //???????????????
		    option.xAxis(new ValueAxis().boundaryGap(0d, 0.01));
		    //???????????????
		    CategoryAxis category = new CategoryAxis();
		    //????????????
		    Bar bar = new Bar("??????");
		    //????????????
		    Pie pie = new Pie("??????");
		    //????????????
		    for (Map<String, Object> objectMap : list) {
		        //????????????
		        category.data(objectMap.get("NAME"));
		        //????????????????????????
		        bar.data(objectMap.get("TOTAL"));
		        //????????????
		        pie.data(new PieData(objectMap.get("NAME").toString(), objectMap.get("TOTAL")));
		    }
		    //???????????????
		    option.yAxis(category);
		    //????????????????????????
		    pie.center(900,380).radius(100);
		    //????????????
		    option.series(bar, pie);
		    //?????????????????????????????????????????????????????????180?????????grid?????????ECharts???????????????
		    option.grid().x(180);
		    //??????Option
		    out = resp.getWriter();
			 out.write(option.toString());
	  */}
}
