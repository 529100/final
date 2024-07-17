package com.ustb.hospital.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.Schedule;
import com.ustb.hospital.service.ScheduleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patient/arrange")
public class ArrangeSelectByMulti extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String pageNum = req.getParameter("pageNum");
        String pageSize = req.getParameter("pageSize");
        int  deptId = Integer.parseInt(req.getParameter("deptId"));
        String date = req.getParameter("date");


        int i;
        if(pageNum != null && !pageNum.isEmpty()) {
            //类型转换
            i = Integer.parseInt(pageNum);
        }
        else{
            i = 1;
        }
        ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();
        PageInfo<Schedule> schedulePageInfo = scheduleService.queryByMulti(i,5,deptId,date);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(schedulePageInfo);
        resp.getWriter().write(json);
    }
}