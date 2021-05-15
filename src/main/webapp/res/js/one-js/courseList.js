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
				 {
					type : "checkbox",
					fixed : "left",
					width : 50
				},
					{field : 'id',title : '主键',align : 'center',sort : true,width : '200'},
					{field : 'cName',title : '课程名称',align : 'center',sort : true,width : '200'},
					{field : 'cType',title : '课程类别主键',align : 'center',sort : true,width : '200'},
					{field : 'addUser',title : '添加人员主键',align : 'center',sort : true,width : '200'},
					{field : 'addTime',title : '添加时间',align : 'center',sort : true,width : '200'},
					{field : 'cNum',title : '课程编号，第几集',align : 'center',sort : true,width : '200'},
					{field : 'cDesc',title : '课程描述',align : 'center',sort : true,width : '200'},
					{field : 'cState',title : '状态  1 正常 2删除',align : 'center',sort : true,width : '200'},
					{field : 'tUrl',title : '视频的访问链接',align : 'center',sort : true,width : '200'},
				{
					title : '操作',
					width : 350,
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
    })

})