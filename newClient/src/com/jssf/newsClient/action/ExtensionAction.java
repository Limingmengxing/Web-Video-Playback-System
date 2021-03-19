package com.jssf.newsClient.action;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jssf.newsClient.model.Extension;
import com.jssf.newsClient.service.ExtensionService;
import com.jssf.newsClient.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;

@Controller("extensionAction")
@Scope("prototype")
public class ExtensionAction extends ActionSupport implements ModelDriven<Extension> {
    private Extension extension;
    @Autowired
    private ExtensionService extensionService;
	public Extension getModel() {
		if(extension==null) extension = new Extension();
		return extension;
	}
	/**
	 * @return
	 */
	public String extension(){
		Pager<Extension> pagers = extensionService.list(extension);
		ActionContext.getContext().put("pagers", pagers);
		return SUCCESS;
		
	}
    /**
     * 跳转添加页面
     * @return
     */
	public String addExtension(){
		return SUCCESS;
	}
	/**
	 * 添加
	 * @return
	 * @throws IOException 
	 */
    public void extensionAdd() throws IOException{
    	HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = null;
		extensionService.add(extension);
    	out = resp.getWriter();
		 out.write(JSONArray.fromObject(1).toString());
    }
    
    /**
     * 
     * @return
     */
	public String Edit(){
		Extension Extensions =	extensionService.getById(extension.getId());
		ActionContext.getContext().put("extension", Extensions);
		return SUCCESS;
		
	}
	
	
	public void  editExtension() throws IOException{
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = null;
		extensionService.updateInfo(extension);
    	out = resp.getWriter();
		 out.write(JSONArray.fromObject(1).toString());
		
	}
    
    
    public String delExtension(){
    	extensionService.deleteInfo(extension.getId());
    	ActionContext.getContext().put("url", "/extension_extension.do");
		return "redirect";
    }
    
}
