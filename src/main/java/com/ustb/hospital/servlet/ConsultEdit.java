package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Consultation;
import com.ustb.hospital.service.AppointmentServiceImpl;
import com.ustb.hospital.service.ConsultationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doc/ConsEdit")
public class ConsultEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        int doctorId = Integer.parseInt(req.getParameter("doctor_id"));
        int patientId = Integer.parseInt(req.getParameter("patient_id"));
        int is_hospital_registered = Integer.parseInt(req.getParameter("is_hospital_registered"));
        int is_hospitalized = Integer.parseInt(req.getParameter("is_hospitalized"));
        String medical_advice_case = req.getParameter("medical_advice_case");
        ConsultationServiceImpl consultationService = new ConsultationServiceImpl();
        AppointmentServiceImpl appointmentService = new AppointmentServiceImpl();
        Consultation consultation = new Consultation();
        //consultation.setConsultation_id(id);
        consultation.setDoctor_id(doctorId);
        consultation.setPatient_id(patientId);
        consultation.setIs_hospital_registered(is_hospital_registered);
        consultation.setIs_hospitalized(is_hospitalized);
        consultation.setMedical_advice_case(medical_advice_case);
        System.out.println("就诊信息");
        System.out.println(consultation);
        try
        {
            consultationService.save(consultation);
            appointmentService.updatebyId(id);
            resp.sendRedirect("/doc/docarrange.jsp");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("失败");
            resp.sendRedirect("/doc/toConsult?id="+id);
        }
    }
}
