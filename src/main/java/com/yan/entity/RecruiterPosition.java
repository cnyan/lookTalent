package com.yan.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by 闫继龙 on 2017/4/26.
 * 招聘者职位表
 */
@Entity
@Table(name = "recruiter_position")
public class RecruiterPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //招聘者ID
    private int recruiterAccountID;

    /**
     * 职位信息表
     */
    @OneToOne
    private RecruiterInformation recruiterInformation;
    /**
     * 公司信息表
     */
    @OneToOne
    private RecruiterCompanyInfo recruiterCompanyInfo;
    /**
     * 职位描述
     */
    @OneToMany
    private List<RecruiterPositionDesc> recruiterPositionDescs;


    public RecruiterPosition() {
    }

    public RecruiterPosition(int recruiterAccountID, RecruiterInformation recruiterInformation, RecruiterCompanyInfo recruiterCompanyInfo, List<RecruiterPositionDesc> recruiterPositionDescs) {
        this.recruiterAccountID = recruiterAccountID;
        this.recruiterInformation = recruiterInformation;
        this.recruiterCompanyInfo = recruiterCompanyInfo;
        this.recruiterPositionDescs = recruiterPositionDescs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecruiterAccountID() {
        return recruiterAccountID;
    }

    public void setRecruiterAccountID(int recruiterAccountID) {
        this.recruiterAccountID = recruiterAccountID;
    }

    public RecruiterInformation getRecruiterInformation() {
        return recruiterInformation;
    }

    public void setRecruiterInformation(RecruiterInformation recruiterInformation) {
        this.recruiterInformation = recruiterInformation;
    }

    public RecruiterCompanyInfo getRecruiterCompanyInfo() {
        return recruiterCompanyInfo;
    }

    public void setRecruiterCompanyInfo(RecruiterCompanyInfo recruiterCompanyInfo) {
        this.recruiterCompanyInfo = recruiterCompanyInfo;
    }

    public List<RecruiterPositionDesc> getRecruiterPositionDescs() {
        return recruiterPositionDescs;
    }

    public void setRecruiterPositionDescs(List<RecruiterPositionDesc> recruiterPositionDescs) {
        this.recruiterPositionDescs = recruiterPositionDescs;
    }

    @Override
    public String toString() {
        return "RecruiterPosition{" +
                "id=" + id +
                ", recruiterAccountID=" + recruiterAccountID +
                ", recruiterInformation=" + recruiterInformation +
                ", recruiterCompanyInfo=" + recruiterCompanyInfo +
                ", recruiterPositionDescs=" + recruiterPositionDescs +
                '}';
    }
}
