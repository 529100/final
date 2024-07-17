<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>信息</title>
    <link rel="stylesheet" href="../css/pintuer.css">
    <link rel="stylesheet" href="../css/admin.css">
    <script src="../js/jquery-3.7.1.min.js"></script>
    <script src="../js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel margin-top">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>信息</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="/toEditdoc?doctorId=${doctor.doctorId}" enctype="multipart/form-data">
            <%--            <隐藏域--%>
            <input type="hidden" name="doctorId" value="${doctor.doctorId}">
            <input type="hidden" name="username" value="${doctor.name}">
            <div class="form-group">
                <div class="label">
                    <label>手机号：</label>
                </div>
                <div class="form-group">
                    <div class="field field-icon-right">
                        <output class="input input-big">
                        ${doctor.phone}
                        </output>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>邮箱：</label>
                </div>
                <div class="form-group">
                    <div class="field field-icon-right">
                        <output class="input input-big">
                        ${doctor.email}
                        </output>
                    </div>
                </div>
            </div>
                <div class="form-group">
                    <div class="label">
                        <label>头像：</label>
                    </div>
                    <div class="form-group">

                            <div class="field field-icon-right">
                                <img width="70" height="70" src="/img/${doctor.avatar}"/>
                            </div>

                    </div>
                </div>
            <div class="form-group">


            </div>

            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">

                    <%--                    <input type="submit" class="button bg-main icon-check-square-o" > 提交--%>
                    <input type="submit" class="button bg-main icon-check-square-o" value="修改">
                </div>
            </div>

        </form>
    </div>
</div>
</body>
</html>
