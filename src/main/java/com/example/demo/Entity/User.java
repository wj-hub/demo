package com.example.demo.Entity;

import javax.persistence.*;

@Table(name = "s_user")
public class User {
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "group_id")
    private String groupId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }



    public User(String userName, String phone, String groupId) {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
    }

    public User() {
    }
}
