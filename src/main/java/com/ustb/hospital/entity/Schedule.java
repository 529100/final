package com.ustb.hospital.entity;

public class Schedule {
    private int schedule_id;
    private int doctor_id;
    private String date;
    private String shift_time;
    private int department_id;
    private int is_available;
    private int visit_count;
    private String remarks;
    private Doctors doctors;
    private Departments departments;
    private ProfessionalTitles professionalTitles;

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public String getShift_time() {
        return shift_time;
    }

    public void setShift_time(String shift_time) {
        this.shift_time = shift_time;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getIs_available() {
        return is_available;
    }

    public void setIs_available(int is_available) {
        this.is_available = is_available;
    }

    public int getVisit_count() {
        return visit_count;
    }

    public void setVisit_count(int visit_count) {
        this.visit_count = visit_count;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Doctors getDoctors() {
        return doctors;
    }

    public void setDoctors(Doctors doctors) {
        this.doctors = doctors;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public ProfessionalTitles getProfessionalTitles() {
        return professionalTitles;
    }

    public void setProfessionalTitles(ProfessionalTitles professionalTitles) {
        this.professionalTitles = professionalTitles;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "schedule_id=" + schedule_id +
                ", doctor_id=" + doctor_id +
                ", date='" + date + '\'' +
                ", shift_time='" + shift_time + '\'' +
                ", department_id=" + department_id +
                ", is_available=" + is_available +
                ", visit_count=" + visit_count +
                ", remarks='" + remarks + '\'' +
                ", doctors=" + doctors +
                ", departments=" + departments +
                ", professionalTitles=" + professionalTitles +
                '}';
    }
}
