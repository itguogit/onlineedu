<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/inc/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>课程信息 </title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${path}/res/layui/css/layui.css" media="all" >
	<link rel="stylesheet" href="${path}/res/css/public.css" media="all" />
</head>
<body class="childrenBody">

<input type="hidden" class="layui-input type" placeholder="请输入搜索的内容" id="courseId"  value="${course.id }" />

<blockquote class="layui-elem-quote quoteBox">
	<form class="layui-form">
		<div class="layui-inline">
			<div class="layui-input-inline">
				<input type="text" class="layui-input type" placeholder="请输入搜索的内容" />
			</div>
			<a class="layui-btn search_btn" data-type="reload"><i class="layui-icon">&#xe615;</i>搜索</a>
		</div>
	</form>
</blockquote>
<table class="layui-table" id="list" lay-filter="tables"></table>



<script type="text/javascript" src="${path}/res/layui/layui.js"></script>
<script type="text/javascript" src="${path}/res/js/one-js/commentList.js"></script>
<script type="text/javascript">
	var path = "${path}";
</script>
</body>
</html>