package com.jaivardhan.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

    @Id
    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "USER_NAME")
    private String userName;
    @Transient
    private String Address;
    @Temporal(TemporalType.TIME)
    private Date joinedDate;

    @Lob
    private String description;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName+"FROM GETTER METHOD";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
