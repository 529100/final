package com.ustb.hospital.mapper;

import com.ustb.hospital.entity.Appointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppointmentMapper {
    List<Appointment> getAppointmentByPtId(Integer id);
    List<Appointment> getAppointmentByDocId(int id);
    Appointment selectById(int id);
    void update(int id);
    void delete(int id);
//    int insertAppointment(Appointment appointment);
    int insertAppointment(@Param("patient_id") int patient_id, @Param("doctor_id") int doctor_id,@Param("appointment_date") String appointment_date);
    List<Appointment> selectByMulti(@Param("date") String date, @Param("deptId") int deptId);
}
