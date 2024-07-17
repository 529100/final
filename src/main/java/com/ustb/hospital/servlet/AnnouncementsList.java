package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Announcements;
import com.ustb.hospital.service.AnnouncementsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/annclist2")
public class AnnouncementsList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数 --String

        AnnouncementsServiceImpl announcementsService = new AnnouncementsServiceImpl();
        List<Announcements> list =  announcementsService.query();

        System.out.println(list.get(0));
        req.setAttribute("list", list);
        req.getRequestDispatcher("home.jsp").forward(req, resp);

    }
}

