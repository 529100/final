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
<script src="../js/jquery-3.7.1.min.js"></script>
<script src="../js/pintuer.js"></script>
</head>
<body>
<!--<form method="post" action="" id="listform">-->
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="add.html"> 添加内容</a> </li>
        <!--<li>搜索：</li>
        <li>首页
          <select name="s_ishome" class="input" onchange="changesearch()" style="width:60px; line-height:17px; display:inline-block">
            <option value="">选择</option>
            <option value="1">是</option>
            <option value="0">否</option>
          </select>
          &nbsp;&nbsp;
          推荐
          <select name="s_isvouch" class="input" onchange="changesearch()"  style="width:60px; line-height:17px;display:inline-block">
            <option value="">选择</option>
            <option value="1">是</option>
            <option value="0">否</option>
          </select>
          &nbsp;&nbsp;
          置顶
          <select name="s_istop" class="input" onchange="changesearch()"  style="width:60px; line-height:17px;display:inline-block">
            <option value="">选择</option>
            <option value="1">是</option>
            <option value="0">否</option>
          </select>
        </li>-->
        <if condition="$iscid eq 1">
          <li>
<!--            <select name="deptId" class="input" style="width:200px; line-height:17px;" onchange="changesearch()">-->
            <select name="deptId" class="input" style="width:200px; line-height:17px;" >
              <option value="-1">请选择科室</option>
              <!--<option value="">产品分类</option>
              <option value="">产品分类</option>
              <option value="">产品分类</option>-->
            </select>
          </li>
        </if>
        <li>
          <input type="text" placeholder="请输入搜索姓名" name="docName" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <input type="text" placeholder="请输入搜索工号" name="jobNumber" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="javascript:void(0)" class="button border-main icon-search" onclick="changeSearch()" > 搜索</a></li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <thead>
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">ID</th>
<!--        <th width="10%">排序</th>-->
        <th>工号</th>
        <th>姓名</th>
        <th>头像</th>
        <th>手机号</th>
        <th>邮箱</th>
        <th>介绍</th>
        <th>挂号费</th>
        <th>入职日期</th>
        <th>科室名称</th>
        <th>职称</th>
        <th >操作</th>
<!--        <th width="10%">更新时间</th>-->
<!--        <th width="310">操作</th>-->
      </tr>
      </thead>
      <tbody id="docBody">
      </tbody>

      <!--<tr>
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
      </tr>-->
      <tr>
        <td colspan="8">
          <div class="pagelist">
            <a href="javascript:void(0)" id="pre" onclick="prePage()">上一页</a>
            <!--<span class="current">1</span>
            <a href="">2</a>
            <a href="">3</a>-->
            <a href="javascript:void(0)" id="next" onclick="nextPage()">下一页</a>
            <a href="javascript:void(0)" id="last" onclick="lastPage()">尾页</a>
          </div>
        </td>
      </tr>
    </table>
  </div>
<!--</form>-->
<script type="text/javascript">

//
function  initDeptList(){
  $.ajax({
    type: "GET",
    url: "/second/all",
    //data:{"pageNum":pageNum,"deptId":deptId,"docName":docName,"jobNumber":jobNumber},
    dataType: "json",
    success: function (res) {//list<Dept>
      //console.log("res",res)
      //$("#subMenu" + index + " tbody").empty()
      //$("#docBody").empty();
      $.each(res, function (i, v) {
        var optionObj = $("<option value='" + v.department_id + "'>" + v.department_name + "</option>");

        // optionObj.append();

        optionObj.appendTo($("select[name='deptId']"));
      })
    }
  })
}
//发送ajax 请求 doc/list
//页面加载完成之后调用的函数
function  initDocList(pageNum,docName,jobNumber,deptId){
  $.ajax({
    type:"GET",
    url:"/doc/list",
    // data:{"pageNum":pageNum},
    data:{"pageNum":pageNum,"deptId":deptId,"docName":docName,"jobNumber":jobNumber},
    dataType:"json",
    success:function (res) {
      //console.log("res",res)
      //$("#subMenu" + index + " tbody").empty()
      $("#docBody").empty();
      $.each(res.list,function (i,v){
        var trObj = $("<tr></tr>");
        /*<td>
          <div className="button-group"><a className="button border-main" href="add.html"><span
                  className="icon-edit"></span> 修改</a> <a className="button border-red" href="javascript:void(0)"
                                                          onClick="return del(1,1,1)"><span
                  className="icon-trash-o"></span> 删除</a></div>
        </td>*/
        trObj.append($("<td>"+(i+1)+"</td>"));
        trObj.append($("<td>"+v.jobNumber+"</td>"));
        trObj.append($("<td>"+v.name+"</td>"));
        trObj.append($('<td><img width="70" height="70" src="/img/'+v.avatar+'"></img></td>'));
        trObj.append($("<td>"+v.phone+"</td>"));
        trObj.append($("<td>"+v.email+"</td>"));
        trObj.append($("<td width='200'>"+v.introduction+"</td>"));
        trObj.append($("<td>"+v.registrationFee+"</td>"));
        trObj.append($("<td>"+v.entryDate+"</td>"));
        trObj.append($("<td>"+v.departments.department_name+"</td>"));
        trObj.append($("<td>"+v.professionalTitles.titleName+"</td>"));

        // trObj.append($('<td><a class="button border-main" href="/toEdit?deptId='+v.department_id+'"><span class="icon-edit"></span>修改</a></td>'));
        trObj.append($('<td><a class="button border-main" href="/toEdit?deptId='+v.department_id+'"><span class="icon-edit"></span>修改</a><a class="button border-red" href="javascript:void(0)" onclick="del('+v.department_id+')"><span class="icon-trash-o"></span>删除</a></td>'));

        trObj.appendTo($("#docBody"))
      })

      //将.pagelist下的span删除
      $(".pagelist span").remove()
      //页码遍历
      for (var i = 0; i < res.pages; i++) {
        //创建span
        var $span = $("<span onclick='changePage($(this).html())'>"+(i+1)+"</span>")

        if ((i+1) == res.pageNum) {
          $span.attr("class","current")
        }

        $("#next").before($span)
      }
    }
  })
}

