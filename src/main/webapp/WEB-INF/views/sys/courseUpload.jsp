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

 
<form class="layui-form linksAdd">
	<input type="hidden" name="id" value="${course.id }">

	<div class="layui-form-item">
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
			<legend>拖拽上传</legend>
		</fieldset>
		<div class="layui-form-item">
			<div class="layui-upload-drag" id="test10">
				<i class="layui-icon"></i>
				<p>点击上传，或将文件拖拽到此处</p>
				<div id="uploadDemoView">
					<hr>
					<video width="320" height="240" controls>
						<source src="${path}${course.tUrl }" type="video/mp4" id="vedioSource">
					</video>
				</div>
			</div>
		</div>

	</div>
	<!-- 按钮 -->
	<div class="layui-form-item">
		<button class="layui-btn layui-block" lay-filter="addLink" lay-submit>提交</button>
	</div>

</form>
<script type="text/javascript" src="${path}/res/layui/layui.js"></script>
<script type="text/javascript" src="${path}/res/js/one-js/courseList.js"></script>
<script type="text/javascript">
	var path = "${path}";
</script>
</body>
</html>