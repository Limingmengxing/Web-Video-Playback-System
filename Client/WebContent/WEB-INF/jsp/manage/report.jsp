<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!-- 评价界面 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <title>后台管理系统</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/css/style.css" />
    <script type="text/javascript" src="${ctx}/resource/js/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/ckform.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/common.js"></script>
     <script type="text/javascript" src="${ctx}/resource/js/echarts.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/echarts/echarts-all.js"></script>
</head>
  <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }
        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
       td{text-align:center;}
    </style>
<body>
<!-- <form class="form-inline definewidth m20" action="index.html" method="post">  
     <button type="button" class="btn btn-success" id="addnew">新增机构</button>
</form> -->
<table class="table table-bordered table-hover definewidth m10" align="center" style="margin: 0 auto;">
      <tr >
       <td align="center"> <button class="btn btn-primary">上月与本月数据统计分析</button></td>
      </tr>
      <tr>
        <td bordercolor="red">
           <div style="height:500px;width: 1100px" id="user">
            
           </div>
        </td>
      </tr>
       <tr>
        <td bordercolor="red">
           <div style="height:500px;width: 1100px" id="say">
            
           </div>
        </td>
      </tr>
 </table>
</body>
<script>
    $(function () {
    	
    });
</script>