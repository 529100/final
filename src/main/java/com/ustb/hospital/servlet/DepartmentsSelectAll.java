package com.ustb.hospital.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.service.DepartmentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class DepartmentsSelectAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数 --String
        String pageNum = req.getParameter("pageNum");
        String pageSize = req.getParameter("pageSize");
        int i;
        if(pageNum != null && !pageNum.isEmpty()) {
            //类型转换
            i = Integer.parseInt(pageNum);
        }
        else{
            i = 1;
        }
        //int j = Integer.parseInt(pageSize);
        DepartmentsServiceImpl as = new DepartmentsServiceImpl();
        PageInfo pageInfo = as.queryAll(i,5);
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonStr = objectMapper.writeValueAsString(pageInfo);
//        resp.getWriter().write(jsonStr);
        req.setAttribute("pageInfo", pageInfo);
        req.getRequestDispatcher("dept/list.jsp").forward(req, resp);
    }
}
