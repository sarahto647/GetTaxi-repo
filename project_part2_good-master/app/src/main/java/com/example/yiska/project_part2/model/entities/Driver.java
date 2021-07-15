package com.example.yiska.project_part2.model.entities;

import java.io.Serializable;

public class Driver implements Serializable{
    private String fullName;
    private String id;
    private String phoneNumber;
    private String EMail;
    private String creditCardDebit;
    private String password;


    public Driver() {}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEMail() {
        return EMail;
    }

    public void setEMail(String EMail) {
        this.EMail = EMail;
    }

    public String getCreditCardDebit() {
        return creditCardDebit;
    }

    public void setCreditCardDebit(String creditCardDebit) {
        this.creditCardDebit = creditCardDebit;
    }
}
