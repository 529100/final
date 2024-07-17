package com.ustb.hospital.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.Announcements;
import com.ustb.hospital.mapper.AnnouncementsMapper;
import com.ustb.hospital.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AnnouncementsServiceImpl {
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    AnnouncementsMapper mapper = sqlSession.getMapper(AnnouncementsMapper.class);

    public PageInfo queryAll(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Announcements> list = mapper.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        //System.out.println(pageInfo);
        return pageInfo;

    }

    public List<Announcements> query(){

        List<Announcements> list = mapper.selectAll();

        System.out.println(list.get(1));
        return list;
    }

    public Announcements queryById(int announcementId){
        Announcements announcement = mapper.selectById(announcementId);
        return announcement;
    }

    public void update(int announcementId,String title,String content,String creationTime,String creator){
        mapper.updateById(announcementId,title,content,creationTime,creator);
    }

    public void anncsave(String title,String content,String creationTime,String creator){
        Announcements announcement = new Announcements();
        announcement.setTitle(title);
        announcement.setContent(content);
        announcement.setCreationTime(creationTime);
        announcement.setCreator(creator);
        mapper.insert(announcement);

    }

    public  void deleteAnnouncement(int announcementId){
        mapper.deleteById(announcementId);
    }
}
