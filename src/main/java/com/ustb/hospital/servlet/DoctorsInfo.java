package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Admins;
import com.ustb.hospital.entity.Doctors;
import com.ustb.hospital.service.AdminsServiceImpl;
import com.ustb.hospital.service.DoctorsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/infodoc")
public class DoctorsInfo extends HttpServlet {
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
        HttpSession session = req.getSession();
        Doctors doctors =  (Doctors) session.getAttribute("doctors");

        DoctorsServiceImpl service = new DoctorsServiceImpl();
        Doctors doctor = service.queryById(doctors.getDoctorId());
        System.out.println("111111111111111111"+doctor);
        //转发，重定向
        req.setAttribute("doctor",doctor);
        req.getRequestDispatcher("/doc/info.jsp").forward(req,resp);
    }
}