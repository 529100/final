<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>预约挂号页面</title>
    <link rel="stylesheet" href="/css/pintuer.css">
    <link rel="stylesheet" href="/css/admin.css">
    <script src="/js/jquery-3.7.1.min.js"></script>
    <script src="/js/pintuer.js"></script>
</head>
<body>
<%--<form method="post" action="/mnt" id="listform">--%>
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">

                <if condition="$iscid eq 1">
                    <li> <a class="button border-main icon-plus-square-o" href="add.html"> 添加内容</a> </li>
                    <li>
                        <select name="deptId" class="input" style="width:200px; line-height:17px;" onchange="">
<%--                            <option value="">请选择科室</option>--%>

                        </select>
                    </li>
                </if>
                <li>
<%--                    <input type="text" placeholder="请输入预约科室" name="deptId" class="input" style="width:250px; line-height:17px;display:inline-block" />--%>
                    <input type="text" placeholder="请输入预约日期" name="date" class="input" style="width:250px; line-height:17px;display:inline-block" />
                    <output class="text">${sessionScope.patients.patientId}(您的编号)</output>
                    <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
            </ul>
        </div>
        <table class="table table-hover text-center">
            <thead>
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">ID</th>
                <!--<th width="10%">排序</th>-->
                <th>工号</th>
                <th>姓名</th>
                <th>头像</th>
                <th>手机号</th>
                <th>挂号费</th>
                <th>科室名称</th>
                <th>职称</th>
                <th width="310">操作</th>
            </tr>
            </thead>

            <tbody id="docBody">

            </tbody>

            <tr>
                <td style="text-align:left; padding:19px 0;padding-left:20px;"><input type="checkbox" id="checkall"/>
                    全选 </td>
                <td colspan="7" style="text-align:left;padding-left:20px;"><a href="javascript:void(0)" class="button border-red icon-trash-o" style="padding:5px 15px;" onclick="DelSelect()"> 删除</a> <a href="javascript:void(0)" style="padding:5px 15px; margin:0 10px;" class="button border-blue icon-edit" onclick="sorts()"> 排序</a> 操作：
                    <select name="ishome" style="padding:5px 15px; border:1px solid #ddd;" onchange="changeishome(this)">
                        <option value="">首页</option>
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                    <select name="isvouch" style="padding:5px 15px; border:1px solid #ddd;" onchange="changeisvouch(this)">
                        <option value="">推荐</option>
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                    <select name="istop" style="padding:5px 15px; border:1px solid #ddd;" onchange="changeistop(this)">
                        <option value="">置顶</option>
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                    &nbsp;&nbsp;&nbsp;

                    移动到：
                    <select name="movecid" style="padding:5px 15px; border:1px solid #ddd;" onchange="changecate(this)">
                        <option value="">请选择分类</option>
                        <option value="">产品分类</option>
                        <option value="">产品分类</option>
                        <option value="">产品分类</option>
                        <option value="">产品分类</option>
                    </select>
                    <select name="copynum" style="padding:5px 15px; border:1px solid #ddd;" onchange="changecopy(this)">
                        <option value="">请选择复制</option>
                        <option value="5">复制5条</option>
                        <option value="10">复制10条</option>
                        <option value="15">复制15条</option>
                        <option value="20">复制20条</option>
                    </select></td>
            </tr>

                <td colspan="8">
                    <div class="pagelist">
                        <a href="javascript:void(0)" id="pre" onclick="prePage()">上一页</a>

                        <a href="javascript:void(0)"  id="next" onclick="nextPage()">下一页</a>
                        <a href="javascript:void(0)"  id="last" onclick="lastPage()">尾页</a>
                    </div>
                </td>


        </table>
    </div>
