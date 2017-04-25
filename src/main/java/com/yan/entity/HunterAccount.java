package com.yan.entity;

import javax.persistence.*;

/**
 * Created by 闫继龙 on 2017/4/22.
 * 求职者账号表
 */

@Entity
@Table(name = "hunteraccount")
public class HunterAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //账号
    private String hunterAccount;
    private String password;
    //头像路径
    private String headImage;
    private String name;
    // 网易云信tokenKey
    private String tokenKey;


    public HunterAccount() { }

    public HunterAccount(int id, String hunterAccount, String password, String headImage, String name, String tokenKey) {
        this.id = id;
        this.hunterAccount = hunterAccount;
        this.password = password;
        this.headImage = headImage;
        this.name = name;
        this.tokenKey = tokenKey;
    }

    //累赘
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHunterAccount() {
        return hunterAccount;
    }

    public void setHunterAccount(String hunterAccount) {
        this.hunterAccount = hunterAccount;
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
        return "HunterAccount{" +
                "id=" + id +
                ", hunterAccount='" + hunterAccount + '\'' +
                ", password='" + password + '\'' +
                ", headImage='" + headImage + '\'' +
                ", name='" + name + '\'' +
                ", tokenKey='" + tokenKey + '\'' +
                '}';
    }
}
