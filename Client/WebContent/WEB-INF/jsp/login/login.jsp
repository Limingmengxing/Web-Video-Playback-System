<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <link href="${ctx}/resource/css/login.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="${ctx}/resource/css/doysu.min.css">
    <link rel="stylesheet" href="${ctx}/resource/css/base.css">
    <link rel="stylesheet" href="${ctx}/resource/css/app.css">
    <link href="${ctx}/resource/css/style.css" rel='stylesheet' type='text/css' />
    <script type="text/javascript" src="${ctx}/resource/js/jquery.js"></script>
    <script src="${ctx}/resource/js/jquery.min.js"></script>
    <script src="${ctx}/resource/js/doysu.min.js"></script>
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script type="text/javascript">
$(document).ready(function(){
	
});
</script>
<head>
<style>
#doc-topbar-collapse-3 a{
font-weight: bold;
font-size: 14px;
}

</style>
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
          <li class="dy-active"><a href="${ctx}/user_index.do">首页</a></li>
          <li><a href="${ctx}/news_list.do?type=5">体育</a></li>
          <li><a href="${ctx}/news_list.do?type=6">娱乐</a></li>
          <li><a href="${ctx}/news_list.do?type=7">文章</a></li>
          <li><a href="${ctx}/news_list.do?type=8">汽车</a></li>
          <li><a href="${ctx}/news_list.do?type=9">科技</a></li>
          <li><a href="${ctx}/news_list.do?type=10">健康</a></li>
          <li><a href="${ctx}/news_list.do?type=11">房产</a></li>
          <li><a href="${ctx}/news_list.do?type=12" >家居</a></li>
           <li><a href="${ctx}/news_list.do?type=13">旅游</a></li>
           <li><a href="${ctx}/news_list.do?type=14">公益</a></li>
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
  <!-- /header -->
  <!-- /header -->
<div class="main">
		<div class="header" >
			<h1>登录或创建一个免费帐户！</h1>
		</div>
		<p></p>
			<form id="zhuce">
				<ul class="left-form">
					<h2>新账户:</h2>
					<li>
						<input type="text" name="userName"  placeholder="登陆名" id="n0" value=""/>
						<div class="clear"> </div>
					</li> 
					<li>
						<input type="password"   name="passWord" placeholder="输入密码" id="n2" value=""/>
						<div class="clear"> </div>
					</li> 
					<li>
						<input type="password"   placeholder="确认密码" id="n3"/>
						<div class="clear"> </div>
					</li> 
					<li>
						<input type="text"  name="realName" placeholder="姓名" id="n4"/>
						<div class="clear"> </div>
					</li> 
					<li>
						<input type="text"  name="phone" placeholder="电话 " id="n5"/>
						<div class="clear"> </div>
					</li> 
					<input type="button" onClick="myFunction()" value="创建账户">
				</ul>
				</form>
				<form id=denglu method="post">
					<ul class="right-form">
					<h3>登录:</h3>
					<div>
						<li><input type="text" name="userName"  placeholder="用户名" id="n6" value="admin"/></li>
						<li> <input type="password"  name="passWord" placeholder="密码" id="n7" value="111111"/></li>
						<h4></h4>
							<input type="button" onClick="myFunction2()" value="登录" >
					</div>
					<div class="clear"> </div>
				</ul>
				<div class="clear"> </div>
			</form>
			
			<form action="login_index.do" id=" ">
			  
			</form>
		</div>

  <!--footer-->
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
<script type="text/javascript">
//注册
	function myFunction(){
	//判断有没有为空的如果有那么就给提示
	if($("#n0").val() == null || $("#n0").val() == ""){alert("登录名不能为空");return false;}
	if($("#n2").val() == null || $("#n2").val() == ""){alert("密码不能为空");return false;}
	if($("#n3").val() == null || $("#n3").val() == ""){alert("确认密码不能为空");return false;}
	if($("#n4").val() == null || $("#n4").val() == ""){alert("姓名不能为空");return false;}
	if($("#n5").val() == null || $("#n5").val() == ""){alert("电话不能为空");return false;}
	if($("#n3").val() != $("#n2").val() ){
		alert("您输入的两次密码不一致");
		return false;
	}
	$.ajax({
		type : 'post',
		url : ctx+"/login_register.do",
		dataType : "json",
		 data:$('#zhuce').serialize(),// 
		success : function(data) {
			alert(data.message);
		},
		error : function() {
			alert("error");
		}
	});
	
	}
	//提交
	function myFunction2(){
		//判断有没有为空的如果有那么就给提示
		if($("#n6").val() == null || $("#n6").val() == ""){alert("用户名不能为空");return false;}
		if($("#n7").val() == null || $("#n7").val() == ""){alert("密码不能为空");return false;}
		$.ajax({
			  type : 'post',
			  url : ctx+"/user_login.do",
			  dataType : "json",
			 data:$('#denglu').serialize(),// 
			  success : function(data) {
				if(data.message == "1"){
					alert("用户名或密码不正确");
					return false;
				   }else{
				    window.location.href=ctx+"/user_index.do";
				}
			},
			error : function() {
				alert("error");
			}
		});
		}
</script>
</body>
</html>
