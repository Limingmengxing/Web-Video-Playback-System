package com.jssf.newsManage.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jssf.newsManage.model.Advertisement;
import com.jssf.newsManage.model.News;
import com.jssf.newsManage.model.Special;
import com.jssf.newsManage.service.AdvertisementService;
import com.jssf.newsManage.service.NewsService;
import com.jssf.newsManage.service.SpecialService;
import com.jssf.newsManage.utils.Pager;
import com.jssf.newsManage.utils.UUIDUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller("newsAction")
@Scope("prototype")
public class NewsAction extends ActionSupport implements ModelDriven<News>{
	@Autowired
	private AdvertisementService advertisementService;
	 @Autowired
	    private SpecialService specialService;

		@Autowired
	    private NewsService newsService;
	private static final long serialVersionUID = 1L;
    private News news;
    private String titles;
    //=====================新闻发布参数
    /*
    
    
    */
    private int adverId;//广告id
    private int qt;//新闻类别选择其他
    private int zt;//新闻类别选择专题
    private int xwlx;//单选框是1 专题还是2 其他
    //==================================

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public int getAdverId() {
		return adverId;
	}

	public void setAdverId(int adverId) {
		this.adverId = adverId;
	}

	public int getQt() {
		return qt;
	}

	public void setQt(int qt) {
		this.qt = qt;
	}

	public int getZt() {
		return zt;
	}

	public void setZt(int zt) {
		this.zt = zt;
	}

	public int getXwlx() {
		return xwlx;
	}

	public void setXwlx(int xwlx) {
		this.xwlx = xwlx;
	}

	public String getTitles() {
		return titles;
	}

	public void setTitles(String titles) {
		this.titles = titles;
	}

	public News getModel() {
		if(news==null) news = new News();
		return news;
	}

	public String newList(){
		Pager<News> pagers = newsService.list(titles);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("titles", titles);
		return SUCCESS;
	}

	public String addnew(){
		List<Advertisement> ads = advertisementService.allAdvertise();
		List<Special> sps = specialService.allSpecial();
		ActionContext.getContext().put("ads", ads);
		ActionContext.getContext().put("sps", sps);
		return SUCCESS;
	}
	public String add(){
		newsService.add(news);
		ActionContext.getContext().put("url", "/news_newList.do");
		return "redirect";
	}
	
	public String updatenew(){
		List<Advertisement> ads = advertisementService.allAdvertise();
		List<Special> sps = specialService.allSpecial();
		ActionContext.getContext().put("ads", ads);
		ActionContext.getContext().put("sps", sps);
		News n = newsService.load(news);
		ActionContext.getContext().put("news2", n);
		System.out.println(n.getContent());
		return SUCCESS;
	}
	
	public String update()throws Exception{
		/**
		 * 先判断是更换图片如果没有更换就不修改
		 */
	News newN = newsService.load(news);
		
		if(uploadFileFileName != null){
			   String root  = "C:/my/upload";
		        InputStream is = new FileInputStream(uploadFile);
		        uploadFileFileName = UUIDUtils.create()+uploadFileFileName;
		        OutputStream os = new FileOutputStream(new File(root, uploadFileFileName));
		        System.out.println("fileFileName: " + uploadFileFileName);
		        System.out.println("file: " + uploadFile.getName());
		        System.out.println("file: " + uploadFile.getPath());
		        byte[] buffer = new byte[500];
		        int length = 0;
		        
		        while(-1 != (length = is.read(buffer, 0, buffer.length)))
		        {
		            os.write(buffer);
		        }
		        os.close();
		        is.close();
		        newN.setTitlePhoto("\\upload\\"+uploadFileFileName);
		}
		    Advertisement ad = new Advertisement();
	        if(xwlx == 1){//专题
	        	newN.setType(0);
	        	//如果是专题就需要保存专题信息
	        	Special sp = new Special();
	        	sp.setId(zt);
	        	newN.setSpecial(sp);
	        	
	        }else{//其他
	        	newN.setType(qt);
	        }
	       
	        newN.setTitle(news.getTitle());
	        newN.setIntroduction(news.getIntroduction());
	        newN.setContent(news.getContent());
	        ad.setId(adverId);
	        newN.setAdvertisement(ad);
		    newsService.update(newN);
		ActionContext.getContext().put("url", "/news_newList.do");
		return "redirect";
	}
	
