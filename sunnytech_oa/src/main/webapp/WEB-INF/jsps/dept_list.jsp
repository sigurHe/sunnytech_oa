<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:include page="../../common/top.jsp"/>
<link rel="stylesheet" href="/css/reset.css">
<link rel="stylesheet" href="/css/style.css">
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">

        <div class="content-header">
            <h2> 部门列表 </h2>
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
                <input type="text" name="name" id="name" class="import" placeholder="请输入部门名称...">
                <input type="submit" value="搜   索" class="btn-search">
            </form>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel  heading-border">
                <div class="panel-menu">
                    <div class="row">
                        <div class="hidden-xs hidden-sm col-md-3">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light" onclick="javasript:window.location.href='/work/dept/page.page';">
                                    <i class="fa fa-refresh"></i>
                                </button>
                                <%--<button type="button" class="btn btn-default light">
                                    <i class="fa fa-trash"></i>
                                </button>--%>
                                <%--<button type="button" class="btn btn-default light" onclick="javasript:window.location.href='/department/to_add';">
                                    <i class="fa fa-plus"></i>
                                </button>--%>
                            </div>
                        </div>
                        <div class="col-xs-12 col-md-9 text-right">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-chevron-left"></i>
                                </button>
                                <button type="button" class="btn btn-default light">
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
                            <th class="text-center hidden-xs">部门隶属</th>
                            <th class="hidden-xs">部门名称</th>
                            <th class="hidden-xs">部门地址</th>
                        </tr>
                        </thead>
                        <tbody id="dept-tb">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="../../common/bottom.jsp"/>
<script type="text/javascript">
    $(function(){
        loadDeptList();
        function loadDeptList() {
            $.ajax({
                url:"/work/dept/list.json",
                success:function(result){
                    if(result.ret){
                        var deptList = result.data;
                        showDeptList(deptList);
                    }
                    else{
                        showMessage("加载部门列表",result.msg,false);
                    }
                }
            });
        }
        function showDeptList(deptList){
            if(deptList && deptList.length > 0)
                $(deptList).each(function(i,dept){
                    var subject = "";
                    if(dept.subject == 1){
                        subject = "浙大旭日";
                    }else if(dept.subject == 2){
                        subject = "万维镜像";
                    }else if(dept.subject == 3){
                        subject = "学呗科技";
                    }
                    $("#dept-tb").append("<tr class='message-unread'>"
                        + "<td>"+subject+"</td>"
                        + "<td>"+dept.name+"</td>"
                        + " <td>"+dept.address+"</td></tr>");
                });
        }
        //搜索功能
        $(".btn-search").click(function(e){
            e.preventDefault();
            e.stopPropagation();
            var subject = $(".input-sm").val();
            var name = $("#name").val();
            $.ajax({
                url:"/work/dept/query.json",
                data:{
                    subject:subject,
                    name:name
                },
                success:function(result){
                    if(result.ret){
                        var deptList = result.data;
                        showDeptList(deptList);
                    }
                    else{
                        showMessage("搜索部门列表",result.msg,false);
                    }
                }
            });
        })
        
    })
</script>

