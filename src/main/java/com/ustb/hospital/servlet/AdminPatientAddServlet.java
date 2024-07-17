package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Doctors;
import com.ustb.hospital.entity.Patients;
import com.ustb.hospital.service.PatientsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/admin/addpatient")
@MultipartConfig
public class AdminPatientAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //避免乱码，新建患者对象
        req.setCharacterEncoding("utf-8");
        Patients patients = new Patients();
        //获取页面数据
        String name = req.getParameter("name");
        Part part = req.getPart("avatar");
        String sfn = part.getSubmittedFileName();
        String houzhui = sfn.substring(sfn.lastIndexOf("."));
        sfn =name+houzhui;
        String phone = req.getParameter("phone");
        String idNumber = req.getParameter("idNumber");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        //初始化患者信息
        patients.setName(name);
        patients.setAvatar(sfn);
        patients.setPhone(phone);
        patients.setEmail(email);
        patients.setPassword(password);
        patients.setIdCardNumber(idNumber);
        //加入数据库
        PatientsServiceImpl service = new PatientsServiceImpl();
        if (service.queryByName(name)==null){
            try {
                part.write("E:\\java examples\\img\\"+sfn);
                service.addPatient(patients);
                resp.sendRedirect("/patient/list.jsp");

            }catch (Exception e){
                e.printStackTrace();
                req.getRequestDispatcher("/admin/addpatient.jsp").forward(req,resp);
            }
        }
        else {
            name=name+1;
            houzhui = sfn.substring(sfn.lastIndexOf("."));
            sfn=name+houzhui;
            patients.setName(name);
            patients.setAvatar(sfn);
            try {
                part.write("E:\\java examples\\img\\"+sfn);
                service.addPatient(patients);
                resp.sendRedirect("/patient/list.jsp");
            }catch (Exception e){
                e.printStackTrace();
                req.getRequestDispatcher("/admin/addpatient.jsp").forward(req,resp);
            }
        }

    }
}
