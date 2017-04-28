package com.yan.entity;

import javax.persistence.*;

/**
 * Created by 闫继龙 on 2017/4/26.
 *招聘者发布职位信息表
 */
@Entity
@Table(name = "recruiter_information")
public class RecruiterInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //职位名称
    private String positionName;
    //职位薪资
    private String salary;
    //工作地点
    private String city;
    //工作经验年限
    private String experienceTime;
    //学历
    private String qualifications;
    //工作性质(全职、兼职）
    private String jobNature;
//
//    @OneToOne
//    private RecruiterPosition recruiterPosition;


    public RecruiterInformation() {
    }

    public RecruiterInformation(String positionName, String salary, String city, String experienceTime, String qualifications, String jobNature) {
        this.positionName = positionName;
        this.salary = salary;
        this.city = city;
        this.experienceTime = experienceTime;
        this.qualifications = qualifications;
        this.jobNature = jobNature;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getExperienceTime() {
        return experienceTime;
    }

    public void setExperienceTime(String experienceTime) {
        this.experienceTime = experienceTime;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getJobNature() {
        return jobNature;
    }

    public void setJobNature(String jobNature) {
        this.jobNature = jobNature;
    }

    @Override
    public String toString() {
        return "RecruiterInformation{" +
                "id=" + id +
                ", positionName='" + positionName + '\'' +
                ", salary='" + salary + '\'' +
                ", city='" + city + '\'' +
                ", experienceTime='" + experienceTime + '\'' +
                ", qualifications='" + qualifications + '\'' +
                ", jobNature='" + jobNature + '\'' +
                '}';
    }
}
