package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.entity.ProfessionalTitles;
import com.ustb.hospital.service.DepartmentsServiceImpl;
import com.ustb.hospital.service.ProfessionalTitlesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/doc/second")
public class DoctorsSecondListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //调用科室相关服务
        DepartmentsServiceImpl service = new DepartmentsServiceImpl();
        List<Departments> list = service.queryFirstdept(2);
        req.setAttribute("list",list);
        //调用职位相关服务
        ProfessionalTitlesServiceImpl service1 = new ProfessionalTitlesServiceImpl();
        List<ProfessionalTitles> list1 = service1.queryAll();
        req.setAttribute("list1",list1);
        req.getRequestDispatcher("/doc/add.jsp").forward(req,resp);
    }
}
