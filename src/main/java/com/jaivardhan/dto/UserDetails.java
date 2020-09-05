package com.jaivardhan.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "USER_NAME")
    private String userName;
    //@Transient

    private Address address;

    @AttributeOverrides({
            @AttributeOverride(name = "street",column = @Column(name = "Office_Street")),
            @AttributeOverride(name = "city",column = @Column(name = "Office_City")),
            @AttributeOverride(name = "pincode",column = @Column(name = "Office_Pincode")),
            @AttributeOverride(name = "state",column = @Column(name = "Office_State"))
    })
    private Address officeAddress;

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    @Temporal(TemporalType.TIME)
    private Date joinedDate;

    @Lob
    private String description;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