$(function (){
  initDocList(1,"","",-1);
  initDeptList();
})

function changePage(p){
  //alert(p)
  var $docName = $("input[name=docName]").val();
  var $jobNumber = $("input[name=jobNumber]").val();
  var $deptId = $("select[name='deptId'] option:selected").val();

  // console.log($docName,$jobNumber,$deptId)
  initDocList(p,$docName,$jobNumber,$deptId)
  // initDocList(p)
}

function prePage(){
  //获取当前页码
  var currentPageNumber = $("span[class='current']").text()
  var $docName = $("input[name=docName]").val();
  var $jobNumber = $("input[name=jobNumber]").val();
  var $deptId = $("select[name='deptId'] option:selected").val();

  // initDocList(1,$docName,$jobNumber,$deptId)

  $.ajax({
    type:"GET",
    url:"/doc/list",
    data:{"pageNum":Number(currentPageNumber),"deptId":$deptId},
    dataType:"json",
    success:function (res) {
      //console.log("res",res)
      if (res.hasPreviousPage) {
        initDocList(Number(currentPageNumber)-1,$docName,$jobNumber,$deptId)
      } else{
        alert("已经是第一页了")
      }
    }
  })
}

function nextPage(){
  //获取当前页码
  var currentPageNumber = $("span[class='current']").text()
  var $docName = $("input[name=docName]").val();
  var $jobNumber = $("input[name=jobNumber]").val();
  var $deptId = $("select[name='deptId'] option:selected").val();

  // console.log($docName,$jobNumber,$deptId)
  // initDocList(1,$docName,$jobNumber,$deptId)

  $.ajax({
    type:"GET",
    url:"/doc/list.jsp",
    data:{"pageNum":Number(currentPageNumber),"deptId":$deptId},
    dataType:"json",
    success:function (res) {
      //console.log("res",res)
      if (res.hasNextPage) {
        initDocList(Number(currentPageNumber)+1,$docName,$jobNumber,$deptId)
      } else{
        alert("已经是最后一页了")
      }
    }
  })
}

function lastPage(){
  //获取当前页码
  var currentPageNumber = $("span[class='current']").text()
  var $docName = $("input[name=docName]").val();
  var $jobNumber = $("input[name=jobNumber]").val();
  var $deptId = $("select[name='deptId'] option:selected").val();

  // console.log($docName,$jobNumber,$deptId)
  // initDocList(1,$docName,$jobNumber,$deptId)

  $.ajax({
    type:"GET",
    url:"/doc/list.jsp",
    data:{"pageNum":Number(currentPageNumber),"deptId":$deptId},
    dataType:"json",
    success:function (res) {
      //console.log("res",res)
      if (!res.isLastPage) {
        initDocList(res.pages,$docName,$jobNumber,$deptId)
      } else{
        alert("已经是最后一页了")
      }
    }
  })
}

//搜索
function changeSearch(){
  // alert("search")
  //获取用户输入的条件
  var $docName = $("input[name=docName]").val();
  var $jobNumber = $("input[name=jobNumber]").val();
  var $deptId = $("select[name='deptId'] option:selected").val();

  // console.log($docName,$jobNumber,$deptId)
  initDocList(1,$docName,$jobNumber,$deptId)

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