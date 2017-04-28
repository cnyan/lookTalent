package com.yan.entity;

import javax.persistence.*;

/**
 * Created by 闫继龙 on 2017/4/26.
 * 招聘者账号表
 */

@Entity
@Table(name = "recruiter_account")
public class RecruiterAccount {
    /*
  主键生成策略
   */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //账号
    private String recruiterAccount;
    private String password;
    //头像路径
    private String headImage;
    private String name;
    // 网易云信tokenKey
    private String tokenKey;

    public RecruiterAccount() { }

    public RecruiterAccount(String recruiterAccount, String password, String headImage, String name, String tokenKey) {
        this.recruiterAccount = recruiterAccount;
        this.password = password;
        this.headImage = headImage;
        this.name = name;
        this.tokenKey = tokenKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecruiterAccount() {
        return recruiterAccount;
    }

    public void setRecruiterAccount(String recruiterAccount) {
        this.recruiterAccount = recruiterAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    @Override
    public String toString() {
        return "RecruiterAccount{" +
                "id=" + id +
                ", recruiterAccount='" + recruiterAccount + '\'' +
                ", password='" + password + '\'' +
                ", headImage='" + headImage + '\'' +
                ", name='" + name + '\'' +
                ", tokenKey='" + tokenKey + '\'' +
                '}';
    }
}
