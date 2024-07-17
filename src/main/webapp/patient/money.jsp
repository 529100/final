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
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>充值界面</strong></div>
    <div class="body-content">
        <form  method="post" class="form-x" action="/patient/money"  >

            <div class="form-group">
                <div class="field field-icon-right">
                   您当前余额：${sessionScope.patients.balance}
                </div>
            </div>


            <div class="form-group">
                <div class="field field-icon-right">
                    <input type="text" class="input input-big" name="count" placeholder="充值金额"  />
                    <span class="icon icon-user margin-small"></span>
                </div>
            </div>

            <div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="充值"></div>

        </form>

    </div>
</div>

</body>
</html>