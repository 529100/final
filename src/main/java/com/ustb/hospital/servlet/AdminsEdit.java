package com.ustb.hospital.servlet;

import com.ustb.hospital.service.AdminsServiceImpl;
import com.ustb.hospital.service.DepartmentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig
@WebServlet("/Editadmin")
public class AdminsEdit  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String adminId = req.getParameter("adminId");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        String username = req.getParameter("username");
        Part part = req.getPart("avatar");
        String avatar = username + ".jpg";
        part.write("E:/java examples/img/" + avatar);

        AdminsServiceImpl service = new AdminsServiceImpl();
        try {
            service.update(Integer.parseInt(adminId),avatar,phone,email);
            //修改成功
            resp.sendRedirect("/list");
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
            System.out.println();
            System.out.println("失败");
            //修改失败
            resp.sendRedirect("/toEditadmin?adminId="+adminId);
        }
        finally {
        }
    }
}
