package com.yan.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by 闫继龙 on 2017/4/25.
 * 求职者简历
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "hunter_resume")
public class HunterResume implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //求职者ID
    private int hunterAccountID;

    /**
     *    个人信息
     */
    @OneToOne
    private HunterInformation hunterInformation;

    /**
     *  教育背景
     */
    @OneToMany
    private List<HunterEducation> hunterEducation;

    //能力描述，一对多的能力描述表
    @OneToMany
    private List<HunterCapacityDesc> hunterCapacityDescList;

    public HunterResume() {
    }

    public HunterResume(int hunterAccountID, HunterInformation hunterInformation, List<HunterEducation> hunterEducation, List<HunterCapacityDesc> hunterCapacityDescList) {
        this.hunterAccountID = hunterAccountID;
        this.hunterInformation = hunterInformation;
        this.hunterEducation = hunterEducation;
        this.hunterCapacityDescList = hunterCapacityDescList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHunterAccountID() {
        return hunterAccountID;
    }

    public void setHunterAccountID(int hunterAccountID) {
        this.hunterAccountID = hunterAccountID;
    }

    public HunterInformation getHunterInformation() {
        return hunterInformation;
    }

    public void setHunterInformation(HunterInformation hunterInformation) {
        this.hunterInformation = hunterInformation;
    }

    public List<HunterEducation> getHunterEducation() {
        return hunterEducation;
    }

    public void setHunterEducation(List<HunterEducation> hunterEducation) {
        this.hunterEducation = hunterEducation;
    }

    public List<HunterCapacityDesc> getHunterCapacityDescList() {
        return hunterCapacityDescList;
    }

    public void setHunterCapacityDescList(List<HunterCapacityDesc> hunterCapacityDescList) {
        this.hunterCapacityDescList = hunterCapacityDescList;
    }

    @Override
    public String toString() {
        return "HunterResume{" +
                "id=" + id +
                ", hunterAccountID=" + hunterAccountID +
                ", hunterInformation=" + hunterInformation +
                ", hunterEducation=" + hunterEducation +
                ", hunterCapacityDescList=" + hunterCapacityDescList +
                '}';
    }
}
