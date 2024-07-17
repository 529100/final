package com.ustb.hospital.service;

import com.ustb.hospital.entity.ProfessionalTitles;
import com.ustb.hospital.mapper.ProfessionalTitlesMapper;
import com.ustb.hospital.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ProfessionalTitlesServiceImpl {

    public List<ProfessionalTitles> queryAll(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProfessionalTitlesMapper mapper = sqlSession.getMapper(ProfessionalTitlesMapper.class);
        //业务
        List<ProfessionalTitles> professionalTitles = mapper.selectAll();
        return professionalTitles;
    }

}
