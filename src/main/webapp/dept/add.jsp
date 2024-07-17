<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>添加科室</title>
    <link rel="stylesheet" href="../css/pintuer.css">
    <link rel="stylesheet" href="../css/admin.css">
    <script src="../js/jquery-3.7.1.min.js"></script>
    <script src="../js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel margin-top">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加科室</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="/save">
            <div class="form-group">
                <div class="label">
                    <label>一级科室：</label>
                </div>
                <div class="field">
                    <select name="pid" class="input w50">
                        <option value="-1">无</option>
                        <c:forEach items="${list}" var="dept">
                            <option value="${dept.department_id}">${dept.department_name}</option>

                        </c:forEach>
                    </select>
                    <div class="tips">不选择上级分类默认为一级科室</div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>新增科室名称：</label>
                </div>
                <div class="form-group">
                    <div class="field field-icon-right">
                        <input type="text" class="input input-big" name="department_name" /><br>
<%--                        <span class="icon icon-user margin-small"></span>--%>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>科室描述：</label>
                </div>
                <div class="form-group">
                    <div class="field field-icon-right">
                        <input type="text" class="input input-big" name="department_description"/><br><%--Departments类--%>
<%--                        <span class="icon icon-user margin-small"></span>--%>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">

<%--                    <input type="submit" class="button bg-main icon-check-square-o" > 提交--%>
                    <input type="submit" class="button bg-main icon-check-square-o" value="提交">
                </div>
            </div>

        </form>
    </div>
</div>
</body>
</html>
