package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Appointment;
import com.ustb.hospital.entity.Consultation;
import com.ustb.hospital.service.AppointmentServiceImpl;
import com.ustb.hospital.service.ConsultationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doc/toConsult")
public class CousulttoEdit extends HttpServlet {
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
        String id = req.getParameter("id");
        System.out.println(id);
        AppointmentServiceImpl appointmentService = new AppointmentServiceImpl();
        Appointment appointment = appointmentService.queryById(Integer.parseInt(id));
        req.setAttribute("appointment", appointment);
        System.out.println(appointment);
        System.out.println("哈哈哈");
        req.getRequestDispatcher("/doc/ConsEdit.jsp").forward(req, resp);


    }

}
