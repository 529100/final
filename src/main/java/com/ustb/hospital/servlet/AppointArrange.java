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

@WebServlet("/toarrange")
public class AppointArrange extends HttpServlet {
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
        int doctor_id = Integer.parseInt(req.getParameter("doctor_id"));
        String date = req.getParameter("date");
        double money = Double.parseDouble(req.getParameter("money"));
        //int patientId = Integer.parseInt(req.getParameter("patientId"));
        HttpSession session = req.getSession();
        Patients patients = (Patients) session.getAttribute("patients");
        int patientId = patients.getPatientId();
        AppointmentServiceImpl appointmentService = new AppointmentServiceImpl();
        PatientsServiceImpl patientsService = new PatientsServiceImpl();
        try
        {
            if(money>patients.getBalance())
            {
                resp.sendRedirect("/patient/money.jsp");
            }
            else
            {
                appointmentService.save(patientId,doctor_id,date);
                patientsService.updateMon((int) money,patients.getPatientId());
                resp.sendRedirect("/patient/arrange.jsp");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("失败");
            resp.sendRedirect("/patient/toarrange");
        }


    }
}
