<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>公告2</title>
    <link href="/css/cubeportfolio.min.css" rel="stylesheet">
    <link href="/css/owl.carousel.css" rel="stylesheet">
    <link href="/css/owl.theme.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <link href="static/css/IE8.css" rel="stylesheet">
    <script src="/js/jquery-3.7.1.min.js"></script>
    <script src="/js/pintuer.js"></script>
</head>
<body>
<%--<form method="post" action="/mnt" id="listform">--%>
<header>
    <!--页眉-->
    <div class="header">
        <div class="container">
            <p class="p14 col-md-6 col-xs-6 text-left">ustb医院</p>
            <P class="p14 col-md-6 col-xs-6 text-right"><span class="glyphicon glyphicon-earphone"></span>&nbsp;&nbsp;&nbsp;医疗咨询：0512-6500-1280</P>
        </div>
    </div>

    <!--导航-->
    <nav class="nav_top">
        <div class="container">
            <div class="navbar-header">
                <button class="navbar-toggle collapsed mean" data-toggle="collapse" data-target="#mynavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand logo"><img src="/images/logo.png"></a>
            </div>
            <div id="mynavbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav nav_li navbar-right">
                    <li>
                        <a href="/annclist2">首页</a>
                    </li>
                    <li>
                        <a href="about.html">关于我们</a>
                    </li>
                    <li>
                        <a href="product.html">医疗设施</a>
                    </li>
                    <li>
                        <a href="service.html">医疗服务</a>
                    </li>

                    <li>
                        <a href="news.html">联系我们</a>
                    </li>
                    <li>
                        <a href="/login">登录</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<td>
    <table class="table table-hover text-center" id="anncTable">
        <tbody id="anncTable tbody">
        </tbody>

    </table>
</td>

<div class="top_p clear_float">
    <P><a href="annc1.jsp">上一篇</a></P>
    <P><a href="annc3.jsp">下一篇</a></P>
</div>
<%--</form>--%>
<script type="text/javascript">
    //发送ajax请求 Doct/list
    //页面加载完成之后调用的函数
    function initannc(announcementId){
        $.ajax({
            type: "GET",
            url: "/annc/list1",
            data: {"announcementId":announcementId},
            dataType: "json",
            success: function (res) {
                console.log("res",res);
                // 清空表格内容
                $("#anncTable tbody").empty();
                // 生成表格行
                var rows =
                    // "<tr><td>ID</td><td>" + res.announcementId + "</td></tr>" +
                    "<tr><td></td> <td><pre style='font-size: 30px;'>" + res.title + "</td></tr>" +
                    "<td></td> <td>" + "发表日期："+res.creationTime +" "+" "+"   作者："+   res.creator + "</td>" +
                    "<td></td> <td></td>" +
                    "<tr><td></td><td><pre style='white-space: pre-wrap;'>" + res.content + "</pre></td></tr>" ;
                $("#anncTable tbody").append(rows);
            }
        })
    }

    $(function (){
        initannc(2);

    })
</script>
</body>
</html>
