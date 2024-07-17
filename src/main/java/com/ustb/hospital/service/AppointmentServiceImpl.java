package com.ustb.hospital.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.Appointment;
import com.ustb.hospital.mapper.AppointmentMapper;
import com.ustb.hospital.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AppointmentServiceImpl {
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    AppointmentMapper appointmentMapper = sqlSession.getMapper(AppointmentMapper.class);
    public PageInfo queryByPt_id(int pageNum, int pageSize, int patient_id) {
        PageHelper.startPage(pageNum,pageSize);
        List<Appointment> list = appointmentMapper.getAppointmentByPtId(patient_id);
        PageInfo pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
        return pageInfo;
    }
    public PageInfo queryByDoc_id(int pageNum,int pageSize,int doctor_id) {
        PageHelper.startPage(pageNum,pageSize);
        List<Appointment> list = appointmentMapper.getAppointmentByDocId(doctor_id);
        PageInfo pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
        return pageInfo;
    }
    public void save(int patient_id,int doctor_id,String appointment_time) throws Exception {
//        Appointment appointment = new Appointment();
//        appointment.setPatient_id(patient_id);
//        appointment.setDoctor_id(doctor_id);
//        appointment.setAppointment_date(appointment_time);
        appointmentMapper.insertAppointment(patient_id,doctor_id,appointment_time);
    }
    public Appointment queryById(int id) {
        return appointmentMapper.selectById(id);
    }
    public void updatebyId(int id) {
        appointmentMapper.update(id);
    }
    public void deletebyId(int id) {
        appointmentMapper.delete(id);
    }

}
