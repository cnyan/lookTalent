package com.yan.entity;

import javax.persistence.*;

/**
 * Created by 闫继龙 on 2017/4/25.
 * 求职者教育背景表
 */
@Entity
@Table(name = "hunter_education")
public class HunterEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String startTime;

    private String endTime;

    private String schoolName;

    //专业
    private String professional;

    //学历
    private String qualifications;


    public HunterEducation() {
    }

    public HunterEducation(String startTime, String endTime, String schoolName, String professional, String qualifications) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.schoolName = schoolName;
        this.professional = professional;
        this.qualifications = qualifications;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    @Override
    public String toString() {
        return "HunterEducation{" +
                "id=" + id +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", professional='" + professional + '\'' +
                ", qualifications='" + qualifications + '\'' +
                '}';
    }
}
