package com.ustb.hospital.servlet;

import com.ustb.hospital.service.ScheduleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/schedule/delete")
public class DoctorScheduleDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求乱码
        req.setCharacterEncoding("utf-8");
        //响应乱码
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("scheduleId");
        String pageNum = req.getParameter("pageNum");
        String docName = req.getParameter("docName");
        String deptId = req.getParameter("deptId");
        ScheduleServiceImpl service = new ScheduleServiceImpl();
        try {
            service.delete(Integer.parseInt(id));
//            req.getRequestDispatcher("/schedule/list.html").forward(req, resp);
            resp.sendRedirect("/schedule/list?pageNum="+pageNum+"&deptId="+deptId+"&docName="+docName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
