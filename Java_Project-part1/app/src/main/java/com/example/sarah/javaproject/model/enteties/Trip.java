package com.example.sarah.javaproject.model.enteties;

import java.util.Objects;

public class Trip
{
    public enum STATUS {
        AVAILABLE, ON, DONE
    }
//    protected long id;
//
//    public String getIdDriver() {
//        return idDriver;
//    }
//
//    public void setIdDriver(String idDriver) {
//        this.idDriver = idDriver;
//    }
//
//    protected String idDriver;
    protected STATUS status;
    protected String placeBegin;
    protected String destination;
    protected String hourBegin;
    protected String hourEnd;
    protected String costumerName;
    protected String costumerTel;
    protected String costumerEmail;
    protected String driverName;
    private String creditCard;
    private String tripDate = "";

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getTripDate() {
        return tripDate;
    }

    public void setTripDate(String tripDate) {
        this.tripDate = tripDate;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    private float distance;



    public Trip(String placeBegin, String destination, String costumerName, String costumerTel, String costumerEmail) {
//        this.id = id;
        this.status = status;
        this.placeBegin = placeBegin;
        this.destination = destination;
        this.hourBegin = hourBegin;
        this.hourEnd = hourEnd;
        this.costumerName = costumerName;
        this.costumerTel = costumerTel;
        this.costumerEmail = costumerEmail;
    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public String getPlaceBegin() {
        return placeBegin;
    }

    public void setPlaceBegin(String placeBegin) {
        this.placeBegin = placeBegin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getHourBegin() {
        return hourBegin;
    }

    public void setHourBegin(String hourBegin) {
        this.hourBegin = hourBegin;
    }

    public String getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(String hourEnd) {
        this.hourEnd = hourEnd;
    }

    public String getCostumerName() {
        return costumerName;
    }

    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }

    public String getCostumerTel() {
        return costumerTel;
    }

    public void setCostumerTel(String costumerTel) {
        this.costumerTel = costumerTel;
    }

    public String getCostumerEmail() {
        return costumerEmail;
    }

    public void setCostumerEmail(String costumerEmail) {
        this.costumerEmail = costumerEmail;
    }

   }

