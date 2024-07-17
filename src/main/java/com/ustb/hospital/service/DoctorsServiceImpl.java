package com.ustb.hospital.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.Doctors;
import com.ustb.hospital.mapper.DoctorsMapper;
import com.ustb.hospital.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DoctorsServiceImpl {
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);
    public PageInfo<Doctors> queryByPage(int pageNum, int pageSize,String jobNumber,String name,int deptId){

        PageHelper.startPage(pageNum,pageSize);
        List<Doctors> list = mapper.selectAll(jobNumber, name, deptId);
        PageInfo<Doctors> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    public Doctors queryByName(String docname){
//        SqlSession sqlSession =  MybatisUtils.getSqlSession();
//        DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);
        Doctors doctors = mapper.selectByName(docname);
        return doctors;
    }

    public Doctors queryById(int doctorId){
//        SqlSession sqlSession =  MybatisUtils.getSqlSession();
//        DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);
        Doctors doctors = mapper.selectById(doctorId);
        return doctors;
    }

    public Doctors queryByPhone(String phone){
//        SqlSession sqlSession =  MybatisUtils.getSqlSession();
//        DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);
        Doctors doctors = mapper.selectByPhone(phone);
        return  doctors;
    }

    public void insertDoctor(Doctors doctors){
//        SqlSession sqlSession =  MybatisUtils.getSqlSession();
//        DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);
        int id=mapper.getMaxId()+1;
        doctors.setDoctorId(id);
        doctors.setJobNumber("100"+id);
        int i = mapper.addDoctor(doctors);
        System.out.println(i);
    }
    public void save(String password,String docName,String avatar,String phone,String email,String introduction,String registrationFee,String entryDate,int deptId,int proTitlesId){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);
        int id = mapper.getMaxId();
        Doctors doctors = mapper.selectById(id);
        Doctors doctorsNew = new Doctors();
        doctorsNew.setDoctorId(id+1);
        doctorsNew.setJobNumber(Integer.toString(Integer.parseInt(doctors.getJobNumber())+1));
        doctorsNew.setPassword(password);
        doctorsNew.setName(docName);
        doctorsNew.setAvatar(avatar);
        doctorsNew.setPhone(phone);
        doctorsNew.setEmail(email);
        doctorsNew.setIntroduction(introduction);
        doctorsNew.setRegistrationFee(registrationFee);
        doctorsNew.setEntryDate(entryDate);
        doctorsNew.setDepartmentId(deptId);
        doctorsNew.setProfessionalTitleId(proTitlesId);

    }
    public Doctors queryByJobNumber(String jobNumber){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);
        Doctors doctors = mapper.selectByJobNumber(jobNumber);
        return doctors;

    }

    public List<Doctors> queryByDeptId(int deptId){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);
        List<Doctors> doctors = mapper.selectByDeptId(deptId);
        return doctors;
    }

    public List<Doctors> queryAll(){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);
        List<Doctors> doctors = mapper.selectAllDoc();
        return doctors;
    }

    public void update(int doctorId,String avatar,String phone,String email){
        mapper.updateById(doctorId,avatar,phone,email);

    }

    public void updatePwd(int id,String password){
        try {
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);
            mapper.updatePwd(id, password);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
