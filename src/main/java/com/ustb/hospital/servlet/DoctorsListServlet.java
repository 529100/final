package com.ustb.hospital.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.Doctors;
import com.ustb.hospital.service.DepartmentsServiceImpl;
import com.ustb.hospital.service.DoctorsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doc/list")
public class DoctorsListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求乱码
        req.setCharacterEncoding("utf-8");
        //响应乱码
        resp.setContentType("text/html;charset=utf-8");

        String pageNum = req.getParameter("pageNum");
        //String pageSize = req.getParameter("pageSize");
        int i = 1;
        if(pageNum != null && !pageNum.equals("")) {
            //类型转换
            i = Integer.parseInt(pageNum);
        }

        String jobNumber = req.getParameter("jobNumber");
        String docName = req.getParameter("docName");
        String deptId = req.getParameter("deptId");

        DoctorsServiceImpl service = new DoctorsServiceImpl();
        /*if(deptId!=null && !deptId.equals("")) {
            int i1 = Integer.parseInt(deptId);
        }*/
        PageInfo<Doctors> pageInfo = service.queryByPage(i, 5, jobNumber, docName, Integer.parseInt(deptId));

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(pageInfo);
        System.out.println("hhh");
        System.out.println(jsonStr);
        resp.getWriter().write(jsonStr);
    }
}
