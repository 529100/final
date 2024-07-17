package com.ustb.hospital.servlet;

import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.Patients;
import com.ustb.hospital.service.AppointmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/patient/arrangelist")
public class AppointSelectByptId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNum = req.getParameter("pageNum");
        String pageSize = req.getParameter("pageSize");

        HttpSession session = req.getSession();
        Patients patients = (Patients) session.getAttribute("patients");
        int patientId = patients.getPatientId();
        System.out.println(patientId);
        int i;
        if(pageNum != null && !pageNum.isEmpty()) {
            //类型转换
            i = Integer.parseInt(pageNum);
        }
        else{
            i = 1;
        }

        AppointmentServiceImpl as = new AppointmentServiceImpl();
        PageInfo pageInfo = as.queryByPt_id(1,5,patientId);
        req.setAttribute("pageInfo", pageInfo);
        System.out.println(pageInfo);
        if(pageInfo != null && !pageInfo.getList().isEmpty()){
            System.out.println("找到了");
        }

        req.getRequestDispatcher("/patient/arrangelist.jsp").forward(req, resp);
    }

}
