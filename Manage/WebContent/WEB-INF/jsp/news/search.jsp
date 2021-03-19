<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <link href="${ctx}/resource/css/login.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="${ctx}/resource/css/doysu.min.css">
    <link rel="stylesheet" href="${ctx}/resource/css/base.css">
    <link rel="stylesheet" href="${ctx}/resource/css/app.css">
    <script type="text/javascript" src="${ctx}/resource/js/jquery.js"></script>
    <script src="${ctx}/resource/js/jquery.min.js"></script>
    <script src="${ctx}/resource/js/doysu.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	
});
</script>
<style>
.uli{


}
.uli li{
float: left;
margin-left:10px;
}

</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，手机网站一些效果暂不支持。 请 <a
  href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
  <div class="header-top dys-show-md">
    <div class="dy-container">
      <div class="dy-g">
          <div class="dy-u-lg-6 dy-u-md-6">
              <a href=""><img src="${ctx}/resource/images/logo.png" alt=""></a>
          </div>
          <div class="dy-u-lg-6 dy-u-md-6 mt60 dy-text-right" >
              <%-- <a href=""><img src="${ctx}/resource/images/qq.png" alt=""></a>
              <a href=""><img src="${ctx}/resource/images/qq2.png" alt=""></a>
              <a href=""><img src="${ctx}/resource/images/xl.png" alt=""></a> --%>
              <c:if test="${userId !=null }">
                 <a href=""><span style="font-size: 16px;font-weight: bold;">欢迎您：${userName}</span></a>&nbsp;&nbsp;&nbsp;
                  <a href="${ctx}/login_tuichu.do"><span style="font-size: 16px;font-weight: bold;">退出登陆</span></a>
              </c:if>
              <c:if test="${userId ==null }">
               <a href="${ctx}/login_login.do"><span style="font-size: 16px;font-weight: bold;">登陆/注册</span></a>&nbsp;&nbsp;&nbsp;
              </c:if>
          </div>
      </div>
    </div>
  </div>

  <!-- header -->
  <header class="dy-topbar dy-topbar-inverse">
    <div class="dy-container">
      <h1 class="dy-topbar-brand dy-show-sm-only">
        <a class="dy-text-ir" href="#">网罗天下</a>
      </h1>
      <button data-dy-collapse="{target: '#doc-topbar-collapse-3'}" class="dy-topbar-btn dy-topbar-toggle dy-btn dy-btn-sm dy-btn-success dy-show-sm-only dy-collapsed">
        <span class="dy-sr-only">导航切换</span>
        <span class="dy-icon-bars"></span>
      </button>       
      <div id="doc-topbar-collapse-3" class="dy-topbar-collapse dy-collapse">
        <ul class="dy-nav dy-nav-pills dy-topbar-nav">
         <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
          <li class="dy-active"><a href="${ctx}/user_index.do">首页</a></li>
          <li><a href="${ctx}/news_list.do?type=5">体育</a></li>
          <li><a href="${ctx}/news_list.do?type=6">娱乐</a></li>
          <li><a href="${ctx}/news_list.do?type=7">文章</a></li>
          <li><a href="${ctx}/news_list.do?type=8">汽车</a></li>
          <li><a href="${ctx}/news_list.do?type=9">科技</a></li>
          <li><a href="${ctx}/news_list.do?type=10">健康</a></li>
          <li><a href="${ctx}/news_list.do?type=11">房产</a></li>
          <li><a href="${ctx}/news_list.do?type=12">家居</a></li>
           <li><a href="${ctx}/news_list.do?type=13">旅游</a></li>
           <li><a href="${ctx}/news_list.do?type=14">公益</a></li>
            <li><a href="${ctx}/message_message.do">交友天地</a></li>
          <li><a href="${ctx}/user_info.do" >个人信息</a></li>
          <li class="dys-show-sm">
              <a href=""><img src="${ctx}/resource/images/qq.png" alt=""></a>
              <a href=""><img src="${ctx}/resource/images/qq2.png" alt=""></a>
              <a href=""><img src="${ctx}/resource/images/xl.png" alt=""></a>
          </li>
        </ul>
         <form class="dy-topbar-form dy-topbar-left dy-form-inline" role="search" action="${ctx}/news_search.do" method="post">
          <div class="dy-form-group">
            <input type="text" class="dy-form-field dy-input-sm" name="key" placeholder="搜索">
            <button type="submit" class="dy-btn dy-btn-default dy-btn-sm"><i class="dy-icon-search"></i></button>
          </div>
        </form>
      </div>
    </div>
  </header>



