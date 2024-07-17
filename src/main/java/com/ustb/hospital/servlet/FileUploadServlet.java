package com.ustb.hospital.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@MultipartConfig
@WebServlet("/doc/add1")
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String docname = req.getParameter("docname");
        //获取文件
        Part part = req.getPart("docavatar");
        //获取提交的文件名
        String sfn = part.getSubmittedFileName();
        System.out.println("docname:"+docname);
        System.out.println("提交的文件名:"+sfn);
        String houzhui = sfn.substring(sfn.lastIndexOf("."));

        //重新起一个头像名称：不能重复--随机起名
        String newname = UUID.randomUUID().toString().replaceAll("-", "");
        sfn = newname + houzhui;
        //将图片名保存到数据库上
        //将这个图片保存到服务器器上（静态资源服务器）
        //配置一个静态资源服务器
        part.write("D:\\img\\"+sfn);
    }
}
