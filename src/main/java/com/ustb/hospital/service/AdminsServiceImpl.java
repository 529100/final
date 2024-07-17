package com.ustb.hospital.service;

import com.ustb.hospital.entity.Admins;
import com.ustb.hospital.mapper.AdminsMapper;
import com.ustb.hospital.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;


public class AdminsServiceImpl {
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    AdminsMapper mapper = sqlSession.getMapper(AdminsMapper.class);

    public Admins queryByUsername(String username){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        AdminsMapper mapper = sqlSession.getMapper(AdminsMapper.class);
        Admins admins = mapper.selectByUsername(username);
       return admins;
    }

    public Admins queryByPhone(String phone){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        AdminsMapper mapper = sqlSession.getMapper(AdminsMapper.class);
        Admins admins = mapper.selectByPhone(phone);
        return admins;
    }

    public void update(int adminId,String avatar,String phone,String email){
        mapper.updateById(adminId,avatar,phone,email);

    }

    public Admins queryById(int adminId){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        AdminsMapper mapper = sqlSession.getMapper(AdminsMapper.class);
       Admins admins= mapper.selectById(adminId);
       return admins;
    }

    public void updatePwd(int id,String password){
        try {
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            AdminsMapper mapper = sqlSession.getMapper(AdminsMapper.class);
            mapper.updatePwd(id, password);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
