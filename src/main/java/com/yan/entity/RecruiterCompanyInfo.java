package com.yan.entity;

import javax.persistence.*;

/**
 * Created by 闫继龙 on 2017/4/26.
 * 职位所属公司信息表
 */
@Entity
@Table(name = "recruiter_companyInfo")
public class RecruiterCompanyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String companyName;     //公司名称
    private String companyImage;    //公司头像
    private String companyEamil;    //
    private String companyAddress;
    private String declarations;    //招聘宣言

    public RecruiterCompanyInfo() {
    }

    public RecruiterCompanyInfo(String companyName, String companyImage, String companyEamil, String companyAddress, String declarations) {
        this.companyName = companyName;
        this.companyImage = companyImage;
        this.companyEamil = companyEamil;
        this.companyAddress = companyAddress;
        this.declarations = declarations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyImage() {
        return companyImage;
    }

    public void setCompanyImage(String companyImage) {
        this.companyImage = companyImage;
    }

    public String getCompanyEamil() {
        return companyEamil;
    }

    public void setCompanyEamil(String companyEamil) {
        this.companyEamil = companyEamil;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getDeclarations() {
        return declarations;
    }

    public void setDeclarations(String declarations) {
        this.declarations = declarations;
    }

    @Override
    public String toString() {
        return "RecruiterCompanyInfo{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyImage='" + companyImage + '\'' +
                ", companyEamil='" + companyEamil + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", declarations='" + declarations + '\'' +
                '}';
    }
}
