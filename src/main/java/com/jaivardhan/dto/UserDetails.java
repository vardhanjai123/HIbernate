package com.jaivardhan.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {


    private int userId;

    private String userName;
    @Id
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName+"FROM GETTER METHOD";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
