package com.jssf.newsManage.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jssf.newsManage.model.Manage;
import com.jssf.newsManage.model.News;
import com.jssf.newsManage.model.Special;
import com.jssf.newsManage.service.SpecialService;
import com.jssf.newsManage.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;

@Controller("specialAction")
@Scope("prototype")
public class SpecialAction extends ActionSupport implements ModelDriven<Special>{
    private Special special;
    @Autowired
    private SpecialService specialService;
	public Special getModel() {
		if(special==null) special = new Special();
		return special;
	}
	/**
	 * @return
	 */
	public String special(){
		Pager<Special> pagers = specialService.list(special);
		ActionContext.getContext().put("pagers", pagers);
		return SUCCESS;
		
	}
    /**
     * 跳转添加页面
     * @return
     */
	public String addSpecial(){
		return SUCCESS;
	}
	/**
	 * 添加
	 * @return
	 * @throws IOException 
	 */
    public void specialAdd() throws IOException{
    	HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = null;
		specialService.add(special);
    	out = resp.getWriter();
		 out.write(JSONArray.fromObject(1).toString());
    }
    
    /**
     * 
     * @return
     */
	public String Edit(){
		Special special2 =	specialService.getById(special.getId());
		ActionContext.getContext().put("special", special2);
		return SUCCESS;
		
	}
	
	
	public void  editSpecial() throws IOException{
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = null;
		specialService.updateInfo(special);
    	out = resp.getWriter();
		 out.write(JSONArray.fromObject(1).toString());
		
	}
    
    
    public String delSpecial(){
    	specialService.deleteInfo(special.getId());
    	ActionContext.getContext().put("url", "/special_special.do");
		return "redirect";
    }
    

}
