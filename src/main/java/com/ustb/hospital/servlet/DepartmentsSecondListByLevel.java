package com.ustb.hospital.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.service.DepartmentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/second/list")
public class DepartmentsSecondListByLevel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        
        DepartmentsServiceImpl as = new DepartmentsServiceImpl();
        List<Departments> secondlist = as.querySecondept(2);
        System.out.println(secondlist);
        ObjectMapper objectMapper1 = new ObjectMapper();
        String jsonStr1 = objectMapper1.writeValueAsString(secondlist);
        resp.getWriter().write(jsonStr1);
    }
}