<%--</form>--%>
<script type="text/javascript">
    //发送ajax请求 Doct/list
    //页面加载完成之后调用的函数
    function initDoclist(p,deptId,date){
        $.ajax({
            type: "GET",
            url: "/patient/arrange",
            data: {"pageNum":p,"deptId":deptId,"date":date},
            dataType: "json",
            success: function (res) {
                $("#docBody").empty()
                console.log("res",res)
                $.each(res.list, function (i, v) {

                    var trObj = $("<tr></tr>");
                    trObj.append($("<td>" + v.doctor_id+ "</td>"));
                    trObj.append($("<td>" + v.doctors.jobNumber + "</td>"));
                    trObj.append($("<td>" + v.doctors.name + "</td>"));
                    trObj.append($('<td><img width="50" height="50" src="/img/'+v.doctors.avatar+'"></img></td>'));
                    trObj.append($("<td>" + v.doctors.phone + "</td>"));
                    trObj.append($("<td>" + v.doctors.registrationFee + "</td>"));
                    trObj.append($("<td>" + v.departments.department_name + "</td>"));
                    trObj.append($("<td>" + v.professionalTitles.titleName + "</td>"));
                    trObj.append($('<a class="button border-main" href="/toarrange?money='+v.doctors.registrationFee+'&doctor_id='+v.doctor_id+'&date='+v.date+'"><span class="icon-edit"></span>上午预约</a >'));
                    trObj.append($('<a class="button border-red" href="/toarrange?money='+v.doctors.registrationFee+'&doctor_id='+v.doctor_id+'&date='+v.date+'"><span class="icon-edit"></span>下午预约</a >'));
                    //trObj .append($('<td><a class="button border-main" href=" /toEdit?deptId='+v.department_id+'"><spanclass="icon-edit"></span> 修改</a >'))
                    trObj.appendTo($("#docBody"));
                });
                //将pagelist的span删除再渲染
                $(".pagelist span").remove()
                for (var i=0;i<res.pages;i++){
                    var $span = $("<span onclick='changePage($(this).html())'>"+(i+1)+"</span>")
                    if ((i+1)==res.pageNum){
                        $span.attr("class","current")
                    }

                    $("#next").before($span)
                }
            }
        })
    }
    function initDeptlist(){
        $.ajax({
            type: "GET",
            url: "/second/list",

            dataType: "json",
            success: function (res) {
                console.log("res",res)
                //$("#docBody").empty()
                $.each(res, function (i, v) {

                    var optionObj = $("<option value='"+v.department_id+"'>"+v.department_name+"</option>");
                    optionObj.appendTo($("select[name='deptId']"));
                });

            }
        })
    }
    $(function (){
        initDoclist(1,6,"");
        initDeptlist();
    })

    function changePage(p){
        initDoclist(p,6,"");
    }


    function prePage() {
        var currentPageNumber = $("span[class='current']").text()
        //页码+1
        console.log("currentPageNumber",currentPageNumber)
        console.log("prePageNumber",Number(currentPageNumber)-1)
        initDoclist(Number(currentPageNumber)-1,-1,"")//

    }

    function nextPage(){
        //获取当前页码
        var currentPageNumber = $("span[class='current']").text()
        //页码+1
        console.log("currentPageNumber",currentPageNumber)
        console.log("nextPageNumber",Number(currentPageNumber)+1)
        initDoclist(Number(currentPageNumber)+1,-1,"")//
        //initDoclist(p+1)
    }
    //搜索
    function changesearch(){
        //alert("点击了查询")
        //获取输入条件
        var $deptId = $("select[name='deptId'] option:selected").val();
        var $date = $("input[name='date']").val().trim();

        console.log($deptId,$date);
        initDoclist(1,$deptId,$date);
    }

    //单个删除
    function del(id,mid,iscid){
        if(confirm("您确定要删除吗?")){

        }
    }

    //全选
    $("#checkall").click(function(){
        $("input[name='id[]']").each(function(){
            if (this.checked) {
                this.checked = false;
            }
            else {
                this.checked = true;
            }
        });
    })

    //批量删除
    function DelSelect(){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){
            var t=confirm("您确认要删除选中的内容吗？");
            if (t==false) return false;
            $("#listform").submit();
        }
        else{
            alert("请选择您要删除的内容!");
            return false;
        }
    }

    //批量排序
    function sorts(){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){

            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");
            return false;
        }
    }


    //批量首页显示
    function changeishome(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){

            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量推荐
    function changeisvouch(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){


            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量置顶
    function changeistop(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){

            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");

            return false;
        }
    }


    //批量移动
    function changecate(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){

            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量复制
    function changecopy(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){
            var i = 0;
            $("input[name='id[]']").each(function(){
                if (this.checked==true) {
                    i++;
                }
            });
            if(i>1){
                alert("只能选择一条信息!");
                $(o).find("option:first").prop("selected","selected");
            }else{

                $("#listform").submit();
            }
        }
        else{
            alert("请选择要复制的内容!");
            $(o).find("option:first").prop("selected","selected");
            return false;
        }
    }

</script>
</body>
</html>