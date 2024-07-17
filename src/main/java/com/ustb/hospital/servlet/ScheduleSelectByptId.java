package com.ustb.hospital.servlet;

import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.Doctors;
import com.ustb.hospital.entity.Patients;
import com.ustb.hospital.service.AppointmentServiceImpl;
import com.ustb.hospital.service.ScheduleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/doc/schedulelist")
public class ScheduleSelectByptId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNum = req.getParameter("pageNum");
        String pageSize = req.getParameter("pageSize");

        HttpSession session = req.getSession();
        Doctors doctors = (Doctors) session.getAttribute("doctors");
        int doctorId = doctors.getDoctorId();
        System.out.println(doctorId);
        int i;
        if(pageNum != null && !pageNum.isEmpty()) {
            //类型转换
            i = Integer.parseInt(pageNum);
        }
        else{
            i = 1;
        }


        ScheduleServiceImpl as = new ScheduleServiceImpl();
        PageInfo pageInfo = as.queryByDocId(i,5,doctorId);
        req.setAttribute("pageInfo", pageInfo);
        System.out.println(pageInfo);
        if(pageInfo != null && !pageInfo.getList().isEmpty()){
            System.out.println("找到了");
        }

        req.getRequestDispatcher("/doc/schedulelist.jsp").forward(req, resp);
    }

}
