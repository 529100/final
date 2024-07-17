package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Admins;
import com.ustb.hospital.service.AdminsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/infoadmin")
public class AdminsInfo extends HttpServlet {
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

        String adminId = req.getParameter("adminId");
        AdminsServiceImpl service = new AdminsServiceImpl();
        Admins admin = service.queryById(Integer.parseInt(adminId));

        //转发，重定向
        req.setAttribute("admin",admin);
        req.getRequestDispatcher("/admin/info.jsp").forward(req,resp);
    }
}