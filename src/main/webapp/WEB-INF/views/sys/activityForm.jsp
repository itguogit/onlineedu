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
   <legend><a name="methodRender">编辑活动</a></legend>
 </fieldset>
 
<form class="layui-form linksAdd">
	<input type="hidden" name="id" value="${activity.id }">

		<div class="layui-form-item">
			<label class="layui-form-label">活动名称</label>
			<div class="layui-input-block">
				<input type="text" name="aName" value="${activity.aName }" class="layui-input" lay-verify="required" placeholder="请输入活动名称" />
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">开始时间</label>
			<div class="layui-input-block">
				<input type="text" name="startDate" id="startTime" value="${activity.startTime }" class="layui-input" lay-verify="required" placeholder="请输入开始时间" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">结束时间</label>
			<div class="layui-input-block">
				<input type="text" name="endDate" id="endTime" value="${activity.endTime }" class="layui-input" lay-verify="required" placeholder="请输入结束时间" />
			</div>
		</div>

	<div class="layui-form-item">
		<label class="layui-form-label">相关课程</label>
		<div class="layui-input-block">
			<input name="oldCourseId" value="${activity.courseId }" id="oldCourseId" class="layui-input" lay-verify="required" type="hidden" />
			<select name="courseId" id="courseId" lay-filter="courseId">
				<option value="">请选择课程类别</option>
			</select>
		</div>
	</div>

		<div class="layui-form-item">
			<label class="layui-form-label">活动描述</label>
			<div class="layui-input-block">
				<textarea placeholder="活动描述" class="layui-textarea" name="carefulInfo">${activity.carefulInfo }</textarea>
			</div>
		</div>

	<!-- 按钮 -->
	<div class="layui-form-item">
		<button class="layui-btn layui-block" lay-filter="addLink" lay-submit>提交</button>
	</div>
</form>
<script type="text/javascript" src="${path}/res/layui/layui.js"></script>
<script type="text/javascript" src="${path}/res/js/one-js/activityList.js"></script>
<script type="text/javascript">
	var path = "${path}";
</script>
</body>
</html>