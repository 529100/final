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
  <title>科室列表</title>
  <link rel="stylesheet" href="../css/pintuer.css">
  <link rel="stylesheet" href="../css/admin.css">
  <script src="../js/jquery-3.7.1.min.js"></script>
  <script src="/js/pintuer.js"></script>
  <script>
    function toggleSubMenu(index) {//index=1
      //获取按钮对象
      var $button = $('button[onclick="toggleSubMenu(' + index + ')"');
      //切换+ -  三元运算符
      $button.html(($button.html() === '+')? '-' : '+');
      //获取index对应的子菜单
      var $subMenu = $('#subMenu' + index);
      //修改子菜单的display 样式
      $subMenu.css('display', ($subMenu.css('display') === 'none')? 'table-row' : 'none');
      //发送AJax请求
      $.ajax({
        type:"GET",
        url:"/second",
        data:{"deptPid":$button.attr("deptPid")},
        dataType:"Json",
        success:function (res){
          $("#subMenu"+index+"tbody").empty()
          $.each(res , function(i, v) {
            var trObj = $("<tr></tr>");
            trObj.append($("<td>" + v.department_name + "</td>"));
            trObj.append($("<td>" + v.department_path + "</td>"));
            trObj.append($("<td>" + v.department_description + "</td>"));

            trObj.append('$<td><a class="button border-main" href="/toEdit?deptId='+v.department_id+'"> <span class="icon-edit"/>修改</a></td>');
            trObj.appendTo($("#subMenu" + index + "tbody"));
          });
        }
      })
    }
  </script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
  <div class="padding border-bottom">
    <button type="button" class="button border-yellow" onclick="window.location.href='/first'"><span class="icon-plus-square-o"></span> 添加科室</button>
  </div>
  <table class="table table-hover text-center">
    <tr>
      <td>展开/折叠</td>
      <td>编号</td>
      <td>科室名称</td>
      <td>上级科室</td>
      <td>科室级别</td>
      <td>科室路径</td>
      <td>科室详情</td>
      <td>操作</td>
    </tr>
    <c:forEach items ="${pageInfo.list}" var="dept" varStatus="vs">

      <tr>
        <td><button deptPid="${dept.department_id}" onclick="toggleSubMenu(${vs.index+1})">+</button></td>
        <td>${vs.index+1}</td>
        <td>${dept.department_name}</td>
        <td>${dept.department_pid}</td>
        <td>${dept.department_level}</td>
        <td>${dept.department_path}</td>
        <td>${dept.department_description}</td>
        <td><div class="button-group">
          <a class="button border-main" href="/toEdit">
            <span class="icon-edit"></span> 修改</a>
          <a class="button border-red" href="javascript:void(0)" onclick="return del(1,2)">
            <span class="icon-trash-o"></span> 删除</a> </div></td>
      </tr>
      <tr style="display: none" id="subMenu${vs.index+1}">
        <td colspan="5">
          <table class="table table-hover text-center">
            <thead>
            <tr>
              <td>科室名称</td>
              <td>科室路径</td>
              <td>科室详情</td>
              <td>操作</td>
            </tr>
            </thead>
            <tbody id="subMenu${vs.index+1}tbody">

            </tbody>

          </table>
        </td>
      </tr>
    </c:forEach>
    <tr>
      <td colspan="8">
        <div class="pagelist">

          <c:if test="${pageInfo.isFirstPage}">
            <a href="JavaScript:alert('已经是第一页')">上一页</a>
          </c:if>
          <c:if test="${not pageInfo.isFirstPage}">
            <a href="/list?pageNum=${pageInfo.prePage}">上一页</a>
          </c:if>
          <c:forEach items="${pageInfo.navigatepageNums}" var="i">
            <a href = "/list?pageNum=${i}">${i}</a>
          </c:forEach>
          <c:if test="${pageInfo.isLastPage}">
            <a href="JavaScript:alert('已经是最后一页')">下一页</a>
          </c:if>
          <c:if test="${not pageInfo.isLastPage}">
            <a href="/list?pageNum=${pageInfo.nextPage}">下一页</a>
          </c:if>

          <a href="/list?pageNum=${pageInfo.pages}">尾页</a>
        </div>
      </td>
    </tr>
  </table>
</div>
<script type="text/javascript">
  function del(id,mid){
    if(confirm("您确定要删除吗?")){

    }
  }
</script>

<%--
<div class="panel admin-panel margin-top">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="">
      <div class="form-group">
        <div class="label">
          <label>上级分类：</label>
        </div>
        <div class="field">
          <select name="pid" class="input w50">
            <option value="">请选择分类</option>
            <option value="">产品分类</option>
            <option value="">产品分类</option>
            <option value="">产品分类</option>
            <option value="">产品分类</option>
          </select>
          <div class="tips">不选择上级分类默认为一级分类</div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>分类标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="title" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>批量添加：</label>
        </div>
        <div class="field">
          <textarea type="text" class="input w50" name="tits" style="height:150px;" placeholder="多个分类标题请转行"></textarea>
          <div class="tips">多个分类标题请转行</div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>关键字标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="s_title" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>分类关键字：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="s_keywords" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>关键字描述：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="s_desc"/>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>排序：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="sort" value="0"  data-validate="number:排序必须为数字" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
--%>
</body>
</html>