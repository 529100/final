package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Patients;
import com.ustb.hospital.service.AppointmentServiceImpl;
import com.ustb.hospital.service.PatientsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/patient/delete")
public class AppointDelete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doGet(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //请求乱码
        req.setCharacterEncoding("utf-8");
        //响应乱码
        resp.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        double money = Double.parseDouble(req.getParameter("money"));
        System.out.println(id);
        AppointmentServiceImpl appointmentService = new AppointmentServiceImpl();
        HttpSession session = req.getSession();
        Patients patients = (Patients) session.getAttribute("patients");
        int patientId = patients.getPatientId();
        PatientsServiceImpl patientsService = new PatientsServiceImpl();
        try
        {
            appointmentService.deletebyId(id);
            patientsService.updateMon((int) -money,patientId);
            resp.sendRedirect("/patient/arrangelist.jsp");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            resp.sendRedirect("/patient/arrangelist.jsp");
        }


    }
}
