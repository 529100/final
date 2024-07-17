package com.ustb.hospital.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.Schedule;
import com.ustb.hospital.mapper.ScheduleMapper;
import com.ustb.hospital.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ScheduleServiceImpl {
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    ScheduleMapper scheduleMapper = sqlSession.getMapper(ScheduleMapper.class);
    public PageInfo<Schedule> queryByMulti(int pageNum, int pageSize,int dept_id, String date) {
        PageHelper.startPage(pageNum,pageSize);
       List<Schedule> list = scheduleMapper.selectByMulti(dept_id,date);
        System.out.println(new PageInfo<>(list));
        return new PageInfo<>(list);
    }
    public void save(int deptId,int docId,String date,String time,int isAvailable,int visitCount,String remarks) throws Exception {
        Schedule schedule = scheduleMapper.selectByDocIDDateTime(docId, date, time);
        if (schedule == null) {
            Schedule doctorSchedule = new Schedule();
            doctorSchedule.setSchedule_id(scheduleMapper.getMaxId() + 1);
            doctorSchedule.setDoctor_id(docId);
            doctorSchedule.setDepartment_id(deptId);
            doctorSchedule.setDate(date);
            doctorSchedule.setShift_time(time);
            doctorSchedule.setIs_available(isAvailable);
            doctorSchedule.setVisit_count(visitCount);
            doctorSchedule.setRemarks(remarks);
            scheduleMapper.insert(doctorSchedule);
        }

    }
    public  void delete(int id){
        try {
            Schedule doctorSchedule = scheduleMapper.selectById(id);
            if (doctorSchedule != null) {
                scheduleMapper.deleteById(id);
            } else {
                throw new Exception("排班不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
    public PageInfo<Schedule> queryByPage(int pageNum, int pageSize,String docName,int deptId){
        PageHelper.startPage(pageNum,pageSize);
        List<Schedule> list = scheduleMapper.selectAll(docName, deptId);
        PageInfo<Schedule> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    public Schedule queryById(int scheduleId) {

        return scheduleMapper.selectById(scheduleId);
    }

    public void update(int scheduleId, String date, String time, int isAvailable, int visitCount, String remarks) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            scheduleMapper.updateById(scheduleId, date, time, isAvailable, visitCount, remarks);
            sqlSession.commit();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    public PageInfo<Schedule> queryByDocId(int pageNum, int pageSize,int docId){
        PageHelper.startPage(pageNum,pageSize);
        List<Schedule> list = scheduleMapper.selectByDocId(docId);
        PageInfo<Schedule> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
