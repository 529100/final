package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Admins;
import com.ustb.hospital.entity.Doctors;
import com.ustb.hospital.entity.Patients;
import com.ustb.hospital.service.AdminsServiceImpl;
import com.ustb.hospital.service.DoctorsServiceImpl;
import com.ustb.hospital.service.PatientsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class AdminsLoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String type = req.getParameter("shenfen");
        String code = req.getParameter("code");

        System.out.println(type);


        switch (type){
            case "patient":{
                PatientsServiceImpl patientsService = new PatientsServiceImpl();
                Patients patients = patientsService.queryByPhone(phone);
                if(patients == null){
                    req.getRequestDispatcher("/patient/add.jsp").forward(req,resp);
                }
                else {
                    if(!patients.getPassword().equals(password)){
                        req.getRequestDispatcher("/login.jsp").forward(req,resp);
                    }else {
                        HttpSession session = req.getSession();
                        session.setAttribute("patients", patients);
                        req.setAttribute("patients",patients);
                        req.getRequestDispatcher("/patient/index.jsp").forward(req,resp);
                        System.out.println("患者成功登录");
                    }
                }
                break;
            }

            case "doctor":{
                DoctorsServiceImpl doctorsService = new DoctorsServiceImpl();
                Doctors doctors = doctorsService.queryByPhone(phone);
                if(doctors == null){
                    resp.sendRedirect("/doc/second");
                }
                else {
                    if(!doctors.getPassword().equals(password)){
                        req.getRequestDispatcher("/login.jsp").forward(req,resp);
                    }else {
                        HttpSession session = req.getSession();
                        session.setAttribute("doctors",doctors);
                        req.setAttribute("doctors",doctors);
                        req.getRequestDispatcher("/doc/index.jsp").forward(req,resp);
                        System.out.println("医生成功登录");
                    }
                }
                break;
            }

            case "admin":{
                AdminsServiceImpl adminsService =  new AdminsServiceImpl();
                Admins admins = adminsService.queryByPhone(phone);
                if(admins == null){
                    req.getRequestDispatcher("/login.jsp").forward(req,resp);
                }
                else {
                    if(!admins.getPassword().equals(password)){
                        req.getRequestDispatcher("/login.jsp").forward(req,resp);
                    }else {
                        HttpSession session = req.getSession();
                        session.setAttribute("admins",admins);
                        req.setAttribute("admins",admins);
                        req.setAttribute("admins",admins);
                        req.getRequestDispatcher("/admin/index.jsp").forward(req,resp);
                        System.out.println("管理员成功进入");
                    }
                }
                break;
            }
            default:{
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
                break;
            }
        }
    }
}
