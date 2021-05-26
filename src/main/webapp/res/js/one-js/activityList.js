layui.use(['form','layer','laydate','table','upload'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        upload = layui.upload,
        table = layui.table;

    //活动表列表
    var tableIns = table.render({
        elem: '#list',
        url : path + '/activity/activityData.do',
        page : true,
        cellMinWidth : 95,
        height : "full-104",
        limit : 20,
        limits : [10,15,20,25],
        id : "tables",
        cols : [[
					{field : 'aName',title : '活动名称',align : 'center'},
					{field : 'name',title : '添加人',align : 'center'},
					{field : 'addTime',title : '添加时间',align : 'center',sort : true},
					{field : 'cName',title : '课程',align : 'center'},
					{field : 'startTime',title : '开始时间',align : 'center',sort : true},
					{field : 'endTime',title : '结束时间',align : 'center',sort : true},
					{field : 'carefulInfo',title : '注意事项',align : 'center'},
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
                	type: $(".type").val()  //查询内容，代码生成后手动修改
                }
            })
    });

    //日期时间选择器
    laydate.render({
        elem: '#startTime'
        ,type: 'datetime'
    });
    //日期时间选择器
    laydate.render({
        elem: '#endTime'
        ,type: 'datetime'
    });


    //添加活动表
    function addLink(edit){
        var index = layer.open({
            title : "添加活动表",
            type : 2,
			area: ['540px', '550px'],
            content : path + "/activity/form.do"
        })
    }
  //添加活动表
    function editLink(edit){
        var index = layer.open({
            title : "修改活动表",
            type : 2,
			area: ['540px', '550px'],
            content : path + "/activity/edit.do?id="+edit.id
        })
    }

    //绑定编辑活动表事件
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
            layer.confirm('确定删除选中的活动表？', {icon: 3, title: '提示信息'}, function (index) {
            	var ajaxReturnData;
                $.ajax({
		            url: path + '/activity/deleteBatch.do',
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
            layer.msg("请选择需要删除的活动表");
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
            layer.confirm('确定删除此活动表？',{icon:3, title:'提示信息'},function(index){
                var ajaxReturnData;
		        $.ajax({
		            url: path + '/activity/delete.do',
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
		}
    });

    $.ajax({
        url: '/course/courseList.do',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            console.log(data);
            if (data.code == 200) {
                var oldCourseId = $("#oldCourseId").val();
                $.each(data.data,function (key,val) {
                    if (oldCourseId == val.id){
                        $("#courseId").append("<option value='"+val.id+"' selected>"+val.cName+"</option>")
                    } else{
                        $("#courseId").append("<option value='"+val.id+"'>"+val.cName+"</option>")
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
            url: path + '/activity/save.do',
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
    })

})