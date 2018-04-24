package com.example.admin.parkingticket.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;



@Entity(foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "userID",
        childColumns = "userID"))

public class Ticket {

    @PrimaryKey(autoGenerate = true)
    private int ticketID;

    @ColumnInfo(name = "userID")
    private int userID;

    @ColumnInfo(name = "vehicleNumber")
    private String vehicleNumber;

    @ColumnInfo(name = "Carbrand")
    private String Carbrand;

    @ColumnInfo(name = "CarColor")
    private String CarColor;

    @ColumnInfo(name = "timing")
    private String timing;

    @ColumnInfo(name = "Lane")
    private String Lane;

    @ColumnInfo(name = "Spot")
    private String Spot;

    @ColumnInfo(name = "Payment")
    private String Payment;

    public Ticket(int userID, String vehicleNumber, String carbrand, String carColor, String timing, String lane, String spot, String payment) {
        this.userID = userID;
        this.vehicleNumber = vehicleNumber;
        Carbrand = carbrand;
        CarColor = carColor;
        this.timing = timing;
        Lane = lane;
        Spot = spot;
        Payment = payment;
    }

    public Ticket() {
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getCarbrand() {
        return Carbrand;
    }

    public void setCarbrand(String carbrand) {
        Carbrand = carbrand;
    }

    public String getCarColor() {
        return CarColor;
    }

    public void setCarColor(String carColor) {
        CarColor = carColor;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getLane() {
        return Lane;
    }

    public void setLane(String lane) {
        Lane = lane;
    }

    public String getSpot() {
        return Spot;
    }

    public void setSpot(String spot) {
        Spot = spot;
    }

    public String getPayment() {
        return Payment;
    }

    public void setPayment(String payment) {
        Payment = payment;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
