package com.ustb.hospital.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.Patients;
import com.ustb.hospital.mapper.PatientsMapper;

import com.ustb.hospital.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PatientsServiceImpl {
    public Patients queryByIdNumber(String idCardNumber){
        SqlSession sqlSession =  MybatisUtils.getSqlSession();
        PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);
        Patients patients = mapper.selectByIdNumber(idCardNumber);
        return  patients;
    }
    public Patients queryByPhone(String phone){
        SqlSession sqlSession =  MybatisUtils.getSqlSession();
        PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);
        Patients patients = mapper.selectByPhone(phone);
        return patients;
    }

    public Patients queryByName(String name){
        SqlSession sqlSession =  MybatisUtils.getSqlSession();
        PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);
        Patients patients = mapper.selectByName(name);
        return patients;
    }
    public void addPatient(Patients patients){
        SqlSession sqlSession =  MybatisUtils.getSqlSession();
        PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);
        int id = mapper.getMaxId()+1;
        patients.setPatientId(id);
        patients.setBalance(0);
        mapper.insertPatient(patients);
    }
    public void updateMoney(int money,String phone){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);
        mapper.updateBalance(money,phone);
    }
    public void updateMon(int money,int id){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);
        mapper.updateBalA(money,id);
    }
    public PageInfo<Patients> queryByPage(int pageNum, int pageSize){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);
        PageHelper.startPage(pageNum,pageSize);
        List<Patients> list = mapper.selectAll();
        PageInfo<Patients> pageInfo= new PageInfo<>(list);
        System.out.println(pageInfo);
        return pageInfo;
    }

    public Patients queryById(int id){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);
        Patients patients = mapper.selectById(id);
        return patients;
    }
    public void update(int id, String idCardNumber, String password, String name, String phone, String email, int balance){
        try {
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);
            mapper.updateById(id,idCardNumber,password,name,phone,email,balance);


        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public void delete(int id){
        try {
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);

            mapper.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void updatePwd(int id,String password){
        try {
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            PatientsMapper mapper = sqlSession.getMapper(PatientsMapper.class);
            mapper.updatePwd(id, password);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
