layui.use(['form','layer','laydate','table','upload'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        upload = layui.upload,
        table = layui.table;

    //课程信息表列表
    var tableIns = table.render({
        elem: '#list',
        url : path + '/course/courseData.do',
        page : true,
        cellMinWidth : 95,
        height : "full-104",
        limit : 20,
        limits : [10,15,20,25],
        id : "tables",
        cols : [[
					{field : 'cName',title : '课程名称',align : 'center',sort : true,width : 150},
					{field : 'categoryName',title : '课程类别',align : 'center',sort : true, width : 150},
					{field : 'addUserName',title : '添加人员',align : 'center',sort : true,width : 150},
					{field : 'cNum',title : '课程编号',align : 'center',sort : true,width : 150},
					{field : 'cDesc',title : '课程描述',align : 'center',sort : true},
                    {field : 'tUrl',title : '视频状态',align : 'center',sort : true, width : 150, templet: function (d) {
                       if (d.tUrl == "" || d.tUrl == null){
                           return "未上传";
                       } else{
                           return "已上传";
                       }
                    }},
				{
					title : '操作',
					fixed : "right",
					align : "center",
					templet : '#flinkbar'
				}
        ]]
    });

    //搜索
    $(".search_btn").on("click",function(){
        table.reload("tables",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                cName: $("#cName").val()  //查询内容，代码生成后手动修改
            }
        })
    });

    //添加课程信息表
    function addLink(edit){
        var index = layer.open({
            title : "添加课程信息表",
            type : 2,
			area: ['540px', '550px'],
            content : path + "/course/form.do"
        })
    }

    //添加课程信息表
    function editLink(edit){
        var index = layer.open({
            title : "修改课程信息表",
            type : 2,
			area: ['540px', '550px'],
            content : path + "/course/edit.do?id="+edit.id
        })
    }

    //绑定编辑课程信息表事件
    $(".addLink_btn").click(function(){
        addLink();
    })

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('tables'),
            data = checkStatus.data,
            linkId = [];
        if(data.length > 0) {
            for (var i in data) {
                linkId.push(data[i].id);
            }
            layer.confirm('确定删除选中的课程信息表？', {icon: 3, title: '提示信息'}, function (index) {
            	var ajaxReturnData;
                $.ajax({
		            url: path + '/course/deleteBatch.do',
		            type: 'post',
		            async: false,
		            data: {ids:linkId.toString()},
		            success: function (data) {
		                ajaxReturnData = data;
		              //删除结果
				        if (ajaxReturnData == '0') {
				            table.reload('tables');
				            layer.msg('删除成功', {icon: 1});
				        } else {
				        	layer.msg('删除失败', {icon: 5});
				        }
		            }
		        });
            })
        }else{
            layer.msg("请选择需要删除的课程信息表");
        }
    })

    //列表操作
    table.on('tool(tables)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        if(layEvent === 'edit'){ //编辑
            editLink(data);
        } else if(layEvent === 'addV'){
    		addV(data);
        }else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此课程信息表？',{icon:3, title:'提示信息'},function(index){
                var ajaxReturnData;
		        $.ajax({
		            url: path + '/course/delete.do',
		            type: 'post',
		            async: false,
		            data: {id:data.id},
		            success: function (data) {
		                ajaxReturnData = data;
		            }
		        });
		        //删除结果
		        if (ajaxReturnData == '0') {
		            table.reload('tables');
		            layer.msg('删除成功', {icon: 1});
		        } else {
		        	layer.msg('删除失败', {icon: 5});
		        }
				
				layer.close(index);
            });
		}else if(layEvent === 'upload'){ //上传
            console.log("嘿嘿");
            var index = layer.open({
                title : "上传",
                type : 2,
                area: ['540px', '550px'],
                content : path + "/course/upload.do"
            });
        }else if(layEvent === 'play'){ //播放
            console.log("嘿嘿");
            var index = layer.open({
                title : "上传",
                type : 2,
                area: ['540px', '550px'],
                content : path + "/course/play.do"
            });
        }else if(layEvent === 'comment'){ //评论
            console.log("嘿嘿");
            var index = layer.open({
                title : "上传",
                type : 2,
                area: ['540px', '550px'],
                content : path + "/course/comment.do"
            });
        }else if(layEvent === 'lookComment'){ //查看评论
            console.log("嘿嘿");
            var index = layer.open({
                title : "上传",
                type : 2,
                area: ['1000px', '540px'],
                content : path + "/course/lookComment.do"
            });
        }
    });

    // 上传文件
    upload.render({
        elem: '#test10'
        , url: '/upload/uploadvedio.do'
        , accept: 'file'
        , exts: 'mp4'
        , multiple: true
        , done: function (res) {
             if(res.code == 0){
                 $("#vedioSource").attr("src", res.url).load();
                 top.layer.msg('上传成功', {icon: 1});
             }
            console.log("软件测试");
        }
    });

    $.ajax({
        url: '/category/categoryList.do',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            console.log(data);
            if (data.code == 0) {
                var lodType = $("#cTypeOld").val();
                $.each(data.data,function (key,val) {
                    if (lodType == val.id){
                        $("#cType").append("<option value='"+val.id+"' selected>"+val.tName+"</option>")
                    } else{
                        $("#cType").append("<option value='"+val.id+"'>"+val.tName+"</option>")
                    }
                });
                form.render('select');
            } else {
                top.layer.msg('加载失败', {icon: 5});
            }
        },
        error: function () {
            top.layer.msg('系统错误', {icon: 5});
        }
    });
    
    form.on("submit(addLink)",function(data){
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        var ajaxReturnData;
        //登陆验证
        $.ajax({
            url: path + '/course/save.do',
            type: 'post',
            async: false,
            data: data.field,
            success: function (data) {
                ajaxReturnData = data;
            }
        });
        //结果回应
        if (ajaxReturnData == '0') {
        	top.layer.close(index);
        	top.layer.msg('保存成功', {icon: 1});
        	 layer.closeAll("iframe");
             //刷新父页面
             $(".layui-tab-item.layui-show",parent.document).find("iframe")[0].contentWindow.location.reload();
        } else {
        	top.layer.msg('保存失败', {icon: 5});
        }
        return false;
    });



})