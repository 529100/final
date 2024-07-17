package com.ustb.hospital.servlet;

import com.ustb.hospital.service.DepartmentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Edit")
public class DepartmentsEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String id = req.getParameter("deptId");
        String name = req.getParameter("deptName");
        String desc = req.getParameter("deptDesc");

        DepartmentsServiceImpl service = new DepartmentsServiceImpl();
        try {
            service.update(Integer.parseInt(id),name,desc);
            //修改成功
            resp.sendRedirect("/list");
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
            System.out.println();
            System.out.println("失败");
            //修改失败
            resp.sendRedirect("/toEdit?deptId="+id);
        }
        finally {
        }
    }
}
