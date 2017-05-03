package com.yan.entity;

import org.hibernate.annotations.Check;

import javax.persistence.*;

/**
 * Created by 闫继龙 on 2017/5/1.
 * 我的消息类
 * 对应关系：
 *  1.求职者发送简历sendResume对应（求职者我的申请，招聘者收到简历消息）
 *  2.招聘者发送邀请sendInvite对应（求职者我的offer，招聘者我的邀请消息）
 */
@Entity
@Table(name = "my_message")
public class MyMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int hunterID;       //求职者ID
    private int recruiterID;    //招聘者ID
    private int resumeID;       //简历ID
    private int positionID;     //职位ID

    private String cover;          //消息封面图片(公司封面||求职者头像)
    private String name;            //公司名称||求职者名字
    private String positionName;    //职位名称

    private String messageType;     //消息类型（sendResume||sendInvite）
    private String messageDate;     //消息日期

    public MyMessage() {
    }

    public MyMessage(int hunterID, int recruiterID, int resumeID, int positionID, String cover, String name, String positionName, String messageType, String messageDate) {
        this.hunterID = hunterID;
        this.recruiterID = recruiterID;
        this.resumeID = resumeID;
        this.positionID = positionID;
        this.cover = cover;
        this.name = name;
        this.positionName = positionName;
        this.messageType = messageType;
        this.messageDate = messageDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHunterID() {
        return hunterID;
    }

    public void setHunterID(int hunterID) {
        this.hunterID = hunterID;
    }

    public int getRecruiterID() {
        return recruiterID;
    }

    public void setRecruiterID(int recruiterID) {
        this.recruiterID = recruiterID;
    }

    public int getResumeID() {
        return resumeID;
    }

    public void setResumeID(int resumeID) {
        this.resumeID = resumeID;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    @Override
    public String toString() {
        return "MyMessage{" +
                "id=" + id +
                ", hunterID=" + hunterID +
                ", recruiterID=" + recruiterID +
                ", resumeID=" + resumeID +
                ", positionID=" + positionID +
                ", cover='" + cover + '\'' +
                ", name='" + name + '\'' +
                ", positionName='" + positionName + '\'' +
                ", messageType='" + messageType + '\'' +
                ", messageDate='" + messageDate + '\'' +
                '}';
    }
}
