package com.yan.entity;

import javax.persistence.*;

/**
 * Created by 闫继龙 on 2017/4/26.
 * 职位描述表
 */
@Entity
@Table(name = "recruiter_positionDesc")
public class RecruiterPositionDesc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String capacityDesc;

    public RecruiterPositionDesc() {
    }

    public RecruiterPositionDesc(String capacityDesc) {
        this.capacityDesc = capacityDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCapacityDesc() {
        return capacityDesc;
    }

    public void setCapacityDesc(String capacityDesc) {
        this.capacityDesc = capacityDesc;
    }

    @Override
    public String toString() {
        return "RecruiterPositionDesc{" +
                "id=" + id +
                ", capacityDesc='" + capacityDesc + '\'' +
                '}';
    }
}
