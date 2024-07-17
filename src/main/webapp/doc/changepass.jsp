<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改密码</title>

</head>
<style>
    /* 为div设置样式 */
    #box {
        width: 400px;
        border: 3px solid #ccc;
        margin: 100px auto;
        padding: 1px;
        position: relative;
    }


    /* 为input设置样式 */
    #box input {
        width: 370px;
        height: 30px;
        border-top: 1px ;
        border-left:1px ;
        border-right:1px;
        margin: 3px auto;
        /* 清除浏览器默认的聚焦样式 */
        outline: none;
    }

    /* 为img设置样式 */
    #box img {
        display:block;
        margin:5px auto;
        position: relative;
        top: 4px;
        bottom: 5px;
        right: 6px;
        width: 24px;
        /* 把鼠标的样式换成小手 */
        cursor: pointer;
    }
</style>

<body>

<div id="box">
    <form action="/doc/changepass"method="post">
    <input type="password" id="pwd" name="password" placeholder="请输入新密码">
    <input type="password" id="pwd2" name="password2" placeholder="请再次输入新密码">
    <img src="../images/close.jpg" id="eye">
    <button type="submit" style="display:block;margin:0 auto">确认修改</button>
    </form>
</div>

<script>
    //1、获取元素
    var pwd = document.getElementById("pwd");
    var pwd2 = document.getElementById("pwd2");
    var eye = document.getElementById("eye");
    var flag = 0;//默认眼睛是关上的
    //2、注册事件，定义事件处理程序
    eye.onclick = function () {
        if (flag == 0) {//当眼睛是闭上的时候，点击后：
            pwd.type = "text";//密码框样式换成文本，即可显示密码
            pwd2.type = "text";//密码框样式换成文本，即可显示密码
            eye.src = "../images/open.jpg";//图片地址修改为眼睛打开的图片
            flag = 1;
        } else {
            pwd.type = "password";//文本框换成密码框
            pwd2.type = "password";//文本框换成密码框
            eye.src = "../images/close.jpg";//图片换成闭眼的
            flag = 0;
        }
    }
</script>
</body>

</html>
