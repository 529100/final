package com.ustb.hospital.servlet;

import com.ustb.hospital.service.DepartmentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/save")
public class DepartmentsSaveServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理乱码
        req.setCharacterEncoding("utf-8");
        String deptPid = req.getParameter("pid");
        String deptName = req.getParameter("department_name");
        String deptDesc = req.getParameter("department_description");
        DepartmentsServiceImpl service = new DepartmentsServiceImpl();
        try {
            service.save(Integer.parseInt(deptPid),deptName,deptDesc);
            //没有异常,保存成功
            //页面导航
            //重定向
            resp.sendRedirect("/list");


        } catch (Exception e) {
            //保存失败
            e.printStackTrace();;
            resp.sendRedirect("/first");
            //throw new RuntimeException(e);


        }


    }
}
