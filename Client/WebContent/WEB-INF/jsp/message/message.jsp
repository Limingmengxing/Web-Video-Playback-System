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
    <script type="text/javascript" src="${ctx}/resource/ping/js/main.js"></script>
    <script type="text/javascript" src="${ctx}/resource/ping/js/sinaFaceAndEffec.js"></script>
    <link  rel="stylesheet" href="${ctx}/resource/ping/css/main.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/ping/css/sinaFaceAndEffec.css" />

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

.messtime{
color: blue;
}
.message_left_con{
width: 50%;
}
.message_left_con{
    margin-left: 10px;
     margin-top:15px;
     background: grey;
     color: white;
      -moz-border-radius: 10px;
    -webkit-border-radius: 10px;
    border-radius: 10px;
    padding:5px;
}
.mess_right{
clear: both;
}
.mess_left{
clear: both;
}
.message_right_con{
clear:both;
 background: grey;
     color: white;
width: 50%;
float: right;
 -moz-border-radius: 10px;
    -webkit-border-radius: 10px;
    border-radius: 10px;
    margin-left: 10px;
    margin-top:15px;
  padding:5px;
}
.nameMe{
float: right;
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

  <div class="person_r" style="width: 800px;margin: 0 auto;margin-bottom: 30px;background: white;">
        	<div class="person_h" style="background:#c11976;color: white;">
            	&nbsp;&nbsp;&nbsp;<span style="font-size: 20px;font-weight: bold;">谈谈心意</span>
<%--             	<input type="hidden" name="hname" id="hname" value="${userName}"> --%>
            </div>
            <div class="person_rmain" style="border: 1px solid #c11976 ">
            	<div class="news_d" style="height: 350px;overflow:auto;overflow-x:hidden;">
                </div>
            </div>
             <div class="news_d2" style="height: 200px;border: 1px solid #ddd;">
                  <textarea name="content" id="content"  style="width: 100%;height: 80%;border: 1px solid white;">
                  </textarea>
                  <div style="width: 200px;float: right;">
                     <button onclick="sendMessage('${userName}')" style="width: 100px;background:#c11976;color: white;">发送</button>
                  </div>
             </div>
        </div>
    </div>








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

<script type="text/javascript">
$("#yue").change(function(){
	 var s =  $(this).val();
	 $("#jine").val(s*25);
	});

$("#sendMessage").click(function(name){
	
	 
});

function sendMessage(name){
	var con = $("#content").val();
//	${ctx}/sayMood_photoDetail.do?id=${data.id}
  var date = getNowFormatDate();
	 $.ajax({
		type : 'post',
		url : ctx+"/message_sendMessage.do?content="+con,
		dataType : "json",
		success : function(data) {
			if(data.result == 2){
				alert("您会员已经到期了，暂时不能聊天，请充值后再聊天！！！")
				return false;
			}else{
				$(".news_d").append(" <div class='mess_right'><div class='nameMe'><span class='messtime'>"+name+"</span>&nbsp;&nbsp;:&nbsp;&nbsp;<span class='messtime'>"+date+"</span></div><div class='message_right_con'>"+con+"</div> </div>");
				$("#content").val("");
				$('.news_d').scrollTop( $('.news_d')[0].scrollHeight );
			}
		},
		error : function() {
			alert("error");
		}
	});
}
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    return currentdate;
}
$(function(){
	
	  $("body").keydown(function() {
          if (event.keyCode == "13") {//keyCode=13是回车键
        	 // var name=${userName};
        	 // alert(name);
        	 var name= ${userName};
        	  sendMessage(name);
          }
      });
	resive();
	
	//聊天的先注释掉
	
	  setTimeout(function () {
		setInterval(resive2,4000);
	}, 2000);  
	
function resive(){
	var uid = ${userId}
	$.ajax({
		type : 'post',
		url : ctx+"/message_findMessageJIluList.do",
		dataType : "json",
		success : function(data) {
			for (var i=0;i<data.length;i++)
			{
			 if(data[i].sendUserId == uid ){
				 $(".news_d").append(" <div class='mess_right'><div class='nameMe'><span class='messtime'>"+data[i].sendUserName+"</span>&nbsp;&nbsp;:&nbsp;&nbsp;<span class='messtime'>"+data[i].createTimeStr+"</span></div><div class='message_right_con'>"+data[i].content+"</div> </div>");
				 $("#content").val("");
				 $('.news_d').scrollTop( $('.news_d')[0].scrollHeight );
			 }else{//别人发的
				 $(".news_d").append("<div class='mess_left'><div><span class='messtime'>"+data[i].sendUserName+"</span>&nbsp;&nbsp;:&nbsp;&nbsp;<span class='messtime'>"+data[i].createTimeStr+"</span></div> <div class='message_left_con' >"+data[i].content+"</div></div>");
				 $("#content").val("");
				 $('.news_d').scrollTop( $('.news_d')[0].scrollHeight );
			 }
			
			}
		},
		error : function() {
			alert("error");
		}
	});
	
	
}
function resive2(){
	var uid = ${userId}
	$.ajax({
		type : 'post',
		url : ctx+"/message_findMessage.do",
		dataType : "json",
		success : function(data) {
			for (var i=0;i<data.length;i++)
			{
			//document.write(cars[i] + "<br>");
			//自己发的
			 if(data[i].sendUserId == uid ){
				 $(".news_d").append(" <div class='mess_right'><div class='nameMe'><span class='messtime'>"+data[i].sendUserName+"</span>&nbsp;&nbsp;:&nbsp;&nbsp;<span class='messtime'>"+data[i].createTimeStr+"</span></div><div class='message_right_con'>"+data[i].content+"</div> </div>");
				 $('.news_d').scrollTop( $('.news_d')[0].scrollHeight );
			 }else{//别人发的
				 $(".news_d").append("<div class='mess_left'><div><span class='messtime'>"+data[i].sendUserName+"</span>&nbsp;&nbsp;:&nbsp;&nbsp;<span class='messtime'>"+data[i].createTimeStr+"</span></div> <div class='message_left_con' >"+data[i].content+"</div></div>");
				 $('.news_d').scrollTop( $('.news_d')[0].scrollHeight );
			 }
			
			}
		},
		error : function() {
			alert("error");
		}
	});
	
	
}
});
</script>
</body>
</html>
