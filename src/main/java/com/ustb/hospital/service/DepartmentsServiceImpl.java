package com.ustb.hospital.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ustb.hospital.entity.Departments;
import com.ustb.hospital.mapper.DepartmentsMapper;
import com.ustb.hospital.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class DepartmentsServiceImpl {

    SqlSession sqlSession = MybatisUtils.getSqlSession();
    DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);
    //业务

    public void update(int id,String name,String desc){

        try {
            //SqlSession sqlSession = MybatisUtils.getSqlSession();
            //DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);
            Departments department = mapper.selectByName(name);
            mapper.updateById(id,name,desc);
//            if(department == null){
//                mapper.updateById(id,name,desc);
//            }
//            else{
//                throw new Exception("科室名称已存在");
//            }

        }
        catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //释放
        }

    }

    public Departments queryById(int id){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();//
//        DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);
        Departments department = mapper.selectById(id);
        return department;
    }

    public List<Departments> querySecondByPid(int deptPid){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);
        List<Departments> departments = mapper.selectSecondDeptByPid(deptPid);
        return departments;
    }

    public void save(int deptPid,String deptName,String deptDesc) throws Exception {
        //验证科室名是否重复
        try {
//            SqlSession sqlSession = MybatisUtils.getSqlSession();
//            DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);
            Departments department = mapper.selectByName(deptName);
            if(department == null){
                Departments deptNew = new Departments();
                deptNew.setDepartment_id(mapper.getMaxId()+1);
                deptNew.setDepartment_name(deptName);
                deptNew.setDepartment_description(deptDesc);

                //判断是否为一级科室
                if(deptPid == -1){
                    //为一级科室
                    //deptNew.setDepartment_pid(0);
                    deptNew.setDepartment_level(1);
                    deptNew.setDepartment_path("|"+deptNew.getDepartment_id()+"|");
                }
                else{
                    //二级科室
                    Departments department1 = mapper.selectById(deptPid);
                    if(department1 == null){
                        //父类不存在 异常(被删了?)
                        throw new Exception("父类不存在");

                    }
                    else{
                        deptNew.setDepartment_pid(deptPid);
                        deptNew.setDepartment_level(department1.getDepartment_level()+1);
                        deptNew.setDepartment_path("|"+deptPid+"|"+"|"+deptNew.getDepartment_id()+"|");
                    }
                }
                System.out.println(deptNew);
                mapper.insert(deptNew);
            }
            else{
                //重复，无法保存
                throw new Exception("科室名称已存在");
            }
        } catch (Exception e) {
            throw new SQLException(e);
        } finally {

        }

    }

    public void addNewDept(String department_name,String department_description){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);
        List<Departments> list = mapper.insertDept(department_name,department_description);

    }

    public List<Departments> queryFirstdept(int level){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);
        List<Departments> list = mapper.selectFirstDept(level);
        return list;
    }

    public List<Departments> querySecondept(int level){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);
        List<Departments> list = mapper.selectFirstDept(level);
        return list;
    }

    public PageInfo queryAll(int pageNum,int pageSize){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);
        PageHelper.startPage(pageNum,pageSize);
        List<Departments> list = mapper.selectFirstDept(1);
        PageInfo pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
        return pageInfo;

    }
    public List<Departments> queryAllSecond(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DepartmentsMapper mapper = sqlSession.getMapper(DepartmentsMapper.class);
        List<Departments> list = mapper.selectDeptByLevel(2);
        return list;
    }
}
