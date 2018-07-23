<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:include page="../../common/top.jsp"/>
<link rel="stylesheet" href="/css/reset.css">
<link rel="stylesheet" href="/css/style.css">

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 员工列表 </h2>
            <p class="lead"></p>
        </div>
        <div class="searchbox">
            <form action="#" method="post">
                <div class="mod_select">
                    <select id="subject" name="subject" class="form-control input-sm">
                        <option value="" class="sub-op">全部</option>
                        <option value="1" class="sub-op">浙大旭日</option>
                        <option value="2" class="sub-op">万维镜像</option>
                        <option value="3" class="sub-op">学呗科技</option>
                    </select>
                </div>
                <div class="mod_select1">
                    <select id="dept-select" name="dept" class="form-control input-sm">
                        <option value="" class="sub-op">全部</option>
                    </select>
                </div>
                <input type="text" name="name" id="name" class="import1" placeholder="请输入员工姓名...">
                <input type="submit" value="搜   索" class="btn-search">
            </form>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel  heading-border">
                <div class="panel-menu">
                    <div class="row">
                        <div class="hidden-xs hidden-sm col-md-3">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light" onclick="javascript:window.location.href='/work/empl/page.page';">
                                    <i class="fa fa-refresh"></i>
                                </button>
                                <button type="button" class="btn btn-default light" id="add-empl">
                                    <i class="fa fa-plus"></i>
                                </button>
                            </div>
                        </div>

                        <div class="col-xs-12 col-md-9 text-right">
                            <%--分页--%>
                            <span id="current-page" class="hidden-xs"></span>&nbsp;
                            <span id="total-page" class="hidden-xs"></span>&nbsp;
                            <span id="total-records" class="hidden-xs"></span>&nbsp;
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light" id="prepage-bt">
                                    <i class="fa fa-chevron-left"></i>
                                </button>
                                <button type="button" class="btn btn-default light" id="nextpage-bt">
                                    <i class="fa fa-chevron-right"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-body pn">
                    <table id="message-table" class="table admin-form theme-warning tc-checkbox-1">
                        <thead>
                        <tr class="">
                            <th class="text-center hidden-xs">工号</th>
                            <th class="text-center hidden-xs">姓名</th>
                            <th class="text-center hidden-xs">所属部门</th>
                            <th class="text-center hidden-xs">职务</th>
                            <th class="text-center">操作</th>
                        </tr>
                        </thead>
                        <%--Mustache引擎渲染--%>
                        <tbody id="emplList"></tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div id="dialog-emplInfo-form" style="display: none;">
        <form id="emplInfoForm">
            <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid">
                <tr>
                    <td><label for="emplInfoName">姓名</label></td>
                    <td><input type="text" name="username" id="emplInfoName" value="" class="text ui-widget-content ui-corner-all" readonly="true"></td>
                </tr>
                <tr>
                    <td style="width: 80px;"><label for="emplInfoDeptId">所在部门</label></td>
                    <td><input type="text" name="deptId" id="emplInfoDeptId" class="text ui-widget-content ui-corner-all" readonly="true"/></td>
                </tr>
                <tr>
                    <td><label for="emplInfoMail">邮箱</label></td>
                    <td><input type="text" name="mail" id="emplInfoMail" value="" class="text ui-widget-content ui-corner-all" readonly="true"></td>
                </tr>
                <tr>
                    <td><label for="emplInfoTelephone">电话</label></td>
                    <td><input type="text" name="telephone" id="emplInfoTelephone" value="" class="text ui-widget-content ui-corner-all" readonly="true"></td>
                </tr>
                <tr>
                    <td><label for="emplInfoPost">职位</label></td>
                    <td><input type="text" name="post" id="emplInfoPost" value="" class="text ui-widget-content ui-corner-all" readonly="true"></td>
                </tr>
                <tr>
                    <td><label for="emplInfoRemark">备注</label></td>
                    <td><textarea name="remark" id="emplInfoRemark" class="text ui-widget-content ui-corner-all" rows="3" cols="25" readonly="true"></textarea></td>
                </tr>
            </table>
        </form>
    </div>
    <div id="dialog-empl-form" style="display: none;">
        <form id="emplForm">
            <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid">
                <tr>
                    <td><label for="emplName">姓名</label></td>
                    <td><input type="text" name="username" id="emplName" value="" class="text ui-widget-content ui-corner-all" readonly="true"></td>
                </tr>
                <tr>
                    <td style="width: 80px;"><label for="emplDeptId">所在部门</label></td>
                    <td><input type="text" name="deptId" id="emplDeptId" class="text ui-widget-content ui-corner-all" readonly="true"/></td>
                </tr>
                <tr>
                    <td><label for="emplMail">邮箱</label></td>
                    <td><input type="text" name="mail" id="emplMail" value="" class="text ui-widget-content ui-corner-all" readonly="true"></td>
                </tr>
                <tr>
                    <td><label for="emplTelephone">电话</label></td>
                    <td><input type="text" name="telephone" id="emplTelephone" value="" class="text ui-widget-content ui-corner-all" readonly="true"></td>
                </tr>
                <tr>
                    <td><label for="emplPost">职位</label></td>
                    <td><input type="text" name="post" id="emplPost" value="" class="text ui-widget-content ui-corner-all" readonly="true"></td>
                </tr>
                <tr>
                    <td><label for="emplInfoRemark">备注</label></td>
                    <td><textarea name="remark" id="emplRemark" class="text ui-widget-content ui-corner-all" rows="3" cols="25" readonly="true"></textarea></td>
                </tr>
            </table>
        </form>
    </div>
