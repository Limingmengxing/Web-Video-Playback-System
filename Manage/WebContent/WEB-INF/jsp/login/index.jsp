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
 <div id="news" class="dy-container">
    <div class="dy-g link">
       <div class="dy-u-md-12 dy-u-sm-12">
          <div class="dy-bac-fff" style="padding-top: 10px">
              <dl> 
                <dd>
                 <c:forEach items="${ss}" var="se" varStatus="l">
                  <a href="${ctx}/news_listzt.do?ztId=${se.id}">${se.name}</a>
                 </c:forEach>
                </dd>
              </dl>
          </div>
       </div>
    </div>
  </div>
  <!-- /header -->
 
  <!--banner-->
  <div id="banner" class="dy-container">
    <div class="dy-g">
      <div class="dy-u-md-8 dy-u-sm-12">
          <div class="dy-padding1 dy-bac-fff">
            <div data-dy-widget="slider" class="dy-slider dy-slider-c2" data-dy-slider='{&quot;directionNav&quot;:false}'>
              <ul class="dy-slides">
                <c:forEach items="${ns}" var="n" varStatus="l">
                 <c:if test="${n.isSY == 1 }">
                  <li>
	                 <a href="${ctx}/news_info.do?id=${n.id}"> <img height="295" src="${n.titlePhoto}"></a>
	                  <div class="dy-slider-desc">${n.title}</div>
                  </li>
                 </c:if>
                 </c:forEach>
              </ul>
            </div>
          </div>
      </div>
      <div class="dy-u-md-4 dy-u-sm-12">
        <div class="dy-bac-fff dy-padding picc">
          <div class="dy-g">
             <div class="dy-u-md-12 dy-u-sm-6" style="height:145px;">
                <c:forEach items="${allAdvertise}" var="ad" varStatus="l">
                  <c:if test="${ad.address == 1}">
                  <div style="height:160px;"> 
                       <img class="" src="${ad.hrefs}" height="135" width="100%" >
                  </div>
                  </c:if>
                </c:forEach>
             </div>
             <div class="dy-u-md-12 dy-u-sm-6" style="height:145px;">
             <c:forEach items="${allAdvertise}" var="ad" varStatus="l">
                  <c:if test="${ad.address == 2}">
                  <div style="height:150px;"> 
                       <img class="" src="${ad.hrefs}" height="135" width="100%" >
                  </div>
                  </c:if>
                </c:forEach>
             </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!--banner end-->
  <!--新闻-->
<!--   //最新新闻
		List<News> ns2 =newsService.findNewAll();
		//热点新闻
		List<News> ns3 =newsService.findrdAll(); -->
  <div id="news" class="dy-container">
    <div class="dy-g news">
       <div class="dy-u-md-6 dy-u-sm-12">
          <div class="dy-bac-fff">
              <dl>
                <dt><a class="dy-text-center" href=""><span class="dy-icon-list"></span></a>&nbsp;&nbsp;热点要闻</dt>
                <dd>
                  <ul>
                       <c:forEach items="${ns3}" var="n3" varStatus="l">
                         <li><a href="${ctx}/news_info.do?id=${n3.id}"><span class="dy-icon-angle-right"></span> ${n3.title}</a>${n3.createTime}</li>
                       </c:forEach>
                  </ul>
                </dd>
              </dl>
          </div>
       </div>
       <div class="dy-u-md-6 dy-u-sm-12">
          <div class="dy-bac-fff">
              <dl>
                <dt><a class="dy-text-center" href=""><span class="dy-icon-list"></span></a>&nbsp;&nbsp;最新资讯</dt>
                <dd>
                  <ul>
                      <c:forEach items="${ns2}" var="n2" varStatus="l">
                         <li><a href="${ctx}/news_info.do?id=${n2.id}"><span class="dy-icon-angle-right"></span> ${n2.title}</a>${n2.createTime}</li>
                       </c:forEach>
                  </ul>
                </dd>
              </dl>
          </div>
       </div>
    </div>
  </div>
  <!--新闻 end-->

  <!--吐槽无极限-->
  <div id="news" class="dy-container">
    <div class="dy-g">
       <div class="dy-u-md-12 dy-u-sm-12">
          <div class="dy-bac-fff tucao">
              <dl>
                <dt><a class="dy-text-center" href=""><span class="dy-icon-list"></span></a>&nbsp;&nbsp;广告推广</dt>
                <dd>
                  <div class="dy-g">
                    <div class="dy-u-md-6 dy-u-sm-12">
                          <c:forEach items="${allAdvertise}" var="ad" varStatus="l">
		                  <c:if test="${ad.address == 3}">
		                   <a href=""><img class="" src="${ad.hrefs}" height="235" width="100%" alt=""></a>
		                  </c:if>
		                  </c:forEach>
                    </div>
                    <div class="dy-u-md-6 dy-u-sm-12">
                     <c:forEach items="${allAdvertise}" var="ad" varStatus="l">
		                  <c:if test="${ad.address == 4}">
		                   <a href=""><img class="" src="${ad.hrefs}" height="235" width="100%" alt=""></a>
		                  </c:if>
		                  </c:forEach>
                    </div>
                  </div>
                </dd>
              </dl>
          </div>
       </div>
    </div>
  </div>
  <div id="news" class="dy-container">
    <div class="dy-g news">
       <div class="dy-u-md-6 dy-u-sm-12">
          <div class="dy-bac-fff">
              <dl>
                <dt><a class="dy-text-center" href="${ctx}/news_list.do?type=2"><span class="dy-icon-list"></span></a>&nbsp;新闻资讯  <span class="dy-list-news-more dy-fr"><a href="${ctx}/news_list.do?type=2">更多</a></span></dt>
                <dd>
                  <ul>
                      <c:forEach items="${ns4}" var="n4" varStatus="l">
                         <li><a href="${ctx}/news_info.do?id=${n4.id}"><span class="dy-icon-angle-right"></span> ${n4.title}</a>${n4.createTime}</li>
                       </c:forEach>
                  </ul>
                </dd>
              </dl>
          </div>
       </div>
       <div class="dy-u-md-6 dy-u-sm-12">
          <div class="dy-bac-fff">
              <dl>
                <dt><a class="dy-text-center" href="${ctx}/news_list.do?type=3"><span class="dy-icon-list"></span></a>&nbsp;&nbsp;社会新闻<span class="dy-list-news-more dy-fr"><a href="${ctx}/news_list.do?type=3">更多</a></span></dt>
                <dd>
                  <ul>
                     <c:forEach items="${ns5}" var="n5" varStatus="l">
                         <li><a href="${ctx}/news_info.do?id=${n5.id}"><span class="dy-icon-angle-right"></span> ${n5.title}</a>${n5.createTime}</li>
                       </c:forEach>
                  </ul>
                </dd>
              </dl>
          </div>
       </div>
    </div>
  </div>
  <!--新闻 end-->

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
           Copyright © 2018-2019 太原理工视频发布中心    
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
