package com.ustb.hospital.mapper;

import com.ustb.hospital.entity.Announcements;
import com.ustb.hospital.entity.Departments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnouncementsMapper {
    List<Announcements> selectAll();
    public Announcements selectById(int announcementId);
    int updateById(@Param("announcementId") int announcementId, @Param("title") String title, @Param("content") String content, @Param("creationTime") String creationTime, @Param("creator") String creator);
    int deleteById(int announcementId);
    int insert(Announcements announcement);

}
