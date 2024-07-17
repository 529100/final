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

@WebServlet("/patient/money")
public class PatientsMoneyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //避免乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取用户数据
        String count = req.getParameter("count");
        HttpSession session = req.getSession();
        Patients patients = (Patients) session.getAttribute("patients");
        //获取充值的金额


        int realcout = Integer.parseInt(count);
        //更新用余额
        int money = realcout+patients.getBalance();
        //同步到数据库
        PatientsServiceImpl service = new PatientsServiceImpl();
        service.updateMoney(money,patients.getPhone());
        PrintWriter pw=resp.getWriter();
        pw.write("<script language='javascript'>alert('充值成功！')</script>");
    }
}
