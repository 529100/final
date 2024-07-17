package com.ustb.hospital.servlet;

import com.ustb.hospital.entity.Doctors;
import com.ustb.hospital.service.DoctorsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/doc/add")
@MultipartConfig
public class DoctorsAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //避免乱码，新建医生对象
        req.setCharacterEncoding("utf-8");
        Doctors doctors = new Doctors();
        //获取页面数据
        String departmentId = req.getParameter("deptId");
        int deptId = 6;
        if (departmentId!=null)
        {
            deptId = Integer.parseInt(departmentId);
        }

        String name=req.getParameter("name");
        Part part = req.getPart("docavatar");
        String sfn = part.getSubmittedFileName();
        String houzhui = sfn.substring(sfn.lastIndexOf("."));
        sfn =name+houzhui;
        String phone = req.getParameter("phone");
        String fee = req.getParameter("fee");
        String zhiwei = req.getParameter("zhiwei");
        int zhiweiId = Integer.parseInt(zhiwei);
        String email = req.getParameter("email");
        String introduce = req.getParameter("introduce");
        String password = req.getParameter("password");
        //设置医生对象的属性值
        doctors.setName(name);
        doctors.setAvatar(sfn);
        doctors.setPhone(phone);
        doctors.setRegistrationFee(fee);
        doctors.setDepartmentId(deptId);
        doctors.setProfessionalTitleId(zhiweiId);
        doctors.setEmail(email);
        doctors.setIntroduction(introduce);
        doctors.setPassword(password);
        //上传到数据库，图片也要上传到对应的文件夹
        //使用impl
        DoctorsServiceImpl service =new DoctorsServiceImpl();
        if (service.queryByName(name)==null){
            try {
                part.write("C:\\Users\\jason\\Desktop\\小学期\\final\\src\\main\\webapp\\images"+sfn);
                service.insertDoctor(doctors);
                resp.sendRedirect("/login.jsp");

            }catch (Exception e){
                e.printStackTrace();
                resp.sendRedirect("/doc/second");
            }
        }
        else {
            name=name+1;
            houzhui = sfn.substring(sfn.lastIndexOf("."));
            sfn=name+houzhui;
            doctors.setName(name);
            doctors.setAvatar(sfn);
            try {
                part.write("C:\\Users\\jason\\Desktop\\小学期\\final\\src\\main\\webapp\\images"+sfn);
                service.insertDoctor(doctors);
                resp.sendRedirect("/login.jsp");
            }catch (Exception e){
                e.printStackTrace();
                resp.sendRedirect("/doc/second");
            }
        }
    }
}

