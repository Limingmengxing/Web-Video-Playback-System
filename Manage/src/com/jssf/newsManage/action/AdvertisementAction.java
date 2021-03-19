package com.jssf.newsManage.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jssf.newsManage.model.Advertisement;
import com.jssf.newsManage.model.Comment;
import com.jssf.newsManage.model.Extension;
import com.jssf.newsManage.service.AdvertisementService;
import com.jssf.newsManage.utils.Pager;
import com.jssf.newsManage.utils.UUIDUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
@Controller("advertisementAction")
@Scope("prototype")
public class AdvertisementAction  extends ActionSupport implements ModelDriven<Advertisement>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//========================图片上传
	private File file;
	private String fileFileName;
	private String fileContentType;
    
    
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
private Advertisement advertisement;
	public Advertisement getModel() {
		if(advertisement==null) advertisement = new Advertisement();
		return advertisement;
	}
	@Autowired
	private AdvertisementService advertisementService;

	
	/**
	 * @return
	 */
	public String advertisement(){
		Pager<Advertisement> pagers = advertisementService.list(advertisement);
		ActionContext.getContext().put("pagers", pagers);
		return SUCCESS;
		
	}
    /**
     * 跳转添加页面
     * @return
     */
	public String addAdvertisement(){
	//	  ActionContext.getContext().put("path", null);
		return SUCCESS;
	}
	/**
	 * 添加
	 * @return
	 * @throws IOException 
	 */
    public String advertisementAdd() throws IOException{
    	advertisement.setCreateTime(new Date());
    	advertisementService.add(advertisement);
    	ActionContext.getContext().put("url", "/advertisement_advertisement.do");
		return "redirect";
    }
    
    /**
     * 
     * @return
     */
	public String Edit(){
		Advertisement Advertisements = null;
		if(advertisement.getId()!=0){
			Advertisements =	advertisementService.getById(advertisement.getId());
		}else{
			Object object = ActionContext.getContext().get("id");
			Advertisements =	advertisementService.getById(Integer.parseInt(object.toString()));
		}
		
		ActionContext.getContext().put("advertisement", Advertisements);
		return SUCCESS;
		
	}
	
	
	public String  editAdvertisement() throws IOException{
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = null;
		advertisementService.updateInfo(advertisement);
		ActionContext.getContext().put("url", "/advertisement_advertisement.do");
		return "redirect";
		
	}
    
    
    public String delAdvertisement(){
    	advertisementService.deleteInfo(advertisement.getId());
    	ActionContext.getContext().put("url", "/advertisement_advertisement.do");
		return "redirect";
    }
    
    /**
     * 图片上传
     * @return
     * @throws Exception
     */
	public String fileUpload() throws Exception{
		
		HttpSession session =	ServletActionContext.getRequest().getSession();
			int userId = Integer.parseInt( session.getAttribute("userId").toString());
			System.out.println("================================="+userId);
			
			String root  = "C:/my/upload";
		        InputStream is = new FileInputStream(file);
		        fileFileName = UUIDUtils.create()+fileFileName;
		        OutputStream os = new FileOutputStream(new File(root, fileFileName));
		        System.out.println("fileFileName: " + fileFileName);
		        byte[] buffer = new byte[500];
		        int length = 0;
		        
		        while(-1 != (length = is.read(buffer, 0, buffer.length)))
		        {
		            os.write(buffer);
		        }
		        os.close();
		        is.close();
		        advertisement.setHrefs("\\upload\\"+fileFileName);
		      //  advertisementService.add(advertisement);
		        ActionContext.getContext().put("url", "advertisement_addAdvertisement");
		        ActionContext.getContext().put("path", "\\upload\\"+fileFileName);
		        return "chain";
	}
	 /**
     * 图片上传
     * @return
     * @throws Exception
     */
	public String fileUpload2() throws Exception{
		
		HttpSession session =	ServletActionContext.getRequest().getSession();
			int userId = Integer.parseInt( session.getAttribute("userId").toString());
			String root  = "C:/my/upload";
		        InputStream is = new FileInputStream(file);
		        fileFileName = UUIDUtils.create()+fileFileName;
		        OutputStream os = new FileOutputStream(new File(root, fileFileName));
		        System.out.println("fileFileName: " + fileFileName);
		        byte[] buffer = new byte[500];
		        int length = 0;
		        
		        while(-1 != (length = is.read(buffer, 0, buffer.length)))
		        {
		            os.write(buffer);
		        }
		        os.close();
		        is.close();
		        advertisement.setHrefs("\\upload\\"+fileFileName);
		      //  advertisementService.add(advertisement);
		        ActionContext.getContext().put("url", "advertisement_Edit");
		        ActionContext.getContext().put("id", advertisement.getId());
		        ActionContext.getContext().put("path", "\\upload\\"+fileFileName);
		        return "chain";
	}
}
