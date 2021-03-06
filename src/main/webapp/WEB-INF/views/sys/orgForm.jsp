<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/inc/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>机构管理</title>
	<meta name="keywords" content="" />
    <meta name="description" content="oneManage Version:2.0" />
	<meta name="Author" content="oneyuanma" />
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<!-- load css -->
	<link rel="stylesheet" type="text/css" href="${path }/res/layui/css/layui.css" media="all">
	<link rel="stylesheet" href="${path}/res/font-awesome-4.7.0/css/font-awesome.css" />
</head>
<style type="text/css" media="screen">
	.one-tj{
		margin-left: 10px;
		margin-right: 25px;
	}
	.one-btn-btn{
		width: 230px;
		padding-top: 10px;
		margin: 0 auto;
	}
	.layui-form .layui-form-label{
		padding-left: 15px;
		color: #666666;
	}
	.layui-form .layui-input-block{
		width: 300px;
	}
	.layui-form .layui-input-block input,.layui-form .layui-input-block textarea{
		color: #aaaaaa;
	}
</style>
<body>
<div class="layui-fluid">

    <fieldset class="layui-elem-field layui-field-title site-title">
      <legend><a name="methodRender">机构编辑</a></legend>
    </fieldset>
  <form class="layui-form">
  		<input type="hidden" name="id" value="${org.id }">
  		<input type="hidden" name="pid" value="${org.pid }">
  		<div class="layui-form-item">
			<label class="layui-form-label">上级机构</label>
			<div class="layui-input-block" style="padding-top:8px;">
				${orgP.name }
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">菜单名称</label>
			<div class="layui-input-block">
				<input type="text" name="name" value="${org.name }" class="layui-input " lay-verify="required" placeholder="请输入机构名称">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">排序</label>
			<div class="layui-input-block">
				<input type="text" name="sort" value="${org.sort }" class="layui-input " lay-verify="required" placeholder="请输入排序">
			</div>
		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label">机构类型</label>
		    <div class="layui-input-block">
		      <select name="type" lay-verify="required" id="sel">
	        	<option value="0">公司</option>
	        	<option value="1" checked>部门</option>
		      </select>
		    </div>
		 </div>
		<div class="layui-form-item">
				<button class="layui-btn one-tj" lay-submit lay-filter="add">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		</div>
	</form>


</div>

<!-- 加载js文件 -->
<script type="text/javascript" src="${path }/res/layui/layui.js"></script> 
<script type="text/javascript">
	var path = "${path}";
	var type = "${org.type}";
	
	layui.use(['form','layer','jquery'],function(){
		   var $ = layui.$,
		   form = layui.form,
		   layer = layui.layer;
		   
		   //select赋值
		   $("#sel").find("option[value='" + type + "']").attr("selected",true);
		   form.render('select');
		   
			$("#Button").click(function(){
				layer.open({
					type: 2, 
					title:"选择图标",
					area: ['700px',  $(top.document).height()-280+"px"],
				    content: path +'/org/iconselect.do',
				    btn: ['确定', '关闭'],
				    yes: function(index, layero){ //或者使用btn1
		                var icon = layero.find("iframe")[0].contentWindow.$("#icon").val();
				    	$("#icno_i").attr("class", "fa "+icon);
				    	$("#icon").val(icon);
		                layer.close(index);
				    },cancel: function(index){ //或者使用btn2
				    	
				    },success: function(layero, index){
				    }
				});
				
			});
		   
		   form.on('submit(add)',function(data){
		     var ajaxReturnData;
		        //登陆验证
		        $.ajax({
		            url: path + '/org/save.do',
		            type: 'post',
		            async: false,
		            data: data.field,
		            success: function (data) {
		                ajaxReturnData = data;
		            }
		        });
		        //结果回应
		        if (ajaxReturnData == '0') {
		        	top.layer.msg('保存成功', {icon: 1});
		            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		            parent.layer.close(index); //再执行关闭                        //刷新父页面
		            parent.location.reload();
		        } else {
		        	top.layer.msg('保存失败', {icon: 5});
		        }
		        return false;
		   });
		});
</script>
</body>
</html>