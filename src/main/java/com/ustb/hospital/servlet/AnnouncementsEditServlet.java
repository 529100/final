package com.ustb.hospital.servlet;

import com.mysql.cj.exceptions.DataReadException;
import com.ustb.hospital.service.AnnouncementsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/annc/anncedit")
public class AnnouncementsEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String creationTime = simpleDateFormat.format(date);

        //System.out.println(creationTime);
        // 获取请求中的id，category和price参数
        int announcementId = Integer.parseInt(req.getParameter("announcementId"));
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        AnnouncementsServiceImpl service = new AnnouncementsServiceImpl();
        try {
            //调用service的update方法更新数据
            service.update(announcementId,title,content, creationTime,"1");

            //修改成功 重定向到列表页
            resp.sendRedirect("/annclist");
        }
        catch (Exception e) {
            //throw new RuntimeException(e);
            // 出现异常时打印异常信息并重定向到编辑页
            e.printStackTrace();;
            //修改失败
            resp.sendRedirect("/annc/annctoedit?announcementId="+announcementId);
        }
        finally {
        }
    }
}
