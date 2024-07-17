package com.ustb.hospital.service;

import com.ustb.hospital.entity.Consultation;
import com.ustb.hospital.mapper.ConsultationMapper;
import com.ustb.hospital.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class ConsultationServiceImpl {
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    ConsultationMapper consMapper = sqlSession.getMapper(ConsultationMapper.class);
    public Consultation queryConsultationbyId(int id) {
        return consMapper.selectConsultationById(id);
    }
    public void save(Consultation consultation) {

        consMapper.insertConsultation(consultation.getPatient_id(),consultation.getDoctor_id(),consultation.getIs_hospital_registered(),consultation.getIs_hospitalized(),consultation.getMedical_advice_case());
    }
}
