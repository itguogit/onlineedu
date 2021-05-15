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
   <legend><a name="methodRender">编辑测试</a></legend>
 </fieldset>
 
<form class="layui-form linksAdd">
	<input type="hidden" name="id" value="${test.id }">
		<div class="layui-form-item">
			<label class="layui-form-label">id</label>
			<div class="layui-input-block">
				<input type="text" name="id" value="${test.id }" class="layui-input" lay-verify="required" placeholder="请输入id" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">数据值</label>
			<div class="layui-input-block">
				<input type="text" name="value" value="${test.value }" class="layui-input" lay-verify="required" placeholder="请输入数据值" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">标签名</label>
			<div class="layui-input-block">
				<input type="text" name="label" value="${test.label }" class="layui-input" lay-verify="required" placeholder="请输入标签名" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">类型</label>
			<div class="layui-input-block">
				<input type="text" name="type" value="${test.type }" class="layui-input" lay-verify="required" placeholder="请输入类型" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">描述</label>
			<div class="layui-input-block">
				<input type="text" name="description" value="${test.description }" class="layui-input" lay-verify="required" placeholder="请输入描述" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">排序（升序）</label>
			<div class="layui-input-block">
				<input type="text" name="sort" value="${test.sort }" class="layui-input" lay-verify="required" placeholder="请输入排序（升序）" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">可用状态：0可用 1不可用</label>
			<div class="layui-input-block">
				<input type="text" name="status" value="${test.status }" class="layui-input" lay-verify="required" placeholder="请输入可用状态：0可用 1不可用" />
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">数据值</label>
			<div class="layui-input-block">
				<input type="text" name="testValue" value="${test.testValue }" class="layui-input" lay-verify="required" placeholder="请输入数据值" />
			</div>
		</div>
	
	<!-- 按钮 -->
	<div class="layui-form-item">
		<button class="layui-btn layui-block" lay-filter="addLink" lay-submit>提交</button>
	</div>
</form>
<script type="text/javascript" src="${path}/res/layui/layui.js"></script>
<script type="text/javascript" src="${path}/res/js/one-js/testList.js"></script>
<script type="text/javascript">
	var path = "${path}";
</script>
</body>
</html>