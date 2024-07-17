<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>修改排班</title>
    <link rel="stylesheet" href="/css/pintuer.css">
    <link rel="stylesheet" href="/css/admin.css">
    <script src="/js/jquery-3.7.1.min.js"></script>
    <script src="/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel margin-top">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="/schedule/edit">
            <input type="hidden" name="scheduleId" value="${doctorSchedule.schedule_id}">
            <input type="hidden" name="pageNum" value="${pageNum}">
            <input type="hidden" name="deptId" value="${deptId}">
            <div class="form-group">
                <div class="label">
                    <label>排班日期：</label>
                </div>
                <div class="field">
                    <input id="date" type="date" class="input w50" value="${doctorSchedule.date}" name="date"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>排班时间：</label>
                </div>
                <div class="field">
                    <input id="time" type="time" class="input w50" value="${doctorSchedule.shift_time}" name="time"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>能否排班：</label>
                </div>
                <div class="field">
                    <select name="isAvailable" class="input w50">
                        <option value="1">能</option>
                        <option value="0">不能</option>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>就诊数量：</label>
                </div>
                <div class="field">
                    <input type="number" class="input w50" name="visitCount" value="${doctorSchedule.visit_count}" required/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>备注：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="remarks" value="${doctorSchedule.remarks}" required/>
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
</body>
</html>
