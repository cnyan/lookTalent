package com.yan.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 闫继龙 on 2017/4/25.
 * 求职者个人信息表
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "hunter_information")
public class HunterInformation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //简历头像
    private String  resumeImage;
    //姓名
    private String name;
    //年龄
    private String age;
    //性别
    private String gender;
    //邮箱
    private String email;
    //求职意向(java\web\ios\.net)
    private String jobIntension;
    //工作性质(全职、兼职）
    private String jobNature ;
    //求职宣言
    private String declarations;



    public HunterInformation() {
    }

    public HunterInformation(String resumeImage, String name, String age, String gender, String email, String jobIntension, String jobNature, String declarations) {
        this.resumeImage = resumeImage;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.jobIntension = jobIntension;
        this.jobNature = jobNature;
        this.declarations = declarations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResumeImage() {
        return resumeImage;
    }

    public void setResumeImage(String resumeImage) {
        this.resumeImage = resumeImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobIntension() {
        return jobIntension;
    }

    public void setJobIntension(String jobIntension) {
        this.jobIntension = jobIntension;
    }

    public String getJobNature() {
        return jobNature;
    }

    public void setJobNature(String jobNature) {
        this.jobNature = jobNature;
    }

    public String getDeclarations() {
        return declarations;
    }

    public void setDeclarations(String declarations) {
        this.declarations = declarations;
    }

    @Override
    public String toString() {
        return "HunterInformation{" +
                "id=" + id +
                ", resumeImage='" + resumeImage + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", jobIntension='" + jobIntension + '\'' +
                ", jobNature='" + jobNature + '\'' +
                ", declarations='" + declarations + '\'' +
                '}';
    }
}
