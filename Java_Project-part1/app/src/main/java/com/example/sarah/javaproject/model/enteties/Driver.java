package com.example.sarah.javaproject.model.enteties;

import java.util.Objects;

public class Driver
{
    protected String familyName;
    protected String name;
    protected int id;
    protected String phoneNumber;
    protected String eMail;
    protected String creditCardDebit;



    public Driver()
    {

        this.familyName = "";
        this.name = "";
        this.id = 0;
        this.phoneNumber = "";
        this.eMail = "";
        this.creditCardDebit = "";
    }

    public Driver(String familyName, String name, int id, String phoneNumber, String eMail, String creditCardDebit) {
        this.familyName = familyName;
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.creditCardDebit = creditCardDebit;
    }
    public Driver(Driver d) {
        this.familyName = d.getFamilyName();
        this.name = d.getName();
        this.id = d.getId();
        this.phoneNumber = d.getPhoneNumber();
        this.eMail = d.geteMail();
        this.creditCardDebit = d.getCreditCardDebit();
    }
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getCreditCardDebit() {
        return creditCardDebit;
    }

    public void setCreditCardDebit(String creditCardDebit) {
        this.creditCardDebit = creditCardDebit;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "familyName='" + familyName + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return creditCardDebit == driver.creditCardDebit &&
                familyName.equals(driver.familyName) &&
                name.equals(driver.name) &&
                phoneNumber.equals(driver.phoneNumber) &&
                eMail.equals(driver.eMail);
    }
}
