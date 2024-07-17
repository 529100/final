package com.ustb.hospital.mapper;

import com.ustb.hospital.entity.Patients;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientsMapper {
    Patients selectByIdNumber(String idCardNumber);
    Patients selectByPhone(String phone);
    Patients selectByName(String name);
    void insertPatient(Patients patients);

    int getMaxId();
    void updateBalance(@Param("money") int money, @Param("phone") String phone);
    void updateBalA(@Param("money") int money, @Param("id") int id);

    List<Patients> selectAll();

    Patients selectById(int id);

    int updateById(@Param("patientId") int patientId,@Param("idCardNumber") String idCardNumber,@Param("password") String password,@Param("name") String name,@Param("phone") String phone,@Param("email") String email,@Param("balance") int balance);

    int deleteById(int id);


    void updatePwd(@Param("id") int id, @Param("password") String password);
}
