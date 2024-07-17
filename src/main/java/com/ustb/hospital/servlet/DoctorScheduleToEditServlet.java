package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Schedule;
import com.ustb.hospital.service.ScheduleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/schedule/toEdit")
public class DoctorScheduleToEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //响应乱码
        resp.setContentType("text/html;charset=utf-8");

        int scheduleId = Integer.parseInt(req.getParameter("scheduleId"));

        ScheduleServiceImpl service = new ScheduleServiceImpl();
        Schedule doctorSchedule =service.queryById(scheduleId);
        req.setAttribute("doctorSchedule",doctorSchedule);
        req.getRequestDispatcher("/schedule/edit.jsp").forward(req,resp);

    }
}