	public String del(){
		newsService.del(news);
		ActionContext.getContext().put("url", "/news_newList.do");
		return "redirect";
	}
	
	//文件上传
    //上传的文件对象  
    private File uploadFile;  
    //文件名称  
    private String uploadFileFileName;  
    //文件类型  
    private String uploadFileContentType;  
      
    public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	public String fileUpload() throws Exception{
			
			// String root = ServletActionContext.getServletContext().getRealPath("/")+"upload";
			//String root = ServletActionContext.getServletContext().getRealPath("upload"); 
			//String root = ServletActionContext.getRequest().getContextPath()+"/"+"upload";
			 String root  = "C:/my/upload";
		        InputStream is = new FileInputStream(uploadFile);
		        uploadFileFileName = UUIDUtils.create()+uploadFileFileName;
		        OutputStream os = new FileOutputStream(new File(root, uploadFileFileName));
		        System.out.println("fileFileName: " + uploadFileFileName);
		        System.out.println("file: " + uploadFile.getName());
		        System.out.println("file: " + uploadFile.getPath());
		        byte[] buffer = new byte[500];
		        int length = 0;
		        
		        while(-1 != (length = is.read(buffer, 0, buffer.length)))
		        {
		            os.write(buffer);
		        }
		        os.close();
		        is.close();
		        //接下来存到新闻表里面
		       
		        /*private int id;
		    	private String ;
		    	private Date ;
		    	private String ;//标题
		    	private String ;//简介
		    	private int ;//代表新闻类型 0.专题 1.热点要闻  2.新闻资讯 3体育 4娱乐 5文章 6汽车 7科技 8 健康9房产 10 家居11科技 12 旅游 13公益
		    	//0专题  1.热点要闻 2.新闻资讯 3社会新闻 4.国际新闻
		    	//5 体育 6 娱乐 7文章 8汽车 9科技 10 健康 11 房产 12 家居 13旅游 14 公益
		    	private Advertisement advertisement;//广告
		    	private int djs;//点击多少次
		    	private String titlePhoto;//缩略图

		    	private Special special;//专题
		    	*/
//		        private int adverId;//广告id
//		        private int qt;//新闻类别选择其他
//		        private int zt;//新闻类别选择专题
//		        private int xwlx;//单选框是1 专题还是2 其他
		        News news2 = new News();
		        news2.setIsSY(2);
		        Advertisement ad = new Advertisement();
		        if(xwlx == 1){//专题
		        	news2.setType(0);
		        	//如果是专题就需要保存专题信息
		        	Special sp = new Special();
		        	sp.setId(zt);
		        	news2.setSpecial(sp);
		        	
		        }else{//其他
		        	news2.setType(qt);
		        }
		        news2.setTitlePhoto("\\upload\\"+uploadFileFileName);
		        news2.setTitle(news.getTitle());
		        news2.setIntroduction(news.getIntroduction());
		        news2.setContent(news.getContent());
		        news2.setCreateTime(new Date());
		        ad.setId(adverId);
		        news2.setAdvertisement(ad);
		        newsService.addInfo(news2);
		        ActionContext.getContext().put("url", "/news_newList.do");
		        return "redirect";
		}
	  public String delNews(){
	    	 newsService.del(news);
	    	ActionContext.getContext().put("url", "/news_newList.do");
			return "redirect";
	    }
	
	  public String lunbo(){
		  News newN = newsService.load(news);
		  if(newN.getIsSY()== 2){
			  newN.setIsSY(1);
		  }else{
			  newN.setIsSY(2); 
		  }
		  newsService.update(newN);
			ActionContext.getContext().put("url", "/news_newList.do");
			return "redirect";
	  }
}