</section>
<jsp:include page="../../common/bottom.jsp"/>
<script id="emplListTemplate" type="x-tmpl-mustache">
{{#emplList}}
<tr class="message-unread" data-sn="{{sn}}">
    <td>{{sn}}</td>
    <td class="text-center">{{name}}</td>
    <td class="text-center fw600">{{showDeptName}}</td>
    <td class="text-center hidden-xs">
        <span class="badge badge-warning mr10 fs11">{{post}}</span>
    </td>
    <td class="text-center">
        <a href="#" data-id="{{sn}}" class="empl-info">详细信息</a>
        <a href="#" data-id="{{sn}}" class="empl-edit">编辑</a>
    </td>
</tr>
{{/emplList}}
</script>
<script type="text/javascript">
    $(function(){
        var emplList;
        var emplMap={};//储存员工信息map
        var emplListTemplate = $('#emplListTemplate').html();
        Mustache.parse(emplListTemplate);

        var subject;
        var deptId;
        var name="";
        var deptList;
        var pageInfo;//分页信息
        var deptMap1={};//用于存储不同隶属部门
        var deptMap2={};
        var deptMap3={};

        loadEmplList();
        saveDeptName();

        //关联选择
        $("#subject").change(function(){
            $("#dept-select").empty();
            $("#dept-select").append("<option value=''"
                + "class='sub-op'>"
                + "全部"
                + "</option>");
            if($(this).val() == ""){
                return;
            }else if($(this).val() == 1){
                $.each(deptMap1,function(i,dept){
                    $("#dept-select").append("<option value='"+dept.id+"'"
                        + "class='sub-op'>"
                        + dept.name
                        + "</option>");
                });
            }else if($(this).val() == 2){
                $.each(deptMap2,function(i,dept){
                    $("#dept-select").append("<option value='"+dept.id+"'"
                        + "class='sub-op'>"
                        + dept.name
                        + "</option>");
                });
            }else if($(this).val() == 3){
                $.each(deptMap3,function(i,dept){
                    $("#dept-select").append("<option value='"+dept.id+"'"
                        + "class='sub-op'>"
                        + dept.name
                        + "</option>");
                });
            }
        });
        //存储部门名字
        function saveDeptName(){
            $.ajax({
                url:"/work/dept/list.json",
                success:function(result){
                    if(result.ret){
                        deptList = result.data;
                        var x = 0;
                        var y = 0;
                        var z = 0;
                        $.each(deptList,function(i,dept){
                            if(dept.subject == 1){
                                deptMap1[x]=dept;
                                x++;
                            }else if(dept.subject == 2){
                                deptMap2[y]=dept;
                                y++;
                            }else if(dept.subject == 3){
                                deptMap3[z]=dept;
                                z++;
                            }
                            /* //渲染部门选项卡
                            $("#dept-select").append("<option value='"+dept.id+"'"
                                + "class='sub-op'>"
                                + dept.name
                                + "</option>");*/
                        });
                    }
                    else{
                        showMessage("加载部门列表",result.msg,false);
                    }
                }
            });
        }
        //读取员工列表
        function loadEmplList(){
            $.ajax({
                url:"/work/empl/list.json",
                data:{
                    pageIndex:""
                },
                success:function(result){
                    if(result.ret){
                        showEmplList(result);
                        showPageInfo(result);
                    }else{
                        showMessage("加载员工列表",result.msg,false);
                    }
                }
            });
        }
        //显示员工列表
        function showEmplList(result){
            if(!$.isEmptyObject(result.data)){
                $.each(result.data.data,function(i,empl){
                    emplMap[empl.sn] = empl;
                });
                var rendered = Mustache.render(emplListTemplate,{
                    emplList:result.data.data,
                    "showDeptName":function(){
                        return this.subject == 1?"浙大旭日—" + this.department.name:
                            (this.subject == 2?"万维镜像—" + this.department.name:"学呗科技—" + this.department.name);
                    }});
                $("#emplList").html(rendered);
                bindUserClick();
            }else{
                $("#emplList").html("");
            }
        }
        //绑定员工列表操作
        function bindUserClick(){
            //用户信息
            $(".empl-info").click(function(e){
                var emplSn = $(this).attr("data-id");
                $("#dialog-emplInfo-form").dialog({
                    model:true,
                    title:"查看信息",
                    open:function(event,ui){
                        $(".ui-dialog-titlebar-close",$(this).parent()).hide();
                        $("#emplInfoForm")[0].reset();
                        var targetDept = emplMap[emplSn];
                        var deptName = targetDept.subject == 1?"浙大旭日—" + targetDept.department.name:
                            (targetDept.subject == 2?"万维镜像—" + targetDept.department.name:"学呗科技—" + targetDept.department.name);
                        if(targetDept){
                            $("#emplInfoDeptId").val(deptName);
                            $("#emplInfoName").val(targetDept.name);
                            $("#emplInfoMail").val(targetDept.mail);
                            $("#emplInfoTelephone").val(targetDept.telephone);
                            $("#emplInfoPost").val(targetDept.post);
                            $("#emplInfoRemark").val(targetDept.remark);
                        }
                    },
                    buttons :{
                        "关闭":function(e){
                            e.preventDefault();
                            $("#dialog-emplInfo-form").dialog("close");
                        }
                    }
                });
            });
        }
        //显示分页信息
        function showPageInfo(result){
            if(!$.isEmptyObject(result.data)){
                pageInfo = result.data.pageInfo;
                if(pageInfo.isFirstPage){
                    $("#prepage-bt").attr("disabled", true);
                }else{
                    $("#prepage-bt").attr("disabled", false);
                }
                if(pageInfo.isLastPage){
                    $("#nextpage-bt").attr("disabled", true);
                }else{
                    $("#nextpage-bt").attr("disabled", false);
                }
                $("#current-page").text("当前第"+pageInfo.pageNum+"页");
                $("#total-page").text("共"+pageInfo.pages+"页");
                $("#total-records").text("共"+pageInfo.total+"条记录");
            }
        }
        //前一页按钮
        $("#prepage-bt").click(function(e){
            e.preventDefault();
            e.stopPropagation();
            $.ajax({
                url:"/work/empl/query.json?pageIndex="+pageInfo.prePage,
                data:{
                    subject:subject,
                    deptId:deptId,
                    name:name
                },
                success:function(result){
                    if(result.ret){
                        showEmplList(result);
                        showPageInfo(result);
                    }else{
                        showMessage("加载员工列表",result.msg,false);
                    }
                }
            });
        });
        //后一页按钮
        $("#nextpage-bt").click(function(e){
            e.preventDefault();
            e.stopPropagation();
            $.ajax({
                url:"/work/empl/query.json?pageIndex="+pageInfo.nextPage,
                data:{
                    subject:subject,
                    deptId:deptId,
                    name:name
                },
                success:function(result){
                    if(result.ret){
                        showEmplList(result);
                        showPageInfo(result);
                    }else{
                        showMessage("加载员工列表",result.msg,false);
                    }
                }
            });
        });
        //搜索用户按钮
        $(".btn-search").click(function(e){
            e.preventDefault();
            e.stopPropagation();
            subject = $("#subject").val();
            deptId = $("#dept-select").val();
            name = $("#name").val();
            $.ajax({
                url:"/work/empl/query.json?pageIndex=1",
                data:{
                    subject:subject,
                    deptId:deptId,
                    name:name
                },
                success:function(result){
                    if(result.ret){
                        showEmplList(result);
                        showPageInfo(result,subject,deptId,name);
                    }
                    else{
                        showMessage("搜索用户列表",result.msg,false);
                    }
                }
            });
        });
        //添加员工
        $("#add-empl").click(function(e){
            e.preventDefault();
            e.stopPropagation();
            console.log("添加员工");
        });
        //编辑员工
        $(".empl-edit").click(function(e){
            e.preventDefault();
            e.stopPropagation();
            console.log("编辑员工");
        });

    })
</script>

