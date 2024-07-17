package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Patients;
import com.ustb.hospital.service.PatientsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/patient/changepass")
public class PatientsPasswordChangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //避免乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取参数
        HttpSession session = req.getSession();
        Patients patients = (Patients) session.getAttribute("patients");
        int id =patients.getPatientId();
        String pwd = req.getParameter("password");
        String pwd2=req.getParameter("password2");
        if(pwd.equals(pwd2)){
            PatientsServiceImpl service = new PatientsServiceImpl();
            service.updatePwd(id,pwd);
            PrintWriter pw=resp.getWriter();
            pw.write("<script language='javascript'>alert('修改成功！')</script>");
           // resp.sendRedirect("/patient/changepass.jsp");
        }
        else {

            PrintWriter pw=resp.getWriter();
            pw.write("<script language='javascript'>alert('两次密码输入不一致，请重新输入！')</script>");
         //   resp.sendRedirect("/patient/changepass.jsp");
        }
    }
}


