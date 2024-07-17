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
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改患者信息</strong></div>
  <div class="body-content">
    <form  class="form-x" action="/patient/edit">


      <input type="hidden" name="id" value="${patients.patientId}">


      <div class="form-group">
        <div class="field field-icon-right">
          姓名：<input type="text" class="input input-big" name="name" placeholder="名字" value="${patients.name}" />
          <span class="icon icon-key margin-small"></span>
        </div>
      </div>

      <div class="form-group">
        <div class="field field-icon-right">
          身份证号：<input type="text" class="input input-big" name="idCardNumber" placeholder="身份证号" value="${patients.idCardNumber}" />
          <span class="icon icon-key margin-small"></span>
        </div>
      </div>

      <div class="form-group">
        <div class="field field-icon-right">
         电话号码：<input type="text" class="input input-big" name="phone" placeholder="电话号码" value="${patients.phone}" />
          <span class="icon icon-key margin-small"></span>
        </div>
      </div>

      <div class="form-group">
        <div class="field field-icon-right">
         邮箱：<input type="text" class="input input-big" name="email" placeholder="邮箱地址" value="${patients.email}" />
          <span class="icon icon-key margin-small"></span>
        </div>
      </div>

      <div class="form-group">
        <div class="field field-icon-right">
         密码：<input type="text" class="input input-big" name="password" placeholder="密码" value="${patients.password}" />
          <span class="icon icon-key margin-small"></span>
        </div>
      </div>




      <div class="form-group">
        <div class="field field-icon-right">
         余额：<input type="text" class="input input-big" name="balance" placeholder="余额" value="${patients.balance}" />
          <span class="icon icon-key margin-small"></span>
        </div>
      </div>


      <div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="确定修改"></div>

    </form>

  </div>
</div>
</body>

</html>