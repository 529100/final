package com.ustb.hospital.servlet;

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
@WebServlet("/doc/save")

public class DoctorsSaveServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理乱码
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        System.out.println("name:" + name);
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        Part part = req.getPart("docavatar");
        String introduction = req.getParameter("introduction");
        String registrationFee = req.getParameter("registrationFee");
        String entryDate = req.getParameter("entryDate");
        //String sfn = part.getSubmittedFileName();

        //System.out.println("文件名:" + sfn);

        //String houzhui = sfn.substring(sfn.lastIndexOf("."));

        String sfn = name + ".jpg";
        System.out.println("sfn:" + sfn);
        part.write("E:/java examples/img/" + sfn);

        int departmentId = Integer.parseInt(req.getParameter("deptId"));
        String phone = req.getParameter("phone");
        String professionalTitleId = req.getParameter("pftId");
        DoctorsServiceImpl service = new DoctorsServiceImpl();
        try {
            service.save(password,name,name+".jpg",phone,email,introduction,registrationFee,entryDate,departmentId, Integer.parseInt(professionalTitleId));
            //没有异常,保存成功
            //页面导航
            //重定向
            //resp.sendRedirect("/Doct/list");
            //resp.sendRedirect("doctlist.jsp");

        } catch (Exception e) {
            //保存失败
            e.printStackTrace();;
            //resp.sendRedirect("/Doct/save");
            //throw new RuntimeException(e);


        }

    }
}
