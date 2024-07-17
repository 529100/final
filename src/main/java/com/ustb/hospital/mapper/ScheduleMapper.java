package com.ustb.hospital.mapper;

import com.ustb.hospital.entity.Schedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleMapper {
    List<Schedule> selectByMulti(@Param("deptId") int deptId, @Param("date") String date);
    public int updateById(@Param("scheduleId")int scheduleId,  @Param("date")String date,@Param("time")String time,
                          @Param("isAvailable")int isAvailable,@Param("visitCount")int visitCount,@Param("remarks")String remarks
    );
    public int getMaxId();
    public int insert(Schedule doctorSchedule);
    public  Schedule selectByDocIDDateTime(@Param("docId") int docId,@Param("date") String date,@Param("time") String time);
    public int deleteById(int id);
    public Schedule selectById(int id);
    List<Schedule> selectAll(@Param("docName") String docName, @Param("deptId") int deptId);
    List<Schedule> selectByDocId(@Param("docId") int docId);
}