<!--content-->
  <div class="dy-container">

    <ol class="dy-breadcrumb">
      <li><a href="#" class="dy-icon-home">首页</a></li>
      <li><a href="#">专题</a></li>
      <li class="dy-active">内容</li>
    </ol>

    <div class="dy-g">
      <div class="dy-u-md-8 dy-u-sm-12 tf-lists">
               <c:forEach items="${pagers.datas}" var="new3" varStatus="l">
                   <div class="dy-cf item">
				           <a title="" href="${ctx}/news_info.do?id=${new3.id}">
				             <div class="dy-u-sm-12 dy-u-md-6">
				                 <img width="100%" height="190" src="${new3.titlePhoto}" alt="" />
				             </div>
				             <div class="dy-u-sm-12 dy-u-md-6">
				                 <h1>${new3.title }</h1>
				                 <p>${new3.introduction}</p> 
				                 <p class="tf-icon">
				                   <span class="dy-icon-user"></span> 管理员&nbsp;&nbsp;
				                   <span class="dy-icon-clock-o"></span> ${new3.createTime}&nbsp;&nbsp;
				                   <span class="dy-icon-eye"></span> ${new3.djs }
				                 </p>
				             </div>
				           </a>
				         </div>
               </c:forEach>
				        
          <div class="panel-foot text-center">
      <pg:pager  url="${ctx}/news_search.do" maxIndexPages="5" items="${pagers.total}"  maxPageItems="15" export="curPage=pageNumber" >
		<pg:param name="key" value="${key}"/>
		
		<pg:last>  
			共${pagers.total}记录,共${pageNumber}页,  
		</pg:last>  
			当前第${curPage}页 
  
        <pg:first>  
    		<a href="${pageUrl}">首页</a>  
		</pg:first>  
		<pg:prev>  
    		<a href="${pageUrl}">上一页</a>  
		</pg:prev>  
      
       	<pg:pages>  
        	<c:choose>  
            	<c:when test="${curPage eq pageNumber}">  
                	<font color="red">[${pageNumber }]</font>  
            	</c:when>  
            	<c:otherwise>  
               		<a href="${pageUrl}">${pageNumber}</a>  
            	</c:otherwise>  
        	</c:choose>  
    	</pg:pages>
             
        <pg:next>  
    		<a href="${pageUrl}">下一页</a>  
		</pg:next>  
		<pg:last>  
			<c:choose>  
            	<c:when test="${curPage eq pageNumber}">  
                	<font color="red">尾页</font>  
            	</c:when>  
            	<c:otherwise>  
               		<a href="${pageUrl}">尾页</a>  
            	</c:otherwise>  
        	</c:choose> 
    		  
		</pg:last>
	</pg:pager>
    </div>

      </div>
      <div class="dy-u-md-4 dy-u-sm-12">
        <div class="dy-bac-fff dy-padding picc">
          <div class="dy-g">
             <div class="dy-u-md-12 dy-u-sm-6">
              <c:forEach items="${allAdvertise}" var="ad" varStatus="l">
                  <c:if test="${ad.address == 5}">
                    <a href=""><img class="dy-img-responsive" src="${ad.hrefs }" alt=""></a>
                  </c:if>
                </c:forEach>
               
             </div>
             <div class="dy-u-md-12 dy-u-sm-6">
               <c:forEach items="${allAdvertise}" var="ad" varStatus="l">
                  <c:if test="${ad.address == 6}">
                    <a href=""><img class="dy-img-responsive" src="${ad.hrefs }" alt=""></a>
                  </c:if>
                </c:forEach>
             </div>
          </div>
        </div>
  
        <div data-dy-widget="list_news" class="dy-list-news dy-list-news-default">
          <!--列表标题-->
          <div class="dy-list-news-hd dy-cf">
            <!--带更多链接-->
            <a href="###" class="">
              <h2>最新文章</h2>
            </a>
          </div>
          <div class="dy-list-news-bd">
            <ul class="dy-list">
               <c:forEach items="${ns2}" var="ns2" varStatus="l">
              <li class="dy-g dy-list-item-desced dy-list-item-thumbed dy-list-item-thumb-left">
                <div class="dy-u-sm-4 dy-list-thumb" style="height: 100px">
                  <a href="${ctx}/news_info.do?id=${ns2.id}" class="">
                    <img src="${ns2.titlePhoto}" alt=""/>
                  </a>
                </div>
                <div class=" dy-u-sm-8 dy-list-main">
                  <h3 class="dy-list-item-hd">
                    <a href="${ctx}/news_info.do?id=${ns2.id}" class="">${ns2.title}</a>
                  </h3>
                  <div class="dy-list-item-text">${ns2.introduction}</div>
                </div>
              </li>
                </c:forEach>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!--content end-->












  <!--link-->
  <div id="news" class="dy-container">
    <div class="dy-g link">
       <div class="dy-u-md-12 dy-u-sm-12">
          <div class="dy-bac-fff">
              <dl>
                <dt><a class="dy-text-center" href=""><span class="dy-icon-link"></span></a>&nbsp;&nbsp;友情链接</dt>
                <dd>
                 <c:forEach items="${es}" var="spe" varStatus="l">
                   <c:if test="${spe.type == 2 }">
                    <a href="${spe.hrefs }" target="_blank">${spe.name }</a>
                   </c:if>
                 </c:forEach>
                </dd>
              </dl>
          </div>
       </div>
    </div>
  </div>
  <%--   <div id="news" class="dy-container">
    <div class="dy-g link">
       <div class="dy-u-md-12 dy-u-sm-12">
          <div class="dy-bac-fff">
              <dl>
                <dt><a class="dy-text-center" href=""><span class="dy-icon-link"></span></a>&nbsp;&nbsp;合作站点</dt>
                <dd>
                 <c:forEach items="${es}" var="spe" varStatus="l">
                   <c:if test="${spe.type == 1 }" >
                    <a href="${spe.hrefs }" target="_blank">${spe.name }</a>
                   </c:if>
                 </c:forEach>
                </dd>
              </dl>
          </div>
       </div>
    </div>
  </div> --%>
  <!--link end-->

  <!--footer-->
  <div id="footer">
        <div class="footer-top">
          <div class="dy-g">
            <div class="dy-u-md-12 dy-u-sm-12 dy-text-center">
              <a href="">合作站点：</a>
               <c:forEach items="${es}" var="spe" varStatus="l">
                   <c:if test="${spe.type == 1 }" >
                    <a href="${spe.hrefs }" target="_blank">${spe.name }</a>
                   </c:if>
                 </c:forEach>
            </div>    
          </div>
        </div>
        <div class="footer-bottom">
          <div class="dy-g">
            <div class="dy-u-md-12 dy-u-sm-12 dy-text-center">
           Copyright © 2016-2019 江苏师范大学新闻发布中心    
            </div>
          </div>
       </div>
  </div>
  <!--footer end-->

<div data-dy-widget="gotop"  class="dy-gotop dy-gotop-fixed">
  <a class="dy-icon-btn dy-icon-arrow-up dy-active dy-top" title="回到顶部" href="#top"></a>
</div>




<!--[if (gte IE 9)|!(IE)]><!-->
<script src="js/jquery.min.js"></script>
<script src="js/doysu.min.js"></script>
<!--<![endif]-->
<script src="js/app.js"></script>
</body>
</html>
