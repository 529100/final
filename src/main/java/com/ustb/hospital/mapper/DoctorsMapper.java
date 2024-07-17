package com.ustb.hospital.mapper;

import com.ustb.hospital.entity.Doctors;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DoctorsMapper {
    public List<Doctors> selectAll(@Param("jobNumber") String jobNumber, @Param("name") String name, @Param("deptId") int deptId);
    Doctors selectByName(@Param("name") String name);
    Doctors selectByPhone(String phone);
    int getMaxId();
    List<Doctors> selectByDeptId(int deptId);
    Doctors selectById(int doctorId);
    List<Doctors> selectAllDoc();
    Doctors selectByJobNumber(String jobNumber);
    int addDoctor(Doctors doctors);
    void updateById(@Param("doctorId") int doctorId, @Param("avatar") String avatar,@Param("phone") String phone,@Param("email") String email);
    void updatePwd(@Param("id") int id, @Param("password") String password);
}
