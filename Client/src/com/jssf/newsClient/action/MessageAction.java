package com.jssf.newsClient.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jssf.newsClient.dto.MessageDto;
import com.jssf.newsClient.model.Advertisement;
import com.jssf.newsClient.model.Extension;
import com.jssf.newsClient.model.Message;
import com.jssf.newsClient.model.News;
import com.jssf.newsClient.model.Special;
import com.jssf.newsClient.model.UserMessage;
import com.jssf.newsClient.service.AdvertisementService;
import com.jssf.newsClient.service.ExtensionService;
import com.jssf.newsClient.service.MessageService;
import com.jssf.newsClient.service.NewsService;
import com.jssf.newsClient.service.SpecialService;
import com.jssf.newsClient.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller("messageAction")
@Scope("prototype")
public class MessageAction extends ActionSupport implements ModelDriven<Message> {
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
	private Message message;
	
	@Autowired
	private MessageService messageService;
	@Override
	public Message getModel() {
		if(message==null) message = new Message();
		return message;
	}
	/**
	 * 挑战
	 * @return
	 */
	public String message(){
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
		HttpSession session =	ServletActionContext.getRequest().getSession();
		if(session.getAttribute("userId") != null){
			return SUCCESS;
		}else{
			return "login";
		}
		
	}
	/**
	 * 页面一开始加载的时候，就进行聊天记录查询
	 * @throws IOException 
	 */
	public void findMessageJIluList() throws IOException{
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = null;
		HttpSession session =	ServletActionContext.getRequest().getSession();
		if(session.getAttribute("userId") != null){
			int userId = Integer.parseInt( session.getAttribute("userId").toString());
			List<MessageDto> messages = messageService.updateMessageJIluList(userId);
			out = resp.getWriter();
			 System.out.println(JSONArray.fromObject(messages).toString());
			 out.write(JSONArray.fromObject(messages).toString());
	    }
	}
	
	
	/**
	 * 发送消息
	 * @throws IOException
	 */
	public void sendMessage() throws IOException{
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = null;
		HttpSession session =	ServletActionContext.getRequest().getSession();
		if(session.getAttribute("userId") != null){
			int userId = Integer.parseInt( session.getAttribute("userId").toString());
			JSONObject json  = new JSONObject();
			int re = messageService.saveMessage(userId,message);
			if(re<0){//失败
				json.put("result", 2);
			}else{
				json.put("result", 1);
			}
			out = resp.getWriter();
			/* System.out.println(JSONArray.fromObject(messages).toString());*/
			 out.write(json.toString());
	    }
		
	}
	
	public void findMessage() throws IOException{
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = null;
		HttpSession session =	ServletActionContext.getRequest().getSession();
		if(session.getAttribute("userId") != null){
			int userId = Integer.parseInt( session.getAttribute("userId").toString());
			List<MessageDto> messages = messageService.updateMessage(userId);
			out = resp.getWriter();
			 System.out.println(JSONArray.fromObject(messages).toString());
			 out.write(JSONArray.fromObject(messages).toString());
	    }
	}
}
