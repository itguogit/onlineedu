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
<fieldset class="layui-elem-field layui-field-title site-title">
   <legend><a name="methodRender">课程信息</a></legend>
 </fieldset>
 
<form class="layui-form linksAdd">
	<input type="hidden" name="id" value="${course.id }">
<%--		<div class="layui-form-item">--%>
<%--			<label class="layui-form-label">主键</label>--%>
<%--			<div class="layui-input-block">--%>
<%--				<input type="text" name="id" value="${course.id }" class="layui-input" lay-verify="required" placeholder="请输入主键" />--%>
<%--			</div>--%>
<%--		</div>--%>
		<div class="layui-form-item">
			<label class="layui-form-label">课程名称</label>
			<div class="layui-input-block">
				<input type="text" name="cName" value="${course.cName }" class="layui-input" lay-verify="required" placeholder="请输入课程名称" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">课程类别</label>
			<div class="layui-input-block">
				<input type="text" name="cTypeOld" value="${course.cType }" class="layui-input" lay-verify="required" placeholder="请输入课程类别主键" />
				<select name="cType" id="cType" lay-filter="cType">
					<option value="">请选择课程类别</option>
				</select>
			</div>
		</div>


		<div class="layui-form-item">
			<label class="layui-form-label">课程编号</label>
			<div class="layui-input-block">
				<input type="text" name="cNum" value="${course.cNum }" class="layui-input" lay-verify="required" placeholder="例：第五集" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">课程描述</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入课程描述" class="layui-textarea" name="cDesc" value="${course.cDesc }"></textarea>

<%--				<input type="text"  class="layui-input" lay-verify="required" placeholder="请输入课程描述" />--%>
			</div>
		</div>
<%--		<div class="layui-form-item">--%>
<%--			<label class="layui-form-label">状态</label>--%>
<%--			<div class="layui-input-block">--%>
<%--				<input type="text" name="cState" value="${course.cState }" class="layui-input" lay-verify="required" placeholder="请输入状态  1 正常 2删除" />--%>
<%--			</div>--%>
<%--		</div>--%>
		<%--		<div class="layui-form-item">--%>
		<%--			<label class="layui-form-label">视频的访问链接</label>--%>
		<%--			<div class="layui-input-block">--%>
		<%--				<input type="text" name="tUrl" value="${course.tUrl }" class="layui-input" lay-verify="required" placeholder="请输入视频的访问链接" />--%>
		<%--			</div>--%>
		<%--		</div>--%>
	
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