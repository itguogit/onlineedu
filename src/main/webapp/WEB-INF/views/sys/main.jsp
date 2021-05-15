<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/inc/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>易学系统登录页面</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${path}/res/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${path}/res/css/one-css/font_eolqem241z66flxr.css" media="all" />
	<link rel="stylesheet" href="${path}/res/css/one-css/main.css" media="all" />
</head>
<body class="childrenBody">
	<div class="panel_box row">
		<div class="panel col">
			<a href="javascript:;" data-url="page/message/message.html">
				<div class="panel_icon">
					<i class="layui-icon" data-icon="&#xe63a;">&#xe63a;</i>
				</div>
				<div class="panel_word newMessage">
					<span>22</span>
					<cite>课程总数</cite>
				</div>
			</a>
		</div>

		<div class="panel col">
			<a href="javascript:;" data-url="page/user/allUsers.html">
				<div class="panel_icon" style="background-color:#009688;">
					<i class="layui-icon" data-icon="&#xe613;">&#xe613;</i>
				</div>
				<div class="panel_word userAll">
					<span>133</span>
					<cite>用户总数</cite>
				</div>
			</a>
		</div>

		<div class="panel col">
			<a href="javascript:;" data-url="page/news/newsList.html">
				<div class="panel_icon" style="background-color:#F7B824;">
					<i class="iconfont icon-wenben" data-icon="icon-wenben"></i>
				</div>
				<div class="panel_word waitNews">
					<span>324</span>
					<cite>评论总数</cite>
				</div>
			</a>
		</div>
		<div class="panel col max_panel">
			<a href="javascript:;" data-url="page/news/newsList.html">
				<div class="panel_icon" style="background-color:#2F4056;">
					<i class="iconfont icon-text" data-icon="icon-text"></i>
				</div>
				<div class="panel_word allNews">
					<span>123</span>
					<em>教师总数</em>
					<cite>教师总数</cite>
				</div>
			</a>
		</div>
	</div>
	<div class="row">

		<div class="sysNotice col">
			<blockquote class="layui-elem-quote title">系统概览</blockquote>
			<table class="layui-table">
				<colgroup>
					<col width="150">
					<col>
				</colgroup>
				<tbody>
					<tr>
						<td>系统名称</td>
						<td class="version">易学教育</td>
					</tr>
					<tr>
						<td>版本信息</td>
						<td class="homePage">易学 v1.0.0</td>
					</tr>
					<tr>
						<td>开发作者</td>
						<td class="author">易学教育</td>
					</tr>
					<tr>
						<td>服务器环境</td>
						<td class="server">Window + Tomcat 8.0 + MySQL5.7</td>
					</tr>
					<tr>
						<td>官网地址</td>
						<td class="dataBase"><a href="http://" target="_blank">http://www..com</a></td>
					</tr>
					<tr>
						<td>温馨提示</td>
						<td class="server">请友善评论</td>
					</tr>
					<tr>
						<td>更新计划</td>
						<td class="server">下次更新：2021-5-15</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="sysNotice col">
			<blockquote class="layui-elem-quote title">课程统计</blockquote>
			<div class="layui-elem-quote layui-quote-nm">
				<div id="main" style="width: 500px;height:250px;"></div>
			</div>
		</div>
	</div>
	<script src="${path}/res/layui/layui.js"></script>
	<script src="${path}/res/js/other-js/echarts.js"></script><!-- 图表js -->
	 <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '网站课程统计'
            },
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data: ["软件工程","C语言","Java","JSP","软件测试","需求分析"]
            },
            yAxis: {},
            series: [{
                name: '课程量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
</body>
</html>