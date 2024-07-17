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

@WebServlet("/second")
public class DepartmentsSecondListServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        this.doGet(req, resp);
//    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/json;charset=utf-8");
        String deptPid = req.getParameter("deptPid");
        DepartmentsServiceImpl as = new DepartmentsServiceImpl();

        List<Departments> list = as.querySecondByPid(Integer.parseInt(deptPid));
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(list);
        resp.getWriter().write(jsonStr);

        /*
        String department_name = req.getParameter("department_name");
        String department_description = req.getParameter("department_description");
        System.out.println(department_name);
        System.out.println(department_description);
        if(department_name != null && !department_name.isEmpty() &&
                department_description != null && !department_description.isEmpty()){
            System.out.println("添加成功");
            resp.sendRedirect("/list.jsp");
            as.addNewDept(department_name,department_description);
            System.out.println(list);

        }
        else{
            System.out.println("添加失败");
        }
        */
    }
}
