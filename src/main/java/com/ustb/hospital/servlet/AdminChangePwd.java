package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Admins;
import com.ustb.hospital.entity.Doctors;
import com.ustb.hospital.service.AdminsServiceImpl;
import com.ustb.hospital.service.DoctorsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin/changepass")
public class AdminChangePwd extends HttpServlet {
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
        Admins admins = (Admins) session.getAttribute("admins");
        int id =admins.getAdminId();
        String pwd = req.getParameter("password");
        String pwd2=req.getParameter("password2");
        if(pwd.equals(pwd2)){
            AdminsServiceImpl service=new AdminsServiceImpl();
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
