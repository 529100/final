package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Doctors;
import com.ustb.hospital.service.AdminsServiceImpl;
import com.ustb.hospital.service.DoctorsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig
@WebServlet("/Editdoc")
public class DoctorsEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String doctorId = req.getParameter("doctorId");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        String username = req.getParameter("username");
        Part part = req.getPart("avatar");
        String avatar = username + ".jpg";
        part.write("E:/java examples/img/" + avatar);

        DoctorsServiceImpl service = new DoctorsServiceImpl();
        try {
            service.update(Integer.parseInt(doctorId),avatar,phone,email);
            System.out.println(email);
            //修改成功
            resp.sendRedirect("/list");
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
            System.out.println();
            System.out.println("失败");
            //修改失败
            resp.sendRedirect("/toEditdoc?doctorId="+doctorId);
        }
        finally {
        }
    }
}
