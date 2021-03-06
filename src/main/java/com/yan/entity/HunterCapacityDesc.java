package com.yan.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 闫继龙 on 2017/4/25.
 * 求职者能力描述表
 */
@Entity
@Table(name = "hunter_capacityDesc")
public class HunterCapacityDesc implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String capacityDesc;


    public HunterCapacityDesc() {
    }

    public HunterCapacityDesc(String capacityDesc) {
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
        return "HunterCapacityDesc{" +
                "id=" + id +
                ", capacityDesc='" + capacityDesc + '\'' +
                '}';
    }
}
