package com.ustb.hospital.entity;

public class Departments {
    private int department_id;
    private String department_name;
    private Integer department_pid;
    private int department_level;
    private String department_path;
    private String department_description;

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public Integer getDepartment_pid() {
        return department_pid;
    }

    public void setDepartment_pid(Integer department_pid) {
        this.department_pid = department_pid;
    }

    public int getDepartment_level() {
        return department_level;
    }

    public void setDepartment_level(int department_level) {
        this.department_level = department_level;
    }

    public String getDepartment_path() {
        return department_path;
    }

    public void setDepartment_path(String department_path) {
        this.department_path = department_path;
    }

    public String getDepartment_description() {
        return department_description;
    }

    public void setDepartment_description(String department_description) {
        this.department_description = department_description;
    }

    @Override
    public String toString() {
        return "Departments{" +
                "department_id=" + department_id +
                ", department_name='" + department_name + '\'' +
                ", department_pid=" + department_pid +
                ", department_level=" + department_level +
                ", department_path='" + department_path + '\'' +
                ", department_description='" + department_description + '\'' +
                '}';
    }
}
