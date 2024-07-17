package com.ustb.hospital.servlet;

import com.ustb.hospital.service.PatientsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patient/edit")
public class PatientsEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取页面数据
        String id=req.getParameter("id");
        String idCardNumber = req.getParameter("idCardNumber");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String balance = req.getParameter("balance");
        //调用impl服务
        PatientsServiceImpl service = new PatientsServiceImpl();
        try {
            service.update(Integer.parseInt(id),idCardNumber,password,name,phone,email,Integer.parseInt(balance));
            resp.sendRedirect("/patient/list.jsp");
        }catch (NumberFormatException e){
            e.printStackTrace();
            resp.sendRedirect("/patient/toEdit?id="+id);
        }
    }
}
