<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/inc/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>活动</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${path}/res/layui/css/layui.css" media="all" >
	<link rel="stylesheet" href="${path}/res/css/public.css" media="all" />
</head>
<body class="">
	<blockquote class="layui-elem-quote quoteBox">
		<form class="layui-form">
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" class="layui-input type" placeholder="请输入搜索内容" />
				</div>
				<a class="layui-btn search_btn" data-type="reload"><i class="layui-icon">&#xe615;</i>搜索</a>
			</div>
			<div class="layui-inline">
				<a class="layui-btn layui-btn-normal addLink_btn"><i class="layui-icon">&#xe608;</i>添加活动</a>
			</div>
		</form>
	</blockquote>
	<table class="layui-table" id="list" lay-filter="tables"></table>

	<script type="text/html" id="flinkbar">
		<shiro:hasPermission name="activity:toJoin">
			<a class="layui-btn layui-btn-xs" lay-event="toJoin"><i class="layui-icon">&#xe642;</i>参加</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="activity:joinUser">
			<a class="layui-btn layui-btn-xs" lay-event="joinUser"><i class="layui-icon">&#xe642;</i>参与人</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="activity:edit">
			<a class="layui-btn layui-btn-xs" lay-event="edit"><i class="layui-icon">&#xe642;</i>编辑</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="activity:del">
			<a class="layui-btn layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe642;</i>删除</a>
		</shiro:hasPermission>
	</script>

	<script type="text/javascript" src="${path}/res/layui/layui.js"></script>
	<script type="text/javascript" src="${path}/res/js/one-js/activityList.js"></script>
	<script type="text/javascript">
		var path = "${path}";
	</script>
</body>
</html>