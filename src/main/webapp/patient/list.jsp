<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="/css/pintuer.css">
    <link rel="stylesheet" href="/css/admin.css">
    <script src="/js/jquery-3.7.1.min.js"></script>
    <script src="/js/pintuer.js"></script>
</head>
<body>
<form method="post" action="" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <li> <a class="button border-main icon-plus-square-o" href="/admin/addpatient.jsp"> 添加内容</a> </li>
            </ul>
        </div>
        <table class="table table-hover text-center">
            <thead>
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">编号</th>
                <th>姓名</th>
                <th>照片</th>
                <th>身份证号</th>
                <th>电话号码</th>
                <th>邮箱</th>
                <th>余额</th>
                <th width="310">操作</th>
            </tr>
            </thead>
            <tbody id="Body">

            </tbody>
            <tr>
                <td colspan="8">
                    <div class="pagelist">
                        <a href="javascript:void(0)" id="pre" onclick="prePage()">上一页</a>
                        <a href="javascript:void(0)" id="next" onclick="nextPage()">下一页</a>
                        <a href="javascript:void(0)">尾页</a>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</form>
<script type="text/javascript">
    //发送ajax,请求doc/list
    //页面加载完成后执行
    function initPatientList(p){
        $.ajax({
            type:"GET",
            url:"/patient/list",
            data:{"pageNum":p},
            dataType:"json",
            success:function (res){
                console.log("res",res);
                $("#Body").empty();
                $.each(res.list,function (i,v){
                    var trObj = $("<tr></tr>");
                    trObj.append($("<td>"+v.patientId+"</td>"));
                    trObj.append($("<td>"+v.name+"</td>"));
                    trObj.append($('<td><img width="70" height="50" src="/img/'+v.avatar+'"></img></td>'));
                    trObj.append($("<td>"+v.idCardNumber+"</td>"));
                    trObj.append($("<td>"+v.phone+"</td>"));
                    trObj.append($("<td>"+v.email+"</td>"));
                    trObj.append($("<td>"+v.balance+"</td>"));
                    trObj.append($('<a class="button border-main" href="/patient/toEdit?id='+v.patientId+'"><span class="icon-edit"></span> 修改</a>'));
                    trObj.append($('<a class="button border-red" href="/patient/delete1?id='+v.patientId+'" onclick="return del(1,1,1)"><span class="icon-edit"></span>删除</a>'));
                    trObj.appendTo($("#Body"));
                })
                $(".pagelist span").remove()
                for (var i= 0;i<res.pages;i++){
                    var $span=$("<span onclick='changePage($(this).html())'>"+(i+1)+"</span>")
                    if ((i+1)==res.pageNum){
                        $span.attr("class","current")
                    }
                    $("#next").before($span)
                }
            }
        })
    }

    $(function (){
        initPatientList(1);
    })
    function changePage(p){
        initPatientList(p);
    }
    function prePage()
    {
        var currentPageNum = $("span[class='current']").text()

        initPatientList(Number(currentPageNum)-1)
    }
    function nextPage()
    {
        var currentPageNum = $("span[class='current']").text()

        initPatientList(Number(currentPageNum)+1)
    }


    //单个删除
    function del(id,mid,iscid){
        if(confirm("您确定要删除吗?")){

        }
    }




</script>
</body>
</html>