package com.jssf.newsClient.action;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jssf.newsClient.model.Advertisement;
import com.jssf.newsClient.model.Comment;
import com.jssf.newsClient.model.Extension;
import com.jssf.newsClient.model.News;
import com.jssf.newsClient.model.Special;
import com.jssf.newsClient.service.AdvertisementService;
import com.jssf.newsClient.service.CommentService;
import com.jssf.newsClient.service.ExtensionService;
import com.jssf.newsClient.service.NewsService;
import com.jssf.newsClient.service.SpecialService;
import com.jssf.newsClient.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller("newsAction")
@Scope("prototype")
public class NewsAction extends ActionSupport implements ModelDriven<News>{
	private static final long serialVersionUID = 1L;
    private News news;
    private String titles;
    @Autowired
    private ExtensionService extensionService;
	@Autowired
    private SpecialService specialService;
	@Autowired
	private AdvertisementService advertisementService;
	@Autowired
	private CommentService CommentService;
	private int ztId;//
	private String key;//
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getZtId() {
		return ztId;
	}

	public void setZtId(int ztId) {
		this.ztId = ztId;
	}

	public String getTitles() {
		return titles;
	}

	public void setTitles(String titles) {
		this.titles = titles;
	}

	@Autowired
    private NewsService newsService;
	@Override
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
		return SUCCESS;
	}
	public String add(){
		newsService.add(news);
		ActionContext.getContext().put("url", "/news_newList.do");
		return "redirect";
	}
	
	public String updatenew(){
		News n = newsService.load(news);
		ActionContext.getContext().put("news", n);
		return SUCCESS;
	}
	
	public String update(){
		newsService.update(news);
		ActionContext.getContext().put("url", "/news_newList.do");
		return "redirect";
	}
	
	public String del(){
		newsService.del(news);
		ActionContext.getContext().put("url", "/news_newList.do");
		return "redirect";
	}
	//=========================================================================
	public String list(){
				Pager<News> pagers = newsService.newListByType(news);
				ActionContext.getContext().put("pagers", pagers);
	        	//1查询合作站点以及友情链接
				List<Extension> es = extensionService.findAll();
				ActionContext.getContext().put("es", es);
				//新闻列表展示 包括 首页轮播 以及新闻资讯 社会新闻
				List<News> ns =newsService.findAll();
				ActionContext.getContext().put("ns", ns);
				//最新新闻
				List<News> ns2 =newsService.findNewAll();
				ActionContext.getContext().put("ns2", ns2);
				//广告
				List<Advertisement> allAdvertise = advertisementService.allAdvertise();
				ActionContext.getContext().put("allAdvertise", allAdvertise);
				ActionContext.getContext().put("type", news.getType());
		return SUCCESS;
	}
	
	public String listzt(){
		Pager<News> pagers = newsService.newListByztId(ztId);
		ActionContext.getContext().put("pagers", pagers);
    	//1查询合作站点以及友情链接
		List<Extension> es = extensionService.findAll();
		ActionContext.getContext().put("es", es);
		//新闻列表展示 包括 首页轮播 以及新闻资讯 社会新闻
		List<News> ns =newsService.findAll();
		ActionContext.getContext().put("ns", ns);
		//最新新闻
		List<News> ns2 =newsService.findNewAll();
		ActionContext.getContext().put("ns2", ns2);
		//广告
		List<Advertisement> allAdvertise = advertisementService.allAdvertise();
		ActionContext.getContext().put("allAdvertise", allAdvertise);
		ActionContext.getContext().put("ztId", ztId);
       return SUCCESS;
}
	    public String search(){
		Pager<News> pagers = newsService.newListByKey(key);
		ActionContext.getContext().put("pagers", pagers);
    	//1查询合作站点以及友情链接
		List<Extension> es = extensionService.findAll();
		ActionContext.getContext().put("es", es);
		//新闻列表展示 包括 首页轮播 以及新闻资讯 社会新闻
		List<News> ns =newsService.findAll();
		ActionContext.getContext().put("ns", ns);
		//最新新闻
		List<News> ns2 =newsService.findNewAll();
		ActionContext.getContext().put("ns2", ns2);
		//广告
		List<Advertisement> allAdvertise = advertisementService.allAdvertise();
		ActionContext.getContext().put("allAdvertise", allAdvertise);
		ActionContext.getContext().put("type", news.getType());
		ActionContext.getContext().put("key", key);
       return SUCCESS;
}
	    /**
	     * 查看详情
	     * @return
	     */
	       public String info(){ 
	    	News news2 = newsService.load(news);
	    	news2.setDjs(news2.getDjs()+1);
	    	newsService.update(news2);
	    	ActionContext.getContext().put("info", news2);
	    	//1查询合作站点以及友情链接
			List<Extension> es = extensionService.findAll();
			ActionContext.getContext().put("es", es);
			//新闻列表展示 包括 首页轮播 以及新闻资讯 社会新闻
			List<News> ns =newsService.findAll();
			ActionContext.getContext().put("ns", ns);
			//最新新闻
			List<News> ns2 =newsService.findNewAll();
			ActionContext.getContext().put("ns2", ns2);
			//广告
			List<Advertisement> allAdvertise = advertisementService.allAdvertise();
			ActionContext.getContext().put("allAdvertise", allAdvertise);
			//这个新闻的评论
			Pager<Comment> pagers = CommentService.findByNewsId(news.getId());
			ActionContext.getContext().put("pagers", pagers);
			ActionContext.getContext().put("id", news.getId());
			 return SUCCESS;
	    }
}
