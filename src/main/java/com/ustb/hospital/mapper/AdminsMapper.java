package com.ustb.hospital.mapper;

import com.ustb.hospital.entity.Admins;
import org.apache.ibatis.annotations.Param;


public interface AdminsMapper {
    //根据用户名查询列表
    Admins selectByUsername(String username);
    Admins selectByPhone(String phone);
    void updateById(@Param("adminId") int adminId, @Param("avatar") String avatar,@Param("phone") String phone,@Param("email") String email);
    Admins selectById(int adminId);

    void updatePwd(@Param("id") int id, @Param("password") String password);
}
