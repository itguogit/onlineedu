<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/inc/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>OneManage后台管理模板 </title>
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
<fieldset class="layui-elem-field layui-field-title site-title">
   <legend><a name="methodRender">编辑类别表</a></legend>
 </fieldset>
 
<form class="layui-form linksAdd">
	<input type="hidden" name="id" value="${category.id }">
		<div class="layui-form-item">
			<label class="layui-form-label">主键</label>
			<div class="layui-input-block">
				<input type="text" name="id" value="${category.id }" class="layui-input" lay-verify="required" placeholder="请输入主键" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">种类名称</label>
			<div class="layui-input-block">
				<input type="text" name="tName" value="${category.tName }" class="layui-input" lay-verify="required" placeholder="请输入种类名称" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">添加人主键</label>
			<div class="layui-input-block">
				<input type="text" name="addUser" value="${category.addUser }" class="layui-input" lay-verify="required" placeholder="请输入添加人主键" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">添加时间</label>
			<div class="layui-input-block">
				<input type="text" name="addTime" value="${category.addTime }" class="layui-input" lay-verify="required" placeholder="请输入添加时间" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">状态 1 正常  2 删除</label>
			<div class="layui-input-block">
				<input type="text" name="state" value="${category.state }" class="layui-input" lay-verify="required" placeholder="请输入状态 1 正常  2 删除" />
			</div>
		</div>
	
	<!-- 按钮 -->
	<div class="layui-form-item">
		<button class="layui-btn layui-block" lay-filter="addLink" lay-submit>提交</button>
	</div>
</form>
<script type="text/javascript" src="${path}/res/layui/layui.js"></script>
<script type="text/javascript" src="${path}/res/js/one-js/categoryList.js"></script>
<script type="text/javascript">
	var path = "${path}";
</script>
</body>
</html>