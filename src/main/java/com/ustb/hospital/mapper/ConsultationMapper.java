package com.ustb.hospital.mapper;

import com.ustb.hospital.entity.Consultation;
import org.apache.ibatis.annotations.Param;

public interface ConsultationMapper {
    Consultation selectConsultationById(int id);
    void insertConsultation(@Param("patient_id") int patient_id, @Param("doctor_id") int doctor_id,@Param("is_hospital_registered") int is_hospital_registered, @Param("is_hospitalized") int is_hospitalized,@Param("medical_advice_case") String medical_advice_case);


}
