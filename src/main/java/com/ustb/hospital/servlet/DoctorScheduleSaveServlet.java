package com.ustb.hospital.servlet;

import com.ustb.hospital.service.ScheduleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/schedule/save")
public class DoctorScheduleSaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求乱码
        req.setCharacterEncoding("utf-8");
        //响应乱码
        resp.setContentType("text/html;charset=utf-8");
        int deptId = Integer.parseInt(req.getParameter("deptId"));
        int docId = Integer.parseInt(req.getParameter("docId"));
        String date = req.getParameter("date");
        String time = req.getParameter("time");
        int isAvailable = Integer.parseInt(req.getParameter("isAvailable"));
        int visitCount = Integer.parseInt(req.getParameter("visitCount"));
        String remarks = req.getParameter("remarks");
        ScheduleServiceImpl service = new ScheduleServiceImpl();
        try {
            service.save(deptId,docId,date,time,isAvailable,visitCount,remarks);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("添加成功");
        resp.sendRedirect("/schedule/list.html");
    }
}
