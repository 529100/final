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
    <script src="/js/pintuer.js"></script>
    <script src="/js/jquery-3.7.1.min.js"></script>
</head>

<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>医生注册</strong></div>
    <div class="body-content">
        <form  method="post" class="form-x" action="/save" enctype="multipart/form-data" >

            <if condition="$iscid eq 1">
                <div class="form-group">
                    <div class="field">
                        <select name="deptId" class="input w50">
                            <option value="">请选择所属科室</option>
                            <c:forEach items="${list}" var="dept">
                                <option value="${dept.department_id}">${dept.department_name}</option>
                            </c:forEach>
                        </select>
                        <div class="tips"></div>
                    </div>
                </div>
            </if>

            <div class="form-group">
                <div class="field field-icon-right">
                    <input type="text" class="input input-big" name="name" placeholder="姓名"  />
                    <span class="icon icon-user margin-small"></span>
                </div>
            </div>


            <div class="form-group">
                <div class="field field-icon-right">
                    上传照片<input type="file" class="input input-big" name="docavatar" />
                    <span class="icon icon-key margin-small"></span>
                </div>
            </div>

            <div class="form-group">
                <div class="field field-icon-right">
                    <input type="text" class="input input-big" name="phone" placeholder="电话号码"  />
                    <span class="icon icon-user margin-small"></span>
                </div>
            </div>

            <div class="form-group">
                <div class="field field-icon-right">
                    <input type="text" class="input input-big" name="email" placeholder="邮箱"  />
                    <span class="icon icon-user margin-small"></span>
                </div>
            </div>

            <div class="form-group">
                <div class="field field-icon-right">
                    <input type="text" class="input input-big" name="password" placeholder="密码"  />
                    <span class="icon icon-user margin-small"></span>
                </div>
            </div>

            <div class="form-group">
                <div class="field field-icon-right">
                    <input type="text" class="input input-big" name="introduce" placeholder="介绍"  />
                    <span class="icon icon-user margin-small"></span>
                </div>
            </div>

            <div class="form-group">
                <div class="field field-icon-right">
                    <input type="text" class="input input-big" name="fee" placeholder="挂号费"  />
                    <span class="icon icon-user margin-small"></span>
                </div>
            </div>

            <div class="form-group">
                <div class="field">
                    <select name="zhiwei" class="input w50">
                        <option value="">请选择你的职位</option>
                        <c:forEach items="${list1}" var="profession">
                            <option value="${profession.id}">${profession.titleName}</option>
                        </c:forEach>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>



            <div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="添加"></div>

        </form>

    </div>
</div>

</body>
</html>