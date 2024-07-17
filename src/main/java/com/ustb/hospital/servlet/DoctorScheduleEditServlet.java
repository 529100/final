package com.ustb.hospital.servlet;

import com.ustb.hospital.service.ScheduleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/schedule/edit")
public class DoctorScheduleEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        int scheduleId = Integer.parseInt(req.getParameter("scheduleId"));
        String date = req.getParameter("date");
        String time = req.getParameter("time");
        int isAvailable = Integer.parseInt(req.getParameter("isAvailable"));
        int visitCount = Integer.parseInt(req.getParameter("visitCount"));
        String remarks = req.getParameter("remarks");

        ScheduleServiceImpl service = new ScheduleServiceImpl();
        try {
            service.update(scheduleId, date, time, isAvailable, visitCount, remarks);
            // 修改成功，重定向到列表页，并带上pageNum和deptId参数
            //resp.sendRedirect("/schedule/list?pageNum=" + pageNum + "&deptId=" + deptId);
            resp.sendRedirect("/schedule/list.html");
        } catch (Exception e) {
            e.printStackTrace();
            // 修改失败，重定向回编辑页，并带上scheduleId参数
            System.out.println("失败");
            System.out.println(scheduleId);
            resp.sendRedirect("/schedule/toEdit?scheduleId=" + scheduleId);
             //resp.sendRedirect("/schedule/toEdit?pageNum=" + pageNum + "&deptId=" + deptId);
        }
    }
}
