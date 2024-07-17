package com.ustb.hospital.servlet;

import com.ustb.hospital.service.AnnouncementsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/annc/delete")
public class AnnouncementsDeleteById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String announcementId = req.getParameter("announcementId");
        //System.out.println(announcementId);
        AnnouncementsServiceImpl announcementService = new AnnouncementsServiceImpl();
        announcementService.deleteAnnouncement(Integer.parseInt(announcementId));
        resp.sendRedirect("/annclist");

    }
}
