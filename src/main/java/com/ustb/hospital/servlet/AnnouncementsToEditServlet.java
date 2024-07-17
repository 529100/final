package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Announcements;
import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.service.AnnouncementsServiceImpl;
import com.ustb.hospital.service.DepartmentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/annc/annctoedit")
public class AnnouncementsToEditServlet extends HttpServlet {
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

        String id = req.getParameter("announcementId");
        AnnouncementsServiceImpl service = new AnnouncementsServiceImpl();
        Announcements announcement = service.queryById(Integer.parseInt(id));

        //转发，重定向
        req.setAttribute("announcement",announcement);
        req.getRequestDispatcher("/annc/anncedit.jsp").forward(req,resp);
    }
}
