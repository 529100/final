package com.ustb.hospital.mapper;

import com.ustb.hospital.entity.Departments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentsMapper {

    public int updateById(@Param("id") int id, @Param("name") String name, @Param("desc") String desc);

    public int getMaxId();

    //科室名称不重复 select * from departments where department_name = #{department_name};
    public Departments selectByName(String name);

    public Departments selectById(int id);

    //insert into departments() value
    public int insert(Departments department);

    List<Departments> selectAll();
    List<Departments> selectFirstDept(int level);
    List<Departments> insertDept(String department_name, String department_description);

    List<Departments> selectSecondDeptByPid(int deptPid);
    List<Departments> selectDeptByLevel(int level);
}

