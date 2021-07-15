package com.example.yiska.project_part2.model.entities;

public class Trip implements java.io.Serializable {

    public enum STATUS {
        AVAILABLE, ON, DONE
    }

    private static final long serialVersionUID = 1L;

    protected long index;
    protected String id;
    protected String driverName;
    protected STATUS status;
    protected String placeBegin;
    protected String destination;
    protected String hourBegin;
    protected String hourEnd;
    protected String costumerName;
    protected String costumerEmail;
    protected String costumerTel;
    private String creditCard;
    private String tripDate = "";
    private float distance;

    public Trip() { }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTripDate() {
        return tripDate;
    }

    public void setTripDate(String rideDate) {
        this.tripDate = rideDate;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public String getHourBegin() {
        return hourBegin;
    }

    public void setHourBegin(String hourBegin) {
        this.hourBegin = hourBegin;
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

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

}
