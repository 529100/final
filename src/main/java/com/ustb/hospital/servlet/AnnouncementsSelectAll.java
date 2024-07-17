package com.ustb.hospital.servlet;

import com.github.pagehelper.PageInfo;
import com.ustb.hospital.service.AnnouncementsServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/annclist")
public class AnnouncementsSelectAll extends HttpServlet {
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
        AnnouncementsServiceImpl as = new AnnouncementsServiceImpl();
        PageInfo pageInfo = as.queryAll(i,5);
        req.setAttribute("pageInfo", pageInfo);
        req.getRequestDispatcher("/annc/annclist.jsp").forward(req, resp);

    }
}
